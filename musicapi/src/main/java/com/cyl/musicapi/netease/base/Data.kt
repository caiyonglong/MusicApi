package com.cyl.musicapi.netease.base

import com.google.gson.annotations.SerializedName

/**
 * 获取视频分类列表通用数据类
 */
data class NeteaseBaseData<T>(@SerializedName("code")
                              val code: Int = 0,
                              @SerializedName("data")
                              val data: T?,
                              @SerializedName("message")
                              val message: String?)

/**
 * 视频列表返回基类
 */
data class NeteaseVideoBaseData<T>(@SerializedName("code")
                                   val code: Int = 0,
                                   @SerializedName("datas")
                                   val data: MutableList<T>?,
                                   @SerializedName("msg")
                                   val msg: String = "",
                                   @SerializedName("message")
                                   val message: String?,
                                   @SerializedName("hasmore")
                                   val hasmore: Boolean = false,
                                   @SerializedName("rcmdLimit")
                                   val rcmdLimit: Int = 0)