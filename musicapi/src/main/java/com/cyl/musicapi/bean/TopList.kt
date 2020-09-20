package com.cyl.musicapi.bean

import com.cyl.musicapi.playlist.MusicInfo
import com.google.gson.annotations.SerializedName

/**
 * musicApi base json
 */
data class BaseApiBean<T>(@SerializedName("data")
                          val data: T,
                          @SerializedName("status")
                          val status: Boolean = false,
                          @SerializedName("msg")
                          val msg: String = "")

data class TopListBean(@SerializedName("cover")
                       val cover: String = "",
                       @SerializedName("playCount")
                       val playCount: Long = 0,
                       @SerializedName("id")
                       val id: String? = "",
                       @SerializedName("name")
                       val name: String? = null,
                       @SerializedName("description")
                       val description: String = "",
                       @SerializedName("list")
                       val list: List<MusicInfo>?)


