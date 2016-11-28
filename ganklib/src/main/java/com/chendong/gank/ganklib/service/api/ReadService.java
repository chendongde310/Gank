package com.chendong.gank.ganklib.service.api;

import com.chendong.gank.ganklib.bean.ReadBean;
import com.chendong.gank.ganklib.bean.Result;
import com.chendong.gank.ganklib.service.limit.WhereHandler;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:18
 * 注释：
 */
public interface ReadService {
    /**
     * 指定类型文章列表
     * @param size 返回数量，不要超过100
     * @return 返回所有类型文章列表
     */
    @GET("Read")
    Call<ReadBean> getReadList(@Query("limit") int size,@Query("skip")int skip);


    /**
     * 所有文章列表
     * @return 返回所有文章列表
     */
    @GET("Read")
    Call<ReadBean> getAllReadList();

    /**
     * 指定类型文章列表
     * @param size 返回数量，不要超过100
     * @param type Map<String,String>  {"type":"fuli"}
     * @return 返回指定类型文章列表
     */
    @GET("Read")
    Call<ReadBean> getReadList(@Query("limit") int size, @Query("where") WhereHandler type);

    /**
     * 获取单张文章信息
     * @param objectId 文章ID
     * @return
     */
    @GET("Read/{objectId}")
    Call<ReadBean> getRead(@Part("objectId") String objectId);


    /**
     * 创建文章
     * @param bean
     * @return Result
     */
    @POST("Read")
    Call<Result> postRead(@Body ReadBean.ResultsBean bean);






}








