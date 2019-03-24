package com.cyl.musicapi.extractor

import com.squareup.moshi.Json

internal class PlayerArgs {

    @field:Json(name = "url_encoded_fmt_stream_map")
    var urlEncodedFmtStreamMap: String? = null
    @field:Json(name = "title")
    var title: String? = null
    @field:Json(name = "author")
    var author: String? = null
    @field:Json(name = "view_count")
    var viewCount: String? = null
    @field:Json(name = "length_seconds")
    var lengthSeconds: String? = null
}