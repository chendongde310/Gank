package com.chendong.gank.gnak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chendong.gank.ganklib.bean.NewsBean;
import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.ganklib.service.ApiManager;
import com.chendong.gank.ganklib.util.SwipImageGetter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * 
 * 作者：陈东   www.renwey.com
 * 日期：2016/11/25 - 16:18
 * !!!!简单的图片获取demo,测试的时候请确保周围没人。不然后果自负!!!
 */
public class MainActivity extends AppCompatActivity {


    private android.widget.ListView list;
    private android.widget.Button button;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button = (Button) findViewById(R.id.button);
        this.list = (ListView) findViewById(R.id.list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                initPic();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                initNews();
            }


        });


    }

    private void initNews() {

        ApiManager.getInstance().initNews().getAllNewsList().enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                setNewsListView(response.body());
            }
            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setNewsListView(NewsBean body) {
        final List<NewsBean.ResultsBean> results = body.getResults();
        list.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return results.size();
            }

            @Override
            public Object getItem(int i) {
                return results.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                View view1 = LinearLayout.inflate(MainActivity.this, R.layout.adapter_main_news_list, null);
                TextView title =(TextView)view1.findViewById(R.id.title);
                TextView content =(TextView)view1.findViewById(R.id.content);
                ImageView imageView = (ImageView) view1.findViewById(R.id.img);

                title.setText(results.get(i).getTitle());

                html(content,results.get(i).getContent());

                Glide.with(MainActivity.this)
                        .load(results.get(i).getBanner().getUrl())
                        .into(imageView);
                return view1;
            }
        });




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
            public void onResponse(Call<PicsBean> call, Response<PicsBean> response) {
                setPicListView(response.body());
            }

            @Override
            public void onFailure(Call<PicsBean> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private void setPicListView(PicsBean body) {
        final List<PicsBean.ResultsBean> results = body.getResults();
        list.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return results.size();
            }

            @Override
            public Object getItem(int i) {
                return results.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view1 = LinearLayout.inflate(MainActivity.this, R.layout.adapter_main_list, null);
                ImageView imageView = (ImageView) view1.findViewById(R.id.img);
                Glide.with(MainActivity.this)
                        .load(results.get(i).getFile().getUrl())
                        .into(imageView);
                return view1;
            }
        });
    }


    private void html(final TextView textView, final String str) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Spanned spanned = Html.fromHtml(str, SwipImageGetter.getImageGetter(MainActivity.this), null);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(spanned);
                    }
                });
            }
        });
        thread.start();
    }
}
