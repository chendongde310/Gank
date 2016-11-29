package com.chendong.gank.ganklib.retrofit;

import android.content.Context;

import com.chendong.gank.ganklib.config.AuthenticatorManager;
import com.chendong.gank.ganklib.config.CommonInterceptor;
import com.chendong.gank.ganklib.config.CookieManager;
import com.chendong.gank.ganklib.config.HeaderInterceptor;
import com.chendong.gank.ganklib.util.NetErrStringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

import static com.chendong.gank.ganklib.config.Constant.baseURL;


/**
 * 
 * 作者：陈东   www.renwey.com
 * 日期：2016/11/28 - 10:47
 * 
 */
public class NetWorkRequest {

    public static final String TAG = NetWorkRequest.class.getSimpleName();

    private static boolean IS_DEV = false;


    private static NetWorkRequest sInstance = new NetWorkRequest();
    public Context mContext;
    private Map<String, Map<Integer, Call>> mRequestMap = new ConcurrentHashMap<>();
    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;


    private NetWorkRequest() {

    }

    public static void setDeveloperMode(boolean isDev) {
        //日志打印
        IS_DEV = isDev;
    }

    public static NetWorkRequest getInstance() {
        return sInstance;
    }

    /**
     * 初始化Gank Retrofit
     * 已配置好URL\HEADER等配置
     *
     * @param context context
     */
    public NetWorkRequest initGank(Context context) {
        this.mContext = context;
        synchronized (NetWorkRequest.this) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(new Cache(new File(context.getExternalCacheDir(), "http_cache"), 1024 * 1024 * 100))
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(new CommonInterceptor())
                    .addInterceptor(getLoggingInterceptor())
                    .addInterceptor(new HeaderInterceptor())
                    .cookieJar(new CookieManager())
                    .authenticator(new AuthenticatorManager())
                    .build();
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .baseUrl(baseURL)//主机地址
                    .client(mOkHttpClient)
                    .build();

            // log用拦截器

        }
        return this;
    }

    private HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        if (IS_DEV) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return logging;
    }


    /**
     * 初始化Retrofit
     * 自定义URL
     *
     * @param context context
     * @param baseURL url
     */
    public NetWorkRequest init(Context context, String baseURL) {
        this.mContext = context;
        synchronized (NetWorkRequest.this) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(new Cache(new File(context.getExternalCacheDir(), "http_cache"), 1024 * 1024 * 100))
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(new CommonInterceptor())
                    .addInterceptor(getLoggingInterceptor())
                    .cookieJar(new CookieManager())
                    .authenticator(new AuthenticatorManager())
                    .build();
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .baseUrl(baseURL)//主机地址
                    .client(mOkHttpClient)
                    .build();
        }
        return this;
    }






    public <T> T create(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }

    public void clearCookie() {
        ((CookieManager) mOkHttpClient.cookieJar()).clearCookie();
    }

    /**
     * 异步请求
     *
     * @param TAG
     * @param requestCall
     * @param responseListener
     * @param <T>
     * @return
     */
    public <T extends BaseResponseEntity> void asyncNetWork(final String TAG, final int requestCode, final Call<T> requestCall, final NetworkResponse<T> responseListener) {
        if (responseListener == null) {
            return;
        }

        Call<T> call;

        if (requestCall.isExecuted()) {
            call = requestCall.clone();
        } else {
            call = requestCall;
        }
        addCall(TAG, requestCode, call);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                cancelCall(TAG, requestCode);
                if (response.isSuccessful()) {
                    T result = response.body();
                    if (result == null) {
                        responseListener.onDataError(requestCode, response.code(), "");
                        return;
                    }
                    result.requestCode = requestCode;
                    result.serverTip = response.message();
                    result.responseCode = response.code();
                    responseListener.onDataReady(result);
                } else {
                    responseListener.onDataError(requestCode, response.code(), NetErrStringUtils.getErrString(mContext, response.code()));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                cancelCall(TAG, requestCode);
                responseListener.onDataError(requestCode, 0, NetErrStringUtils.getErrString(mContext, t));
            }
        });
    }

    /**
     * 同步请求
     *
     * @param TAG
     * @param requestCall
     * @param responseListener
     * @param <T>
     * @return
     */
    public <T extends BaseResponseEntity> void syncNetWork(final String TAG, final int requestCode, final Call<T> requestCall, final NetworkResponse<T> responseListener) {
        if (responseListener == null) {
            return;
        }
        Call<T> call;
        try {
            if (requestCall.isExecuted()) {
                call = requestCall.clone();
            } else {
                call = requestCall;
            }

            Response<T> response = call.execute();
            addCall(TAG, requestCode, call);
            if (response.isSuccessful()) {
                T result = response.body();
                if (result == null) {
                    responseListener.onDataError(requestCode, response.code(), "");
                    return;
                }
                result.requestCode = requestCode;
                result.serverTip = response.message();
                result.responseCode = response.code();
                responseListener.onDataReady(result);
            } else {
                responseListener.onDataError(requestCode, response.code(), NetErrStringUtils.getErrString(mContext, response.code()));
            }
        } catch (IOException e) {
            responseListener.onDataError(requestCode, 0, NetErrStringUtils.getErrString(mContext, e));
        } finally {
            cancelCall(TAG, requestCode);
        }
    }

    /**
     * 添加call到Map
     *
     * @param TAG
     * @param call
     */
    private void addCall(String TAG, Integer code, Call call) {
        if (TAG == null) {
            return;
        }
        if (mRequestMap.get(TAG) == null) {
            Map<Integer, Call> map = new ConcurrentHashMap<>();
            map.put(code, call);
            mRequestMap.put(TAG, map);
        } else {
            mRequestMap.get(TAG).put(code, call);
        }
    }

    /**
     * 取消某个call
     *
     * @param TAG
     * @param code
     */
    public boolean cancelCall(String TAG, Integer code) {
        if (TAG == null) {
            return false;
        }
        Map<Integer, Call> map = mRequestMap.get(TAG);
        if (map == null) {
            return false;
        }
        if (code == null) {
            //取消整个context请求
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Integer key = (Integer) iterator.next();

                Call call = map.get(key);
                if (call == null) {
                    continue;
                }
                call.cancel();
            }
            mRequestMap.remove(TAG);
            return false;
        } else {
            //取消一个请求
            if (map.containsKey(code)) {
                Call call = map.get(code);
                if (call != null) {
                    call.cancel();
                }
                map.remove(code);
            }
            if (map.size() == 0) {
                mRequestMap.remove(TAG);
                return false;
            }
        }
        return true;
    }

    /**
     * 取消整个tag请求，关闭页面时调用
     *
     * @param TAG
     */
    public void cancelTagCall(String TAG) {
        cancelCall(TAG, null);
    }
}
