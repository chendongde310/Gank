# Gank
基于retrofit的网络请求整合库，可以直接获取图片、新闻、视频等资源调用，免去了接口开发流程，更专注功能研发

目前整合数据：图片+ 新闻 + 文章精选 +（福利图）
视频 、音乐陆续添加中

提供给gsd1602的小伙伴免费使用

点击下载 [Demo](http://ac-nuiddhh1.clouddn.com/62b258a99256dd8f2f33.apk).
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
	        compile 'com.github.chendongde310:Gank:1.0.1'
	}
  
  


  
  
  
### Example
####Gank
#####First
在Application中初始化

        //初始化服务器
        NetWorkRequest.getInstance().initGank(this);
        //设置开发者模式 ，默认为 false
        NetWorkRequest.setDeveloperMode(true);

##### Next
        //此处调用ganklib方法来加载图片
        //getInstance() 获取接口管理员
        //initPic()  初始化图片接口
        //getPicList(10) 获取图片（条数）
        //enqueue 异步请求
        //Callback 回调   onResponse --成功      onFailure-- 失败
        ApiManager.getInstance().initPic().getAllPicList().enqueue(new Callback<PicsBean>() {
            @Override
            public void onResponse(Call<PicsBean> call, Response<PicsBean> response) {
                setPicListView(response.body());//获取数据成功设置UI
            }

            @Override
            public void onFailure(Call<PicsBean> call, Throwable t) {
                t.printStackTrace();
            }
        });

####customization
在Application中初始化

       //自定义retrofit      
        NetWorkRequest.getInstance().init(this,YOU_URL);
        //设置开发者模式
        NetWorkRequest.setDeveloperMode(true);


        //使用方法
        NetWorkRequest.getInstance().create(YourService.class);


