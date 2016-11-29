package com.chendong.gank.gnak;

import android.app.Application;

import com.chendong.gank.ganklib.retrofit.NetWorkRequest;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:09
 * 注释：
 */
public class App extends Application {

    private static final String YOU_URL = "";

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化服务器
        NetWorkRequest.getInstance().initGank(this);
        //设置开发者模式
        NetWorkRequest.setDeveloperMode(true);


        /*
        //自定义retrofit YOU_URL
        NetWorkRequest.getInstance().init(this,YOU_URL);
        //设置开发者模式
        NetWorkRequest.setDeveloperMode(true);


        //使用方法
        NetWorkRequest.getInstance().create(YourService.class);
        */


    }
}
