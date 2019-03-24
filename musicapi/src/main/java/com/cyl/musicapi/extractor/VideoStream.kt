package com.cyl.musicapi.extractor


/**
 * A stream
 */
data class VideoStream(val url: String, val format: String, val resolution: String) {

    companion object {
        const val FORMAT_v3GPP = "v3GPP"
        const val FORMAT_MPEG_4 = "MPEG4"
        const val FORMAT_WEBM = "WEBM"

        const val RESOLUTION_144p = "144p"
        const val RESOLUTION_240p = "240p"
        const val RESOLUTION_360p = "360p"
        const val RESOLUTION_480p = "480p"
        const val RESOLUTION_720p = "720p"
        const val RESOLUTION_720p60 = "720p60"
        const val RESOLUTION_1080p = "1080p"
        const val RESOLUTION_1080p60 = "1080p60"
        const val RESOLUTION_1440p = "1440p"
        const val RESOLUTION_1440p60 = "1440p60"
        const val RESOLUTION_2160p = "2160p"
        const val RESOLUTION_2160p60 = "2160p60"
    }
}