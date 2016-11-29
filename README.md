# Gank
基于retrofit的网络请求整合库，可以直接获取图片、新闻、视频等资源调用，免去了接口开发流程，更专注功能研发

目前整合数据：图片（PicManager）+ 新闻 （NewsManager）+ 文章精选（ReadManager） +（福利图 →.→）
视频 、音乐陆续添加中

提供给gsd1602的小伙伴免费使用

点击下载 [Demo](http://ac-nuiddhh1.clouddn.com/bb9be957954684e3d3ca.apk).
------------------------------------------------

### Usage

Add it in your root build.gradle at the end of repositories:

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.chendongde310:Gank:1.0.3'
	}
  
  


  
  
  
### Example
####Gank  -   Gank服务器资源
--------------------------------------------
#####First
在Application中初始化

        //初始化服务器
        NetWorkRequest.getInstance().initGank(this);
        //设置开发者模式 ，默认为 false
        NetWorkRequest.setDeveloperMode(true);

##### Next

	PicManager.getInstance()// 获取接口实例
                .getAllPicList()//  获取所有图片
                .enqueue(new Callback<PicsBean>() {//enqueue 异步请求
                    @Override
                    public void onResponse(Call<PicsBean> call, final Response<PicsBean> response) {  	
                                // xxx..
                    }

                    @Override
                    public void onFailure(Call<PicsBean> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

####customization    -   自定义
--------------------------------------------
在Application中初始化

       //自定义retrofit      
        NetWorkRequest.getInstance().init(this,YOU_URL);
        //设置开发者模式
        NetWorkRequest.setDeveloperMode(true);


        //使用方法
        NetWorkRequest.getInstance().create(YourService.class);


