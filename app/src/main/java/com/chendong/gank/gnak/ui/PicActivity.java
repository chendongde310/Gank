package com.chendong.gank.gnak.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.ganklib.service.ApiManager;
import com.chendong.gank.gnak.BaseActivity;
import com.chendong.gank.gnak.R;
import com.chendong.gank.gnak.adapter.GridviewAdapter;
import com.etsy.android.grid.StaggeredGridView;
import com.yy.www.libs.TransitionManager;
import com.yy.www.libs.helper.TransitionSingleHelper;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PicActivity extends BaseActivity {

    @BindView(R.id.grid_view)
    StaggeredGridView gridView;
    TransitionSingleHelper singleHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);


    }

    @Override
    public void init() {
        singleHelper = new TransitionManager(this).getSingle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPic();
    }

    private void initPic() {
        //此处调用ganklib方法来加载图片
        //getInstance() 获取接口管理员
        //initPic()  初始化图片接口
        //getPicList(10) 获取图片（条数）
        //enqueue 异步请求
        //Callback 回调   onResponse --成功      onFailure-- 失败
        ApiManager.getInstance().initPic().getAllPicList().enqueue(new Callback<PicsBean>() {
            @Override
            public void onResponse(Call<PicsBean> call, final Response<PicsBean> response) {
                GridviewAdapter adapter = new GridviewAdapter(PicActivity.this, response.body().getResults());
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        singleHelper.startViewerActivity(view, response.body().getResults().get(i).getFile().getUrl());
                    }
                });
            }

            @Override
            public void onFailure(Call<PicsBean> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
