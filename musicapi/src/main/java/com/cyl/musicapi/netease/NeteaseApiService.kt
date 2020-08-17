package com.cyl.musicapi.netease

import com.cyl.musicapi.netease.base.NeteaseBaseData
import com.cyl.musicapi.netease.base.NeteaseVideoBaseData
import com.cyl.musicapi.netease.video.*
import com.cyl.musicapi.netease.video.Creator
import com.cyl.musicapi.netease.video.VideoGroup
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by yonglong on 2017/9/11.
 */
interface NeteaseApiService {
    //    @Headers({"referer: http://music.163.com"})
    @GET("top/playlist")
    fun getTopPlaylist(@Query("cat") cat: String? = null, @Query("limit") limit: Int): Observable<NeteasePlaylist>

    @GET("/top/playlist/highquality")
    fun getTopPlaylistHigh(@QueryMap map: MutableMap<String, Any>): Observable<NeteasePlaylist>

    @GET("/playlist/detail")
    fun getPlaylistDetail(@Query("id") id: String): Observable<NeteasePlaylistDetail>

    //    @Headers({"referer: http://music.163.com"})
    @GET("/toplist/artist")
    fun getTopArtists(@Query("offset") offset: Int, @Query("limit") limit: Int): Observable<ArtistsInfo>

    /**
     * 获取最新mv
     */
    @GET("/mv/first")
    fun getNewestMv(@Query("limit") limit: Int): Observable<MvInfo>

    /**
     * 搜索
     */
    @GET
    fun searchNetease(@Url url: String): Observable<SearchInfo>

    /**
     * 获取mv排行榜
     */
    @GET("/top/mv")
    fun getTopMv(@Query("offset") offset: Int, @Query("limit") limit: Int): Observable<MvInfo>

    @GET("/mv/detail")
    fun getMvDetailInfo(@Query("mvid") mvid: String): Observable<MvDetailInfo>

    @GET("simi/mv")
    fun getSimilarMv(@Query("mvid") mvid: String): Observable<SimilarMvInfo>

    @GET("comment/{type}")
    fun getMvComment(@Path("type") type: String, @Query("id") id: String, @Query("offset") offset: Int = 0): Observable<MvComment>

    @GET("search/hot")
    fun getHotSearchInfo(): Observable<SearchInfo>

    @GET("playlist/catlist")
    fun getCatList(): Observable<CatListBean>

    @GET("banner")
    fun getBanner(): Observable<BannerResult>

    @GET("login/cellphone")
    fun loginPhone(@Query("phone") phone: String, @Query("password") password: String): Observable<LoginInfo>

    @GET("login")
    fun loginEmail(@Query("email") email: String, @Query("password") password: String): Observable<LoginInfo>

    /**
     * 注销登录
     */
    @GET("logout")
    fun logout(): Observable<Any>

    /**
     * 获取登录状态
     */
    @GET("/login/status")
    fun getLoginStatus(): Observable<LoginInfo>

    /**
     * 获取每日推荐歌曲（需登录）
     */
    @GET("recommend/songs")
    fun recommendSongs(): Observable<RecommendSongsInfo>

    /**
     * 获取每日推荐歌单（需登录）
     */
    @GET("recommend/resource")
    fun recommendPlaylist(): Observable<RecommendPlaylist>

    /**
     * 获取推荐歌单
     */
    @GET("/personalized")
    fun personalizedPlaylist(): Observable<PersonalizedInfo>

    /**
     * 获取推荐Mv
     */
    @GET("/personalized/mv")
    fun personalizedMv(): Observable<PersonalizedInfo>

    /**
     * 获取用户歌单
     */
    @GET("/user/playlist")
    fun getUserPlaylist(@Query("uid") uid: String): Observable<NeteasePlaylist>

    /**
     * 获取音乐榜单
     */
    @GET("/toplist/detail")
    fun getTopList(): Observable<TopList>

    /**
     * 获取私人FM
     */
    @GET("/personal_fm")
    fun getPersonalFM(): Observable<PersonalFM>

    /**
     * 获取视频分类列表
     */
    @GET("/video/category/list")
    fun getVideoGroupList(): Observable<NeteaseBaseData<MutableList<VideoGroup>>>

    /**
     * 获取视频分类列表
     */
    @GET("/video/group")
    fun getVideoList(@Query("id") id: String, @Query("offset") offset: Int = 0): Observable<NeteaseVideoBaseData<NeteaseVideoData>>

    /**
     * 获取视频详情
     */
    @GET("/video/detail")
    fun getVideoDetailInfo(@Query("id") id: String): Observable<NeteaseBaseData<NeteaseVideoBean<Creator>>>

    /**
     * 获取相关视频列表
     */
    @GET("/related/allvideo")
    fun getRelatedVideoList(@Query("id") id: String): Observable<NeteaseBaseData<MutableList<NeteaseVideoBean<MutableList<VideoCreator>>>>>

    /**
     * 获取视频播放地址
     */
    @GET("/video/url")
    fun getVideoUrlInfo(@Query("id") id: String): Observable<VideoUrlInfo>

    /**
     * 获取MV播放地址
     */
    @GET("/mv/url")
    fun getMvUrlInfo(@Query("id") id: String): Observable<VideoUrlInfo>
}
