package com.cyl.musicapi.extractor

/**
 * A video thumbnail
 */
data class Thumbnail(val url: String, val quality: String) {

    companion object {
        const val QUALITY_MAX_RES = "maxresdefault"
        const val QUALITY_STANDARD_DEFINITION = "sddefault"
        const val QUALITY_HIGH_QUALITY = "hqdefault"
        const val QUALITY_MEDIUM_QUALITY = "mqdefault"
        const val QUALITY_DEFAULT = "default"
    }
}