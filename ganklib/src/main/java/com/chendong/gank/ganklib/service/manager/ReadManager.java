package com.chendong.gank.ganklib.service.manager;

import com.chendong.gank.ganklib.bean.ReadBean;
import com.chendong.gank.ganklib.retrofit.NetWorkRequest;
import com.chendong.gank.ganklib.service.api.ReadService;

import retrofit2.Call;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/29 - 15:11
 * 注释：图片API管理
 */
public class ReadManager {


    private static ReadManager apiManager;
    private ReadService picService;

    private ReadManager() {
        picService = NetWorkRequest.getInstance().create(ReadService.class);
    }

    public static ReadManager getInstance() {
        if (apiManager == null) {
            apiManager = new ReadManager();

        }
        return apiManager;
    }


    /**
     * 获取所有图片
     *
     * @return ReadService
     */
    public Call<ReadBean> getAllReadList() {
        return picService.getAllReadList("-updatedAt");
    }


    /**
     * 获取所有图片
     *
     * @return ReadService
     */
    public Call<ReadBean> getReadList(int size,int skip) {
        return picService.getReadList(size,skip);
    }





    /**
     * 获取所有图片
     *
     * @return ReadService
     */
    public Call<ReadBean> getRead(String id) {
        return picService.getRead(id);
    }







}
