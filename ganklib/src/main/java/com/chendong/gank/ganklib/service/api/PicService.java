package com.chendong.gank.ganklib.service.api;

import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.ganklib.bean.Result;
import com.chendong.gank.ganklib.service.limit.WhereHandler;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:18
 * 注释：
 */
public interface PicService {
    /**
     * 获取所有图片
     * @param size 返回数量，不要超过100
     * @return 返回所有类型图片列表
     */
    @GET("Pic")
    Call<PicsBean> getAllPicList(@Query("order")String order);



    /**
     * 获取指定图片列表
     * @param size 返回数量
     * @param skip 跳过数量
     * @return 返回所有类型图片列表
     */
    @GET("Pic")
    Call<PicsBean> getPicList(@Query("limit")int size,@Query("skip")int skip);
    /**
     * 指定类型图片列表
     * @param size 返回数量，不要超过100
     * @param type Map<String,String>  {"type":"fuli"}
     * @return 返回指定类型图片列表
     */
    @GET("Pic")
    Call<PicsBean> getPicList(@Query("limit")int size, @Query("where")WhereHandler type);

    /**
     * 获取单张图片信息
     * @param objectId 图片ID
     * @return
     */
    @GET("Pic/{objectId}")
    Call<PicsBean> getPic(@Part("objectId")String objectId);


    /**
     * 上传图片
     * @return
     */
    @POST("Pic")
    Call<Result> postPic();





}
