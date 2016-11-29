package com.chendong.gank.gank1206.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chendong.gank.ganklib.bean.NewsBean;
import com.chendong.gank.ganklib.service.manager.NewsManager;
import com.chendong.gank.ganklib.util.SwipImageGetter;
import com.chendong.gank.gank1206.BaseActivity;
import com.chendong.gank.gank1206.Constant;
import com.chendong.gank.gank1206.R;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Override
    public void init() {
        NewsManager.getInstance().getAllNewsList().enqueue(new Callback<NewsBean>() {
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
                View view1;

                view1 = LinearLayout.inflate(NewsActivity.this, R.layout.adapter_news_list_pic, null);
                TextView title = (TextView) view1.findViewById(R.id.title);
                ImageView imageView = (ImageView) view1.findViewById(R.id.img);
                title.setText(results.get(i).getTitle());
                Glide.with(NewsActivity.this)
                        .load(null == results.get(i).getBanner() ? Constant.DEFAULT_IMG_URL : results.get(i).getBanner().getUrl())
                        .centerCrop()
                        .into(imageView);
                return view1;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //查看新闻详情
            }
        });


    }


    private void html(final TextView textView, final String str) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Spanned spanned = Html.fromHtml(str, SwipImageGetter.getImageGetter(NewsActivity.this), null);
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
