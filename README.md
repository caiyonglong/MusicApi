# MusicApi

[![](https://jitpack.io/v/caiyonglong/musicapi.svg)](https://jitpack.io/#caiyonglong/musicapi)

- 封装网易云、百度音乐、虾米音乐、QQ音乐Api,有点大杂烩^O^ 
- 通过[DSBridge for Android](https://github.com/wendux/DSBridge-Android) 解决Android跨域问题，Android端解析调用[js音乐API](https://github.com/sunzongzheng/musicApi)api
- 具体的外调接口暂未总结，具体项目请看[MusicLake](https://github.com/caiyonglong/MusicLake)

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
	        implementation 'com.github.caiyonglong:musicapi:0.0.2'
	    }
```

# Tips
- assets/dist/app.native.js文件更新，同步[sunzongzheng/musicApi/dist/app.native.js](https://github.com/sunzongzheng/musicApi/blob/master/dist/app.native.js)

