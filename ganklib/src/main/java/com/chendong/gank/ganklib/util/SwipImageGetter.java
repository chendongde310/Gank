package com.chendong.gank.ganklib.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import java.net.URL;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/10/24 - 14:00
 * 注释：
 */
public class SwipImageGetter {


    public static Html.ImageGetter getImageGetter(final Context context) {

        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = null;
                URL url;
                try {
                    url = new URL(source);
                    drawable = Drawable.createFromStream(url.openStream(), "");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

                double height = UScreen.getScreenWidth(context) / drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight();
                drawable.setBounds(0, 0, UScreen.getScreenWidth(context), (int) height);
                return drawable;
            }
        };

        return imageGetter;
    }


}
