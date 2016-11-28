package com.chendong.gank.ganklib.config;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 12:17
 * 注释：添加Header拦截器
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json;charset=utf-8")
              //  .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("X-LC-Id", "nuIdDhh1amLxmOKWPhHlsDe6-gzGzoHsz")
                .addHeader("X-LC-Key", "TaPMAipY4r9TxapC8sOXt8HP")
                .build();
        return chain.proceed(request);
    }
}
