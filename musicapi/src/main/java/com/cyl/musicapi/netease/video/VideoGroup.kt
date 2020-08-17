package com.cyl.musicapi.netease.video


import android.util.Log
import com.google.gson.annotations.SerializedName

/**
 * 视频分类列表
 */
data class VideoGroup(@SerializedName("relatedVideoType")
                      val relatedVideoType: String? = null,
                      @SerializedName("selectTab")
                      val selectTab: Boolean = false,
                      @SerializedName("abExtInfo")
                      val abExtInfo: String? = null,
                      @SerializedName("name")
                      val name: String = "",
                      @SerializedName("id")
                      val id: Long = 0,
                      @SerializedName("url")
                      val url: String? = null,
                      @SerializedName("alg")
                      var alg: String)

/**
 * 视频列表
 */
data class NeteaseVideoData(
        @SerializedName("alg")
        var alg: String,
        @SerializedName("data")
        var `data`: NeteaseVideoBean<Creator>,
        @SerializedName("displayed")
        var displayed: Boolean,
        @SerializedName("extAlg")
        var extAlg: String,
        @SerializedName("type")
        var type: Int
)

data class NeteaseVideoBean<T>(
        @SerializedName("alg")
        var alg: String,
        @SerializedName("commentCount")
        var commentCount: Long,
        @SerializedName("coverUrl")
        var coverUrl: String,
        @SerializedName("creator")
        var creator: T?,
        @SerializedName("description")
        var description: String,
        @SerializedName("durationms")
        var durationms: Long,
        @SerializedName("hasRelatedGameAd")
        var hasRelatedGameAd: Boolean,
        @SerializedName("height")
        var height: Int,
        @SerializedName("markTypes")
        var markTypes: Any,
        @SerializedName("playTime")
        var playTime: Long,
        @SerializedName("praised")
        var praised: Boolean,
        @SerializedName("praisedCount")
        var praisedCount: Long,
        @SerializedName("previewDurationms")
        var previewDurationms: Long,
        @SerializedName("previewUrl")
        var previewUrl: String,
        @SerializedName("relateSong")
        var relateSong: List<RelateSong>,
        @SerializedName("relatedInfo")
        var relatedInfo: Any,
        @SerializedName("resolutions")
        var resolutions: List<Resolution>,
        @SerializedName("scm")
        var scm: String,
        @SerializedName("shareCount")
        var shareCount: Long,
        @SerializedName("subscribed")
        var subscribed: Boolean,
        @SerializedName("threadId")
        var threadId: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("urlInfo")
        var urlInfo: Any,
        @SerializedName("vid")
        var vid: String?,
        @SerializedName("videoGroup")
        var videoGroup: List<VideoGroup>,
        @SerializedName("videoUserLiveInfo")
        var videoUserLiveInfo: Any,
        @SerializedName("width")
        var width: Int,

        //mv类别视频type=2,没有vid字段，只有id
        @SerializedName("id")
        var id: String?,
        @SerializedName("name")
        var name: String = "",
        @SerializedName("playCount")
        var playCount: Long,
        @SerializedName("likeCount")
        var likeCount: Long,
        @SerializedName("duration")
        var duration: Long,
        @SerializedName("artists")
        var artists: MutableList<MvArtist>?
)

data class MvArtist(
        @SerializedName("followed")
        var followed: Boolean,
        @SerializedName("id")
        var id: String,
        @SerializedName("img1v1Url")
        var img1v1Url: String,
        @SerializedName("name")
        var name: String
)

data class VideoCreator(
        @SerializedName("userId")
        var userId: String,
        @SerializedName("userName")
        var userName: String)

data class Creator(
        @SerializedName("accountStatus")
        var accountStatus: Int,
        @SerializedName("authStatus")
        var authStatus: Int,
        @SerializedName("authority")
        var authority: Int,
        @SerializedName("avatarImgId")
        var avatarImgId: Long,
        @SerializedName("avatarImgIdStr")
        var avatarImgIdStr: String,
//        @SerializedName("avatarImgId_str")
//        var avatarImgId_str: String,
        @SerializedName("avatarUrl")
        var avatarUrl: String,
        @SerializedName("backgroundImgId")
        var backgroundImgId: Long,
        @SerializedName("backgroundImgIdStr")
        var backgroundImgIdStr: String,
        @SerializedName("backgroundUrl")
        var backgroundUrl: String,
        @SerializedName("birthday")
        var birthday: Long,
        @SerializedName("city")
        var city: Int,
        @SerializedName("defaultAvatar")
        var defaultAvatar: Boolean,
        @SerializedName("description")
        var description: String,
        @SerializedName("detailDescription")
        var detailDescription: String,
        @SerializedName("djStatus")
        var djStatus: Int,
        @SerializedName("expertTags")
        var expertTags: Any,
        @SerializedName("experts")
        var experts: Any,
        @SerializedName("followed")
        var followed: Boolean,
        @SerializedName("gender")
        var gender: Int,
        @SerializedName("mutual")
        var mutual: Boolean,
        @SerializedName("nickname")
        var nickname: String,
        @SerializedName("province")
        var province: Int,
        @SerializedName("remarkName")
        var remarkName: Any,
        @SerializedName("signature")
        var signature: String,
        @SerializedName("userId")
        var userId: String,
        @SerializedName("userType")
        var userType: Int,
        @SerializedName("vipType")
        var vipType: Int
)

