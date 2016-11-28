package com.chendong.gank.ganklib.service.limit;

import com.chendong.gank.ganklib.config.Constant;

import java.util.HashMap;
import java.util.Map;


/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 14:02
 * 注释：查询参数
 */
public class WhereHandler extends HashMap implements Map {



    private WhereHandler(String key, String value) {
        put(key,value);
    }

    public static  class Title extends WhereHandler {
        public Title(String value) {
            super("title",value);
        }
    }

    public static  class Type extends WhereHandler {
        public static String FULI= Constant.FULI;
        
        public Type(String value) {
            super("type",value);
        }
    }


    public static  class Author extends WhereHandler {
        public Author(String value) {
            super("author",value);
        }
    }


}
