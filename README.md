# MusicApi

[![](https://jitpack.io/v/caiyonglong/musicapi.svg)](https://jitpack.io/#caiyonglong/musicapi)

- 封装网易云、百度音乐、虾米音乐、QQ音乐Api
- 通过[DSBridge for Android](https://github.com/wendux/DSBridge-Android) 解决Android跨域问题，Android端解析调用[js音乐API](https://github.com/sunzongzheng/musicApi)的api
- 增加NeteaseMusicApi接口
- 具体的接口实现请看[MusicLake](https://github.com/caiyonglong/MusicLake)

## DSbridge使用
通过BaseApiImpl，调用js方法拼接api请求地址，然后AjaxHandler收到请求地址，再通过okhhtp请求，获取返回数据，然后在回到js组装返回数据。最后返回一个json字符串，在BaseApiImpl 回调方法中gson解析成具体对象。

## API
- 百度音乐Api接口定义 : BaiduApiService（具体实现在MusicLake）
- 网易音乐Api接口定义 : NeteaseApiService（具体实现在MusicLake）
- 在线歌单Api接口定义 : PlaylistApiService（具体实现在MusicLake）
- 音乐播放Api接口[app.native.js](musicapi/src/main/assets/dist/app.native.js) : 同PC端Api接口[sunzongzheng/musicApi/dist/app.native.js](https://github.com/sunzongzheng/musicApi/blob/master/dist/app.native.js)
为了节省时间，减少维护成本，PC端和Android端使用同一api js，使用 DSbridge 解决Android跨域问题， 实现Android js交互。具体接口实现在**BaseApiImpl**，app.native.js 包含的接口如下：

```
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
        .....
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
        .....
    }


    /**
     * 获取歌曲详情
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌曲Id
     * @param success 结果返回回调
     * @param fail 失败返回回调
     */
    fun getSongDetail(vendor: String, id: String, success: (result: SongDetail) -> Unit, fail: (() -> Unit)? = null) {
        .....
    }

    /**
     * 批量获取歌曲详情
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param ids 歌曲Ids [101126,16435051,139808]
     * @param success 成功回调
     */
    fun getBatchSongDetail(vendor: String, ids: Array<String>, success: (result: BatchSongDetail) -> Unit) {
        .....
    }


    /**
     * 获取服务器网易排行榜列表
     */
    fun getTopList(id: String, success: (result: NeteaseBean) -> Unit) {
        .....
    }


    /**
     * 获取歌词信息
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param success 成功回调
     */
    fun getLyricInfo(vendor: String, id: String, success: (result: LyricData) -> Unit) {
        .....
    }

    /**
     * 获取评论信息
     *
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 歌曲Id
     * @param success 成功回调
     */
    fun getComment(vendor: String, id: String, success: (result: Any) -> Unit, fail: ((String) -> Unit)? = null) {
        .....
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
        .....
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
        .....
    }

    /**
     * 获取专辑歌曲列表
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 专辑ID
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAlbumSongs(vendor: String, id: String, success: (result: ArtistSongsData) -> Unit, fail: ((String) -> Unit)? = null) {
        .....
    }

    /**
     * 获取专辑详情
     * @param vendor 歌曲类型 [qq,xiami,netease]
     * @param id 专辑ID
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAlbumDetail(vendor: String, id: String, success: (result: AlbumData) -> Unit, fail: ((String) -> Unit)? = null) {
        .....
    }

    /**
     * 获取歌手列表详情（qq歌手列表）
     * @param offset 偏移量
     * @param params 例：val params = mapOf("area" to area, "sex" to sex, "genre" to genre, "index" to index)
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getArtists(offset: Int, params: Any, success: (result: ArtistsData) -> Unit, fail: ((String) -> Unit)? = null) {
        .....
    }

    /**
     * 获取任意平台歌手详情
     * id，专辑ID
     * @param ids 歌手ID列表 map(id,vendor) 歌手id 和 歌曲类型 [qq,xiami,netease]
     * @param success 成功回调
     * @param fail 失败回调
     */
    fun getAnyVendorSongDetail(ids: MutableList<Map<String, String?>>, success: (result: MutableList<MusicInfo>) -> Unit, fail: ((String) -> Unit)? = null) {
        .....
    }
```
 

# Usage

Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
    		repositories {
	    		...
		    	maven { url 'https://jitpack.io' }
		    }
	}
```
Step 2. Add the dependency

```gradle
dependencies {
	        implementation 'com.github.caiyonglong:musicapi:1.0.3'
	    }
```

# Tips
- assets/dist/app.native.js文件更新，同步[sunzongzheng/musicApi/dist/app.native.js](https://github.com/sunzongzheng/musicApi/blob/master/dist/app.native.js)

