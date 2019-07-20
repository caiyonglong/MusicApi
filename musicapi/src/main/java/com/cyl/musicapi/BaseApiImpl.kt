package com.cyl.musicapi

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import com.cyl.musicapi.bean.*
import com.cyl.musicapi.dsbridge.CompletionHandler
import com.cyl.musicapi.dsbridge.DWebView
import com.cyl.musicapi.playlist.MusicInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


/**
 * Created by master on 2018/5/15.
 * 调用js方法请求数据
 * 原理js拼接url,接收返回参数，然后数据处理再返回到java中。
 */
object BaseApiImpl {

    private val gson = Gson()
    var mWebView: DWebView? = null

    fun initWebView(context: Context) {
        initAssets()
        try {
            mWebView = DWebView(context)
            mWebView?.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(p0: WebView?, p1: String?): Boolean {
                    return false
                }
            }
            DWebView.setWebContentsDebuggingEnabled(true)
            mWebView?.addJavascriptObject(object : Any() {
                @JavascriptInterface
                fun onAjaxRequest(requestData: Any, handler: CompletionHandler<String>) {
                    Log.e("TAG", "-----" + requestData.toString())
                    AjaxHandler.onAjaxRequest(requestData as JSONObject, handler)
                }
            }, null)
            mWebView?.loadUrl("file:///android_asset/musicApi.html")
        } catch (e: Throwable) {
            Log.e("BaseApiImpl", e.message)
        }
    }

    /**
     * 初始化js文件
     */
    private fun initAssets() {
    }

    /**
     * 搜索
     *
     * @param query 搜索文本
     * @param limit 每页多少歌曲
     * @param offset 偏移量
     * @param success 结果返回回调
     * @param fail 失败返回回调
     */
    fun searchSong(query: String, limit: Int, offset: Int, success: (result: SearchData) -> Unit, fail: ((String?) -> Unit)? = null) {
        mWebView?.callHandler("api.searchSong", arrayOf(query, limit, offset)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<SearchData>(retValue.toString(), SearchData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                Log.e("BaseApiImpl", e.message)
                e.printStackTrace()
                fail?.invoke(e.message)
            }
        }
    }

    /**
     * 独立请求
     * @param query 搜索文本
     * @param type 歌曲类型 [QQ,XIAMI,NETEASE]
     * @param limit 每页多少歌曲
     * @param offset 偏移量
     * @param success 结果返回回调
     */
    fun searchSongSingle(query: String, type: String, limit: Int, offset: Int, success: (result: SearchSingleData) -> Unit) {
        val params = mapOf("keyword" to query, "limit" to limit, "offset" to offset)
        Log.e("searchSongSingle", params.toString())
        when (type) {
            "QQ" -> {
                mWebView?.callHandler("api.searchQQSong", arrayOf(params)) { retValue: JSONObject ->
                    val result = gson.fromJson<SearchSingleData>(retValue.toString(), SearchSingleData::class.java)
                    Log.e("searchQQSong", retValue.toString())
                    success.invoke(result)
                }
            }
            "XIAMI" -> {
                mWebView?.callHandler("api.searchXiamiSong", arrayOf(params)) { retValue: JSONObject ->
                    val result = gson.fromJson<SearchSingleData>(retValue.toString(), SearchSingleData::class.java)
                    Log.e("searchXiamiSong", retValue.toString())
                    success.invoke(result)
                }
            }
            "NETEASE" -> {
                mWebView?.callHandler("api.searchNeteaseSong", arrayOf(params)) { retValue: JSONObject ->
                    val result = gson.fromJson<SearchSingleData>(retValue.toString(), SearchSingleData::class.java)
                    Log.e("searchNeteaseSong", retValue.toString())
                    success.invoke(result)
                }
            }
        }
    }


    /**
     * 获取歌曲详情
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌曲Id
     * @param success 结果返回回调
     * @param fail 失败返回回调
     */
    fun getSongDetail(vendor: String, id: String, success: (result: SongDetail) -> Unit, fail: (() -> Unit)? = null) {
        mWebView?.callHandler("api.getSongDetail", arrayOf<Any>(vendor, id)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<SongDetail>(retValue.toString(), SongDetail::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                fail?.invoke()
            }
        }
    }

    /**
     * 批量获取歌曲详情
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param ids 歌曲Ids [101126,16435051,139808]
     * @param success 成功回调
     */
    fun getBatchSongDetail(vendor: String, ids: Array<String>, success: (result: BatchSongDetail) -> Unit) {
        mWebView?.callHandler("api.getBatchSongDetail", arrayOf<Any>(vendor, ids)) { retValue: JSONObject ->
            val result = gson.fromJson<BatchSongDetail>(retValue.toString(), BatchSongDetail::class.java)
            success.invoke(result)
        }
    }


    /**
     * 获取服务器网易排行榜列表
     */
    fun getTopList(id: String, success: (result: NeteaseBean) -> Unit) {
        mWebView?.callHandler("api.getTopList", arrayOf<Any>(id)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<NeteaseBean>(retValue.toString(), NeteaseBean::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                Log.e("getTopList", e.message)
            }
        }
    }


    /**
     * 获取歌词信息
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param success 成功回调
     */
    fun getLyricInfo(vendor: String, id: String, success: (result: LyricData) -> Unit) {
        mWebView?.callHandler("api.getLyric", arrayOf<Any>(vendor, id)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<LyricData>(retValue.toString(), LyricData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                Log.e("getTopList", e.message)
            }
        }
    }

    /**
     * 获取评论信息
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌曲Id
     * @param success 成功回调
     */
    fun getComment(vendor: String, id: String, success: (result: Any) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getComment", arrayOf(vendor, id, 1, 50)) { retValue: JSONObject ->
            if (retValue["status"] as Boolean) {
                println(retValue.toString())
                val rr = retValue.getJSONObject("data").getJSONArray("comments")?.getJSONObject(0)
                rr?.let {
                    if (rr.has("user")) {
                        val objectType = object : TypeToken<SongCommentData<NeteaseComment>>() {}.type
                        val data = gson.fromJson<SongCommentData<NeteaseComment>>(retValue.toString(), objectType)
                        success.invoke(data)
                    }
                    if (rr.has("avatarurl")) {
                        val objectType = object : TypeToken<SongCommentData<QQComment>>() {}.type
                        val data = gson.fromJson<SongCommentData<QQComment>>(retValue.toString(), objectType)
                        success.invoke(data)
                    }
                    if (rr.has("avatar")) {
                        val objectType = object : TypeToken<SongCommentData<XiamiComment>>() {}.type
                        val data = gson.fromJson<SongCommentData<XiamiComment>>(retValue.toString(), objectType)
                        success.invoke(data)
                    }
                }
            } else {
                fail?.invoke(retValue["msg"].toString())
            }
        }
    }

    /**
     * 获取播放地址
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌曲Id
     * @param br 音质 默认12800
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getSongUrl(vendor: String, id: String, br: Int = 128000, success: (result: SongBean) -> Unit, fail: (() -> Unit)? = null) {
        mWebView?.callHandler("api.getSongUrl", arrayOf<Any>(vendor, id, br)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<SongBean>(retValue.toString(), SongBean::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                fail?.invoke()
            }
        }
    }

    /**
     * 获取歌手单曲列表
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌手ID
     * @param offset 偏移量
     * @param limit 每页限制
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getArtistSongs(vendor: String, id: String, offset: Int, limit: Int, success: (result: ArtistSongsData) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getArtistSongs", arrayOf<Any>(vendor, id, offset, limit)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<ArtistSongsData>(retValue.toString(), ArtistSongsData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                e.message?.let { fail?.invoke(it) }
            }
        }
    }

    /**
     * 获取专辑歌曲列表
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 专辑ID
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAlbumSongs(vendor: String, id: String, success: (result: ArtistSongsData) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getAlbumSongs", arrayOf<Any>(vendor, id)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<ArtistSongsData>(retValue.toString(), ArtistSongsData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                e.message?.let { fail?.invoke(it) }
            }
        }
    }

    /**
     * 获取专辑详情
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 专辑ID
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAlbumDetail(vendor: String, id: String, success: (result: AlbumData) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getAlbumDetail", arrayOf<Any>(vendor, id)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<AlbumData>(retValue.toString(), AlbumData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                e.message?.let { fail?.invoke(it) }
            }
        }
    }

    /**
     * 获取歌手列表详情（qq歌手列表）
     * @param offset 偏移量
     * @param params 例：val params = mapOf("area" to area, "sex" to sex, "genre" to genre, "index" to index)
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getArtists(offset: Int, params: Any, success: (result: ArtistsData) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getArtists", arrayOf(offset, params)) { retValue: JSONObject ->
            try {
                val result = gson.fromJson<ArtistsData>(retValue.toString(), ArtistsData::class.java)
                success.invoke(result)
            } catch (e: Throwable) {
                e.message?.let { fail?.invoke(it) }
            }
        }
    }

    /**
     * 获取任意平台歌手详情
     * id，专辑ID
     * @param ids 歌手ID列表 map(id,vendor) 歌手id 和 歌曲类型 [qq,xiami,netease]
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAnyVendorSongDetail(ids: MutableList<Map<String, String?>>, success: (result: MutableList<MusicInfo>) -> Unit, fail: ((String) -> Unit)? = null) {
        mWebView?.callHandler("api.getAnyVendorSongDetail", arrayOf<Any>(ids)) { retValue: JSONArray ->
            try {
                val listType = object : TypeToken<LinkedList<MusicInfo>>() {}.type
                val result = gson.fromJson<MutableList<MusicInfo>>(retValue.toString(), listType)
                success.invoke(result)
            } catch (e: Throwable) {
                e.message?.let { fail?.invoke(it) }
            }
        }
    }
}
