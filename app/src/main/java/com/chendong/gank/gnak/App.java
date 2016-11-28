package com.chendong.gank.gnak;

import android.app.Application;

import com.chendong.gank.ganklib.retrofit.NetWorkRequest;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:09
 * 注释：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化服务器
        NetWorkRequest.getInstance().initGank(this);
        //设置开发者模式
        NetWorkRequest.setDeveloperMode(true);
    }
}
