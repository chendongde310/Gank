package com.chendong.gank.gank1206.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chendong.gank.gank1206.BaseActivity;
import com.chendong.gank.gank1206.R;

import butterknife.OnClick;

/**
 * 作者：陈东   www.renwey.com
 * 日期：2016/11/25 - 16:18
 * !!!!测试的时候请确保周围没人。不然后果自负!!!
 */
public class MainActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void init() {

    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(MainActivity.this, PicActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, NewsActivity.class));
                break;
        }
    }
}
