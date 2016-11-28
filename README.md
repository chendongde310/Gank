# Gank


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
	        compile 'com.github.chendongde310:Gank:1.0.0'
	}
  
  
  
  
  
### Example

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
