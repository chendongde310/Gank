package com.chendong.gank.ganklib.bean;

import java.util.List;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 15:00
 * 注释：文章对象
 */
public class ReadBean {

    /**
     * content : not content
     * type : default
     * title : test title
     * author : 佚名
     * createdAt : 2016-11-25T03:33:53.723Z
     * updatedAt : 2016-11-25T03:34:17.591Z
     * objectId : 5837b121128fe1006aa76399
     */

    public ReadBean( ) {

    }

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }



    public static class ResultsBean {
        private String content;
        private String type;
        private String title;
        private String author;
        private String createdAt;
        private String updatedAt;
        private String objectId;

        public ResultsBean( ) {

        }

        /**
         * 创建文章构造方法
         * @param content
         * @param type
         * @param title
         * @param author
         */
        public ResultsBean(String content, String type, String title, String author) {
            this.content = content;
            this.type = type;
            this.title = title;
            this.author = author;
        }

        public String getContent() {
            return content;
        }


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCreatedAt() {
            return createdAt;
        }



        public String getUpdatedAt() {
            return updatedAt;
        }



        public String getObjectId() {
            return objectId;
        }


    }




}