data class RelateSong(
        @SerializedName("a")
        var a: Any,
        @SerializedName("al")
        var al: Al,
        @SerializedName("alia")
        var alia: List<Any>,
        @SerializedName("ar")
        var ar: List<Ar>,
        @SerializedName("cd")
        var cd: String,
        @SerializedName("cf")
        var cf: String,
        @SerializedName("copyright")
        var copyright: Int,
        @SerializedName("cp")
        var cp: Int,
        @SerializedName("crbt")
        var crbt: Any,
        @SerializedName("djId")
        var djId: Int,
        @SerializedName("dt")
        var dt: Int,
        @SerializedName("fee")
        var fee: Int,
        @SerializedName("ftype")
        var ftype: Int,
        @SerializedName("h")
        var h: H,
        @SerializedName("id")
        var id: Int,
        @SerializedName("l")
        var l: L,
        @SerializedName("m")
        var m: M,
        @SerializedName("mst")
        var mst: Int,
        @SerializedName("mv")
        var mv: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("no")
        var no: Int,
        @SerializedName("pop")
        var pop: Int,
        @SerializedName("privilege")
        var privilege: Privilege,
        @SerializedName("pst")
        var pst: Int,
        @SerializedName("publishTime")
        var publishTime: Long,
        @SerializedName("rt")
        var rt: String,
        @SerializedName("rtUrl")
        var rtUrl: Any,
        @SerializedName("rtUrls")
        var rtUrls: List<Any>,
        @SerializedName("rtype")
        var rtype: Int,
        @SerializedName("rurl")
        var rurl: Any,
        @SerializedName("s_id")
        var sId: Int,
        @SerializedName("st")
        var st: Int,
        @SerializedName("t")
        var t: Int,
        @SerializedName("v")
        var v: Int
)

data class Resolution(
        @SerializedName("resolution")
        var resolution: Int,
        @SerializedName("size")
        var size: Int
)


data class Al(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("pic")
        var pic: Long,
        @SerializedName("pic_str")
        var picStr: String,
        @SerializedName("picUrl")
        var picUrl: String,
        @SerializedName("tns")
        var tns: List<Any>
)

data class Ar(
        @SerializedName("alias")
        var alias: List<Any>,
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("tns")
        var tns: List<Any>
)

data class H(
        @SerializedName("br")
        var br: Int,
        @SerializedName("fid")
        var fid: Int,
        @SerializedName("size")
        var size: Long,
        @SerializedName("vd")
        var vd: Double
)

data class L(
        @SerializedName("br")
        var br: Int,
        @SerializedName("fid")
        var fid: Int,
        @SerializedName("size")
        var size: Long,
        @SerializedName("vd")
        var vd: Double
)

data class M(
        @SerializedName("br")
        var br: Int,
        @SerializedName("fid")
        var fid: Int,
        @SerializedName("size")
        var size: Long,
        @SerializedName("vd")
        var vd: Double
)

data class Privilege(
        @SerializedName("cp")
        var cp: Int,
        @SerializedName("cs")
        var cs: Boolean,
        @SerializedName("dl")
        var dl: Int,
        @SerializedName("fee")
        var fee: Int,
        @SerializedName("fl")
        var fl: Int,
        @SerializedName("flag")
        var flag: Int,
        @SerializedName("id")
        var id: Int,
        @SerializedName("maxbr")
        var maxbr: Int,
        @SerializedName("payed")
        var payed: Int,
        @SerializedName("pl")
        var pl: Int,
        @SerializedName("preSell")
        var preSell: Boolean,
        @SerializedName("sp")
        var sp: Int,
        @SerializedName("st")
        var st: Int,
        @SerializedName("subp")
        var subp: Int,
        @SerializedName("toast")
        var toast: Boolean
)

data class VideoUrlInfo(
        @SerializedName("code")
        var code: Int,
        @SerializedName("urls")
        var urls: List<VideoUrlBean>,
        @SerializedName("data")
        var data: VideoUrlBean?
)

data class VideoUrlBean(
        @SerializedName("id")
        var id: String,
        @SerializedName("needPay")
        var needPay: Boolean,
        @SerializedName("payInfo")
        var payInfo: Any,
        @SerializedName("r")
        var r: Int,
        @SerializedName("size")
        var size: Long,
        @SerializedName("url")
        var url: String,
        @SerializedName("validityTime")
        var validityTime: Int
)