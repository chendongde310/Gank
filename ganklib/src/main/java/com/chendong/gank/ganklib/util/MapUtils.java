package com.chendong.gank.ganklib.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 13:57
 * 注释：
 */
public class MapUtils {

    public static Map<String,String> typeMap(String value){
        Map<String,String> map =new HashMap<>();
        map.put("type",value);
        return map;
    }



}
