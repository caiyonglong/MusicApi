package com.cyl.musicapi.netease


import com.google.gson.annotations.SerializedName

data class MvInfo(@SerializedName("code")
                  val code: Int = 0,
                  @SerializedName("data")
                  val data: MutableList<MvInfoDetail>?,
                  @SerializedName("hasMore")
                  val hasMore: Boolean = false,
                  @SerializedName("updateTime")
                  val updateTime: Long = 0)


data class MvInfoDetail(@SerializedName("lastRank")
                        val lastRank: Int = 0,
                        @SerializedName("artistId")
                        val artistId: Int = 0,
                        @SerializedName("cover")
                        val cover: String = "",
                        @SerializedName("duration")
                        val duration: Long = 0,
                        @SerializedName("playCount")
                        val playCount: Long = 0,
                        @SerializedName("score")
                        val score: Int = 0,
                        @SerializedName("subed")
                        val subed: Boolean = false,
                        @SerializedName("briefDesc")
                        val briefDesc: String = "",
                        @SerializedName("artists")
                        val artists: MutableList<ArtistsItem>?,
                        @SerializedName("name")
                        val name: String = "",
                        @SerializedName("artistName")
                        val artistName: String = "",
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("mark")
                        val mark: Int = 0,
                        @SerializedName("desc")
                        val desc: String = "")


data class MvDetailInfo(@SerializedName("code")
                        val code: Int = 0,
                        @SerializedName("data")
                        val data: MvInfoDetailInfo)


data class SimilarMvInfo(@SerializedName("code")
                         val code: Int = 0,
                         @SerializedName("mvs")
                         val data: MutableList<MvInfoDetail>?)

data class MvInfoDetailInfo(
        @SerializedName("artistId")
        var artistId: Int,
        @SerializedName("artistName")
        var artistName: String,
        @SerializedName("artists")
        var artists: MutableList<MvArtist>,
        @SerializedName("briefDesc")
        var briefDesc: String,
        @SerializedName("brs")
        var brs: MutableList<Br>,
        @SerializedName("commentCount")
        var commentCount: Long,
        @SerializedName("commentThreadId")
        var commentThreadId: String,
        @SerializedName("cover")
        var cover: String,
        @SerializedName("coverId")
        var coverId: Long,
        @SerializedName("coverId_str")
        var coverIdStr: String,
        @SerializedName("desc")
        var desc: String?,
        @SerializedName("duration")
        var duration: Long,
        @SerializedName("id")
        var id: Int,
        @SerializedName("nType")
        var nType: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("playCount")
        var playCount: Long,
        @SerializedName("price")
        var price: Any,
        @SerializedName("publishTime")
        var publishTime: String,
        @SerializedName("shareCount")
        var shareCount: Long,
        @SerializedName("subCount")
        var subCount: Long,
        @SerializedName("videoGroup")
        var videoGroup: MutableList<VideoGroup>
)

data class MvArtist(
        @SerializedName("followed")
        var followed: Boolean,
        @SerializedName("id")
        var id: Int,
        @SerializedName("img1v1Url")
        var img1v1Url: String,
        @SerializedName("name")
        var name: String
)

data class Br(
        @SerializedName("br")
        var br: Long,
        @SerializedName("point")
        var point: Int,
        @SerializedName("size")
        var size: Int
)

data class VideoGroup(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("type")
        var type: Int
)
