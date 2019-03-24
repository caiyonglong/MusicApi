package com.cyl.musicapi.extractor

import com.squareup.moshi.Moshi
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.parser.Parser


/**
 * Class that allows you to extract stream data from a YouTube video
 * given its video id, which is typically contained within the YouTube video url, ie. https://www.youtube.com/watch?v=dQw4w9WgXcQ
 * has a video id of dQw4w9WgXcQ
 */
class YouTubeExtractor private constructor(builder: Builder) {

    companion object {

        private const val BASE_URL = "https://www.youtube.com"

        /**
         * Extract the thumbnails for the video. This will be done if you call
         * [extract] but since it is a lightweight operation, you can do it
         * synchronously if you choose
         */
        fun extractThumbnails(videoId: String): List<Thumbnail> {
            return YouTubeImageHelper.extractAll(videoId)
        }

        /**
         * Extract a thumbnail of a specific quality. See qualities within [Thumbnail]
         */
        fun extractThumbnail(videoId: String, quality: String): Thumbnail {
            return YouTubeImageHelper.extract(videoId, quality)
        }

        /**
         * Create a new YouTubeExtractor with a custom OkHttp client builder
         * @return a new [YouTubeExtractor]
         */
        @Deprecated("Use the Builder class instead", ReplaceWith("YouTubeExtractor.Builder().okHttpClientBuilder(okHttpBuilder).build()"))
        @JvmOverloads
        fun create(okHttpBuilder: OkHttpClient.Builder? = null): YouTubeExtractor {
            return Builder()
                    .okHttpClientBuilder(okHttpBuilder)
                    .build()
        }
    }

    private var client: OkHttpClient
    private var moshi: Moshi
    private var debug = false

    init {
        this.debug = builder.debug
        val clientBuilder = builder.okHttpClientBuilder ?: OkHttpClient.Builder()
        client = clientBuilder.build()
        moshi = Moshi.Builder()
                .build()
    }

    /**
     * Extract the video information
     * @param videoId the video ID
     * @return the extracted result
     */
    fun extract(videoId: String): Single<YouTubeExtraction> {
        return Single.defer {
            val url = "$BASE_URL/watch?v=$videoId"
            log("Extracting from URL $url")
            val pageContent = urlToString(url)
            val doc = Jsoup.parse(pageContent)

            val ytPlayerConfigJson = Util.matchGroup("ytplayer.config\\s*=\\s*(\\{.*?\\});", pageContent, 1)
            val ytPlayerConfig = moshi.adapter<PlayerConfig>(PlayerConfig::class.java).fromJson(ytPlayerConfigJson)!!
            val playerArgs = ytPlayerConfig.args!!
            val playerUrl = formatPlayerUrl(ytPlayerConfig)
            val videoStreams = parseVideoStreams(playerArgs, playerUrl)
            val description = tryIgnoringException { doc.select("p[id=\"eow-description\"]").first().html() }
            val extraction = YouTubeExtraction(videoId,
                    playerArgs.title,
                    videoStreams,
                    extractThumbnails(videoId),
                    playerArgs.author,
                    description,
                    playerArgs.viewCount?.toLongOrNull(),
                    playerArgs.lengthSeconds?.toLongOrNull())
            Single.just(extraction)
        }
    }

    private fun tryIgnoringException(block: () -> String): String? {
        try {
            return block.invoke()
        } catch (e: Exception) {
            //we tried our best
            log(e.message)
        }
        return null
    }

    private fun urlToString(url: String): String {
        val request = Request.Builder()
                .url(url)
                .build()

        return client.newCall(request)
                .execute()
                .body()
                ?.string() ?: throw Exception("Unable to connect")
    }

    private fun formatPlayerUrl(playerConfig: PlayerConfig): String {
        var playerUrl = playerConfig.assets?.js!!

        if (playerUrl.startsWith("//")) {
            playerUrl = "https:$playerUrl"
        }
        if (!playerUrl.startsWith(BASE_URL)) {
            playerUrl = BASE_URL + playerUrl
        }
        return playerUrl
    }

    private fun parseVideoStreams(playerArgs: PlayerArgs, playerUrl: String): List<VideoStream> {
        val itags = parseVideoItags(playerArgs, playerUrl)
        return itags.map { VideoStream(it.key, it.value.format, it.value.resolution) }
    }

    private fun parseVideoItags(playerArgs: PlayerArgs, playerUrl: String): Map<String, ItagItem> {
        val urlAndItags = LinkedHashMap<String, ItagItem>()
        val encodedUrlMap = playerArgs.urlEncodedFmtStreamMap ?: ""
        val validUrlData = encodedUrlMap.split(",".toRegex()).filter { it.isNotEmpty() }
        for (urlDataStr in validUrlData) {

            val tags = Util.compatParseMap(Parser.unescapeEntities(urlDataStr, true))

            val itag = tags["itag"]?.toInt()

            if (ItagItem.isSupported(itag)) {
                val itagItem = ItagItem.getItag(itag)
                var streamUrl = tags["url"]
                val signature = tags["s"]
                if (signature != null) {
                    log("Signature not found, decrypting signature for $streamUrl")
                    //TODO remove the need to remove all \n. It breaks the regex we have
                    val playerCode = urlToString(playerUrl)
                            .replace("\n", "")
                    streamUrl = streamUrl + "&signature=" + JavaScriptUtil.decryptSignature(signature, JavaScriptUtil.loadDecryptionCode(playerCode))
                }
                if (streamUrl != null) {
                    urlAndItags[streamUrl] = itagItem
                }
            }
        }

        return urlAndItags
    }

    private fun log(string: String?) {
        if (debug) {
            println(string)
        }
    }

    /**
     * Builds a [YouTubeExtractor] instance
     */
    class Builder {
        internal var debug = false
        internal var okHttpClientBuilder: OkHttpClient.Builder? = null

        /**
         * Forces logging to show for the [YouTubeExtractor]
         */
        fun debug(debug: Boolean): Builder {
            this.debug = debug
            return this
        }

        /**
         * Set a custom [OkHttpClient.Builder] on the [YouTubeExtractor]
         */
        fun okHttpClientBuilder(okHttpClientBuilder: OkHttpClient.Builder?): Builder {
            this.okHttpClientBuilder = okHttpClientBuilder
            return this
        }

        /**
         * Create the configured [YouTubeExtractor]
         */
        fun build(): YouTubeExtractor {
            return YouTubeExtractor(this)
        }
    }
}
