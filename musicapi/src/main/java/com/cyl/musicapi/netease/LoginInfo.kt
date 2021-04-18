package com.cyl.musicapi.netease


import com.google.gson.annotations.SerializedName

data class Account(@SerializedName("salt")
                   val salt: String = "",
                   @SerializedName("vipType")
                   val vipType: Long = 0,
                   @SerializedName("userName")
                   val userName: String = "",
                   @SerializedName("type")
                   val type: Long = 0,
                   @SerializedName("ban")
                   val ban: Long = 0,
                   @SerializedName("anonimousUser")
                   val anonimousUser: Boolean = false,
                   @SerializedName("createTime")
                   val createTime: Long = 0,
                   @SerializedName("tokenVersion")
                   val tokenVersion: Long = 0,
                   @SerializedName("id")
                   val id: Long = 0,
                   @SerializedName("whitelistAuthority")
                   val whitelistAuthority: Long = 0,
                   @SerializedName("baoyueVersion")
                   val baoyueVersion: Long = 0,
                   @SerializedName("viptypeVersion")
                   val viptypeVersion: Long = 0,
                   @SerializedName("donateVersion")
                   val donateVersion: Long = 0,
                   @SerializedName("status")
                   val status: Long = 0)


data class LoginInfo(@SerializedName("clientId")
                     val clientId: String = "",
                     @SerializedName("code")
                     val code: Long = 0,
                     @SerializedName("msg")
                     val msg: String = "",
                     @SerializedName("loginType")
                     val loginType: Long = 0,
                     @SerializedName("profile")
                     val profile: Profile,
                     @SerializedName("bindings")
                     val bindings: MutableList<BindingsItem>?,
                     @SerializedName("effectTime")
                     val effectTime: Long = 0,
                     @SerializedName("account")
                     val account: Account)


data class BindingsItem(@SerializedName("expiresIn")
                        val expiresIn: Long = 0,
                        @SerializedName("expired")
                        val expired: Boolean = false,
                        @SerializedName("tokenJsonStr")
                        val tokenJsonStr: String = "",
                        @SerializedName("refreshTime")
                        val refreshTime: Long = 0,
                        @SerializedName("id")
                        val id: Long = 0,
                        @SerializedName("type")
                        val type: Long = 0,
                        @SerializedName("userId")
                        val userId: Long = 0,
                        @SerializedName("url")
                        val url: String = "")


data class Profile(@SerializedName("detailDescription")
                   val detailDescription: String = "",
                   @SerializedName("birthday")
                   val birthday: Long = 0,
                   @SerializedName("backgroundUrl")
                   val backgroundUrl: String = "",
                   @SerializedName("gender")
                   val gender: Long = 0,
                   @SerializedName("city")
                   val city: Long = 0,
                   @SerializedName("signature")
                   val signature: String = "",
                   @SerializedName("description")
                   val description: String = "",
                   @SerializedName("remarkName")
                   val remarkName: String? = null,
                   @SerializedName("accountStatus")
                   val accountStatus: Long = 0,
                   @SerializedName("avatarImgId")
                   val avatarImgId: Long = 0,
                   @SerializedName("defaultAvatar")
                   val defaultAvatar: Boolean = false,
                   @SerializedName("avatarImgIdStr")
                   val avatarImgIdStr: String = "",
                   @SerializedName("backgroundImgIdStr")
                   val backgroundImgIdStr: String = "",
                   @SerializedName("province")
                   val province: Long = 0,
                   @SerializedName("nickname")
                   val nickname: String = "",
                   @SerializedName("djStatus")
                   val djStatus: Long = 0,
                   @SerializedName("avatarUrl")
                   val avatarUrl: String = "",
                   @SerializedName("authStatus")
                   val authStatus: Long = 0,
                   @SerializedName("vipType")
                   val vipType: Long = 0,
                   @SerializedName("followed")
                   val followed: Boolean = false,
                   @SerializedName("userId")
                   val userId: Long = 0,
                   @SerializedName("mutual")
                   val mutual: Boolean = false,
                   @SerializedName("authority")
                   val authority: Long = 0,
                   @SerializedName("backgroundImgId")
                   val backgroundImgId: Long = 0,
                   @SerializedName("userType")
                   val userType: Long = 0)


