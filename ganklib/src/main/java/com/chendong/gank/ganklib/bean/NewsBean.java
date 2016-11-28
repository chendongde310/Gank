package com.chendong.gank.ganklib.bean;

import java.util.List;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/28 - 11:58
 * 注释：
 */
public class NewsBean {



    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String title;
        private String createdAt;
        private String updatedAt;
        /**
         * mime_type : image/jpeg
         * updatedAt : 2016-11-28T03:56:15.990Z
         * key : e6230edbdc4d92e02225.jpg
         * name : b9450ade3ce6eb26c73959967ce7c7f4.jpg
         * objectId : 583baadf61ff4b006cbe8643
         * createdAt : 2016-11-28T03:56:15.990Z
         * __type : File
         * url : http://ac-nuIdDhh1.clouddn.com/e6230edbdc4d92e02225.jpg
         * metaData : {"owner":"unknown","size":60487,"mime_type":"image/jpeg"}
         * bucket : nuIdDhh1
         */

        private BannerBean banner;
        private String content;
        private String objectId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public BannerBean getBanner() {
            return banner;
        }

        public void setBanner(BannerBean banner) {
            this.banner = banner;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public static class BannerBean {
            private String mime_type;
            private String updatedAt;
            private String key;
            private String name;
            private String objectId;
            private String createdAt;
            private String __type;
            private String url;
            /**
             * owner : unknown
             * size : 60487
             * mime_type : image/jpeg
             */

            private MetaDataBean metaData;
            private String bucket;

            public String getMime_type() {
                return mime_type;
            }

            public void setMime_type(String mime_type) {
                this.mime_type = mime_type;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String get__type() {
                return __type;
            }

            public void set__type(String __type) {
                this.__type = __type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public MetaDataBean getMetaData() {
                return metaData;
            }

            public void setMetaData(MetaDataBean metaData) {
                this.metaData = metaData;
            }

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public static class MetaDataBean {
                private String owner;
                private int size;
                private String mime_type;

                public String getOwner() {
                    return owner;
                }

                public void setOwner(String owner) {
                    this.owner = owner;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getMime_type() {
                    return mime_type;
                }

                public void setMime_type(String mime_type) {
                    this.mime_type = mime_type;
                }
            }
        }
    }
}
