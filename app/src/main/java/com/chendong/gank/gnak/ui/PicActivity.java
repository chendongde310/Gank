package com.chendong.gank.gnak.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.ganklib.service.manager.PicManager;
import com.chendong.gank.gnak.BaseActivity;
import com.chendong.gank.gnak.R;
import com.chendong.gank.gnak.adapter.GridviewAdapter;
import com.etsy.android.grid.StaggeredGridView;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PicActivity extends BaseActivity {


    @BindView(R.id.grid_view)
    StaggeredGridView gridView;
    private GridviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);


    }

    @Override
    public void init() {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (adapter == null) {
            initPic();
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void initPic() {
        //此处调用ganklib方法来加载图片
        PicManager.getInstance()                           // 获取接口实例
                .getAllPicList()                           //  获取所有图片
                .enqueue(new Callback<PicsBean>() {        //enqueue 异步请求
                    @Override                              //Callback 回调   onResponse --成功      onFailure-- 失败
                    public void onResponse(Call<PicsBean> call, final Response<PicsBean> response) {
                        adapter = new GridviewAdapter(PicActivity.this, response.body().getResults());
                        gridView.setAdapter(adapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                //点击监听
                                Toast.makeText(PicActivity.this, response.body().getResults().get(i).getFile().getName(), Toast.LENGTH_SHORT).show();
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
