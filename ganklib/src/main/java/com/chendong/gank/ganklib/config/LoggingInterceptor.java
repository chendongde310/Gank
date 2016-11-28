package com.chendong.gank.ganklib.config;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * 作者：陈东   www.renwey.com
 * 日期：2016/11/28 - 11:32
 * 
 */
public class LoggingInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        long t1 = System.nanoTime();

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();

        if (request != null && request.url() != null) {
        }

        return response;
    }
}
