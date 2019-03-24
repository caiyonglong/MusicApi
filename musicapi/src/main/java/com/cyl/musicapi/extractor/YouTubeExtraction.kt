package com.cyl.musicapi.extractor

import com.cyl.musicapi.extractor.Thumbnail
import com.cyl.musicapi.extractor.VideoStream

/**
 * The result of [YouTubeExtractor.extract]
 */
data class YouTubeExtraction(
        val videoId: String,
        val title: String?,
        val videoStreams: List<VideoStream>,
        val thumbnails: List<Thumbnail>,
        val author: String?,
        val description: String?,
        val viewCount: Long?,
        val lengthSeconds: Long?
)
