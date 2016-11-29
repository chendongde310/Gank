package com.chendong.gank.ganklib.service.manager;

import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.ganklib.retrofit.NetWorkRequest;
import com.chendong.gank.ganklib.service.api.PicService;

import retrofit2.Call;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/29 - 15:11
 * 注释：文章API管理
 */
public class PicManager {


    private static PicManager apiManager;
    private PicService picService;

    private PicManager() {
        picService = NetWorkRequest.getInstance().create(PicService.class);
    }

    public static PicManager getInstance() {
        if (apiManager == null) {
            apiManager = new PicManager();

        }
        return apiManager;
    }


    /**
     * 获取所有文章
     *
     * @return PicService
     */
    public Call<PicsBean> getAllPicList() {
        return picService.getAllPicList("-updatedAt");
    }


    /**
     * 获取指定数量文章
     *
     * @return PicService
     */
    public Call<PicsBean> getPicList(int size, int skip) {
        return picService.getPicList(size, skip);
    }


    /**
     * 获取单篇文章
     *
     * @return PicService
     */
    public Call<PicsBean> getPic(String id) {
        return picService.getPic(id);
    }


}
