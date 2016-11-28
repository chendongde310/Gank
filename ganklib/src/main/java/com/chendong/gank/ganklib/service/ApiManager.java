package com.chendong.gank.ganklib.service;

import com.chendong.gank.ganklib.retrofit.NetWorkRequest;
import com.chendong.gank.ganklib.service.api.NewsService;
import com.chendong.gank.ganklib.service.api.PicService;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:14
 * 注释：
 */
public class ApiManager {

    private static ApiManager apiManager;

    private ApiManager() {
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    /**
     * 图片获取接口
     *
     * @return PicService
     */
    public PicService initPic() {
        return NetWorkRequest.getInstance().create(PicService.class);
    }

    /**
     * 图片获取接口
     *
     * @return NewsService
     */
    public NewsService initNews() {
        return NetWorkRequest.getInstance().create(NewsService.class);
    }


}
