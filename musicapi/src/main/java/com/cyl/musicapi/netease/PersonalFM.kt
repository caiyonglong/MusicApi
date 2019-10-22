package com.cyl.musicapi.netease


import com.google.gson.annotations.SerializedName

data class PersonalFMData(@SerializedName("no")
                    val no: Int = 0,
                    @SerializedName("copyright")
                    val copyright: Int = 0,
                    @SerializedName("dayPlays")
                    val dayPlays: Int = 0,
                    @SerializedName("fee")
                    val fee: Int = 0,
                    @SerializedName("privilege")
                    val privilege: Privilege,
                    @SerializedName("mMusic")
                    val mMusic: MMusic,
                    @SerializedName("bMusic")
                    val bMusic: BMusic,
                    @SerializedName("duration")
                    val duration: Int = 0,
                    @SerializedName("score")
                    val score: Int = 0,
                    @SerializedName("rtype")
                    val rtype: Int = 0,
                    @SerializedName("starred")
                    val starred: Boolean = false,
                    @SerializedName("artists")
                    val artists: MutableList<ArtistsItem>?,
                    @SerializedName("popularity")
                    val popularity: Int = 0,
                    @SerializedName("playedNum")
                    val playedNum: Int = 0,
                    @SerializedName("hearTime")
                    val hearTime: Int = 0,
                    @SerializedName("starredNum")
                    val starredNum: Int = 0,
                    @SerializedName("id")
                    val id: Long = 0,
                    @SerializedName("alg")
                    val alg: String = "",
                    @SerializedName("album")
                    val album: Album,
                    @SerializedName("lMusic")
                    val lMusic: LMusic,
                    @SerializedName("ringtone")
                    val ringtone: String = "",
                    @SerializedName("commentThreadId")
                    val commentThreadId: String = "",
                    @SerializedName("copyFrom")
                    val copyFrom: String = "",
                    @SerializedName("ftype")
                    val ftype: Long = 0,
                    @SerializedName("copyrightId")
                    val copyrightId: Long = 0,
                    @SerializedName("hMusic")
                    val hMusic: HMusic,
                    @SerializedName("mvid")
                    val mvid: Long = 0,
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("disc")
                    val disc: String = "",
                    @SerializedName("position")
                    val position: Int = 0,
                    @SerializedName("mark")
                    val mark: Int = 0,
                    @SerializedName("status")
                    val status: Int = 0)


data class PersonalFM(@SerializedName("code")
                      val code: Int = 0,
                      @SerializedName("data")
                      val data: MutableList<PersonalFMData>?,
                      @SerializedName("popAdjust")
                      val popAdjust: Boolean = false)


