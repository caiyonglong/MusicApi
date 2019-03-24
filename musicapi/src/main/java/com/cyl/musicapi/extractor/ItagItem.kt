package com.cyl.musicapi.extractor

import com.musiclake.oversea.player.extractor.YouTubeExtractionException

internal class ItagItem(val id: Int, val format: String, val resolution: String) {

    companion object {

        /**
         * List can be found here https://github.com/rg3/youtube-dl/blob/master/youtube_dl/extractor/youtube.py#L360
         */
        private val ITAG_MAP = mapOf(

                17 to ItagItem(17, VideoStream.FORMAT_v3GPP, VideoStream.RESOLUTION_144p),

                18 to ItagItem(18, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_360p),
                34 to ItagItem(34, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_360p),
                35 to ItagItem(35, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_480p),
                36 to ItagItem(36, VideoStream.FORMAT_v3GPP, VideoStream.RESOLUTION_240p),
                59 to ItagItem(59, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_480p),
                78 to ItagItem(78, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_480p),
                22 to ItagItem(22, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_720p),
                37 to ItagItem(37, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_1080p),
                38 to ItagItem(38, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_1080p),

                43 to ItagItem(43, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_360p),
                44 to ItagItem(44, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_480p),
                45 to ItagItem(45, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_720p),
                46 to ItagItem(46, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_1080p),

                160 to ItagItem(160, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_144p),
                133 to ItagItem(133, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_240p),
                134 to ItagItem(134, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_360p),
                135 to ItagItem(135, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_480p),
                212 to ItagItem(212, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_480p),
                136 to ItagItem(136, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_720p),
                298 to ItagItem(298, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_720p60),
                137 to ItagItem(137, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_1080p),
                299 to ItagItem(299, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_1080p60),
                266 to ItagItem(266, VideoStream.FORMAT_MPEG_4, VideoStream.RESOLUTION_2160p),

                278 to ItagItem(278, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_144p),
                242 to ItagItem(242, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_240p),
                243 to ItagItem(243, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_360p),
                244 to ItagItem(244, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_480p),
                245 to ItagItem(245, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_480p),
                246 to ItagItem(246, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_480p),
                247 to ItagItem(247, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_720p),
                248 to ItagItem(248, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_1080p),
                271 to ItagItem(271, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_1440p),
                272 to ItagItem(272, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_2160p),
                302 to ItagItem(302, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_720p60),
                303 to ItagItem(303, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_1080p60),
                308 to ItagItem(308, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_1440p60),
                313 to ItagItem(313, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_2160p),
                315 to ItagItem(315, VideoStream.FORMAT_WEBM, VideoStream.RESOLUTION_2160p60)
        )


        fun isSupported(itag: Int?): Boolean {
            return ITAG_MAP.containsKey(itag)
        }

        fun getItag(itagId: Int?): ItagItem {
            return ITAG_MAP[itagId] ?: throw YouTubeExtractionException("itag=$itagId not supported")
        }
    }
}