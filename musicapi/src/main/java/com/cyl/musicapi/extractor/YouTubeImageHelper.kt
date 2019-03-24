package com.cyl.musicapi.extractor

/**
 * Helps fetch thumbnails based on the video ID
 */
internal object YouTubeImageHelper {

    private const val PLACEHOLDER = "~id~"
    private const val QUALITY = "~quality~"

    //https://stackoverflow.com/a/2068371/895797
    private const val BASE_URL = "https://img.youtube.com/vi/$PLACEHOLDER/$QUALITY.jpg"

    private val QUALITIES = listOf(
            Thumbnail.QUALITY_MAX_RES,
            Thumbnail.QUALITY_STANDARD_DEFINITION,
            Thumbnail.QUALITY_HIGH_QUALITY,
            Thumbnail.QUALITY_MEDIUM_QUALITY,
            Thumbnail.QUALITY_DEFAULT
    )

    fun extractAll(videoId: String): List<Thumbnail> {
        return QUALITIES.map { extract(videoId, it) }
    }

    fun extract(videoId: String, quality: String): Thumbnail {
        return Thumbnail(replace(videoId, quality), quality)
    }

    private fun replace(videoId: String, quality: String): String {
        return BASE_URL.replace(PLACEHOLDER, videoId).replace(QUALITY, quality)
    }
}