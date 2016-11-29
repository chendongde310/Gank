package com.chendong.gank.ganklib.service.manager;

import com.chendong.gank.ganklib.bean.NewsBean;
import com.chendong.gank.ganklib.retrofit.NetWorkRequest;
import com.chendong.gank.ganklib.service.api.NewsService;

import retrofit2.Call;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/29 - 15:11
 * 注释：新闻API管理
 */
public class NewsManager {


    private static NewsManager apiManager;
    private NewsService newsService;

    private NewsManager() {
        newsService = NetWorkRequest.getInstance().create(NewsService.class);
    }

    public static NewsManager getInstance() {
        if (apiManager == null) {
            apiManager = new NewsManager();

        }
        return apiManager;
    }


    /**
     * 获取所有新闻
     *
     * @return NewsService
     */
    public Call<NewsBean> getAllNewsList() {
        return newsService.getAllNewsList("-updatedAt");
    }


    /**
     * 获取指定数量新闻
     *
     * @return NewsService
     */
    public Call<NewsBean> getNewsList(int size,int skip) {
        return newsService.getNewsList(size,skip);
    }





    /**
     * 获取单篇新闻
     *
     * @return NewsService
     */
    public Call<NewsBean> getNews(String id) {
        return newsService.getNews(id);
    }







}
