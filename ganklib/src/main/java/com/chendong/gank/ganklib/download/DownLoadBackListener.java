package com.chendong.gank.ganklib.download;

import com.chendong.gank.ganklib.download.db.DownLoadEntity;

/**
 * Created by hly on 16/4/11.
 * email hugh_hly@sina.cn
 */
public interface DownLoadBackListener {
    void onStart(double percent);

    void onCancel();

    void onDownLoading(double percent);

    void onCompleted();

    void onError(DownLoadEntity downLoadEntity, Throwable throwable);
}
