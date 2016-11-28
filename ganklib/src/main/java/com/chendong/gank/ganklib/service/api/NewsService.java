package com.chendong.gank.ganklib.service.api;

import com.chendong.gank.ganklib.bean.NewsBean;
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
public interface NewsService {
    /**
     * 获取所有新闻
     * @param size 返回数量，不要超过100
     * @return 返回所有类型新闻列表
     */
    @GET("News")
    Call<NewsBean> getAllNewsList();



    /**
     * 获取指定新闻列表
     * @param size 返回数量
     * @param skip 跳过数量
     * @return 返回所有类型新闻列表
     */
    @GET("News")
    Call<NewsBean> getNewsList(@Query("limit") int size, @Query("skip") int skip);
    /**
     * 指定类型新闻列表
     * @param size 返回数量，不要超过100
     * @param type Map<String,String>  {"type":"fuli"}
     * @return 返回指定类型新闻列表
     */
    @GET("News")
    Call<NewsBean> getNewsList(@Query("limit") int size, @Query("where") WhereHandler type);

    /**
     * 获取单篇新闻信息
     * @param objectId 新闻ID
     * @return
     */
    @GET("News/{objectId}")
    Call<NewsBean> getNews(@Part("objectId") String objectId);


    /**
     * 上传新闻
     * @return
     */
    @POST("News")
    Call<Result> postNews();





}
