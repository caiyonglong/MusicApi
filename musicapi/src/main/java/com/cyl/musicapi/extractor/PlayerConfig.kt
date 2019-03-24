package com.cyl.musicapi.extractor

import com.squareup.moshi.Json

internal class PlayerConfig {

    @field:Json(name = "args")
    var args: PlayerArgs? = null
    @field:Json(name = "assets")
    var assets: Assets? = null

    class Assets {

        @field:Json(name = "js")
        var js: String? = null

    }
}