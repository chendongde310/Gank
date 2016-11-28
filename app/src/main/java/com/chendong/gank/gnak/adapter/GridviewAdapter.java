package com.chendong.gank.gnak.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chendong.gank.ganklib.bean.PicsBean;
import com.chendong.gank.gnak.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/28 - 15:50
 * 注释：
 */
public class GridviewAdapter extends BaseAdapter {

    private Context context;
    private List<PicsBean.ResultsBean> results;


    public GridviewAdapter(Context context, List<PicsBean.ResultsBean> results) {
        this.context = context;
        this.results = results;
    }

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
        ViewHolder viewHolder ;
        if (view == null) {
            view = View.inflate(context, R.layout.adapter_main_list, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        ViewGroup.LayoutParams lp = viewHolder.img.getLayoutParams();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        viewHolder.img.setLayoutParams(lp);

        if (!results.get(i).getFile().getUrl().equals(viewHolder.img.getTag())) {
            Glide.with(context)
                    .load(results.get(i).getFile().getUrl())
                    .placeholder(R.drawable.progressbar_style)
                    .crossFade()
                    .into(viewHolder.img);
            viewHolder.img.setTag(results.get(i).getFile().getUrl());
        }

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.img)
        ImageView img;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}