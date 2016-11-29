package com.chendong.gank.ganklib.bean;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/29 - 15:15
 * 注释：查询参数对象
 */
public class QueryBean {

    String where;
    String limit;
    String skip;
    String order;
    String include;
    String keys;


    public QueryBean() {

    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }


    @Override
    public String toString() {
        return "QueryBean{" +
                "where='" + where + '\'' +
                ", limit='" + limit + '\'' +
                ", skip='" + skip + '\'' +
                ", order='" + order + '\'' +
                ", include='" + include + '\'' +
                ", keys='" + keys + '\'' +
                '}';
    }
}
