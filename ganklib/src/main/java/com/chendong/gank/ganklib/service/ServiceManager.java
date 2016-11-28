package com.chendong.gank.ganklib.service;

import com.chendong.gank.ganklib.service.api.PicService;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 14:20
 * 注释：请求服务器管理器
 */
public class ServiceManager {

    private static ServiceManager serviceManager;

    public static ServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

    /**
     * 获取图片加载服务器
     * @return
     */
    public PicService getPicService() {
        return ApiManager.getInstance().initPic();
    }


}
