package com.chendong.gank.ganklib.bean;

import java.util.List;

/**
 * 作者：陈东  —  www.renwey.com
 * 日期：2016/11/25 - 15:28
 * 注释：图片对象
 */
public class PicsBean {

    /**
     * file : {"mime_type":"image/jpeg","updatedAt":"2016-11-25T02:31:40.620Z","key":"dab7df5c9d8c775914f3.jpg","name":"default.jpg","objectId":"5837a28cac502e006c10702e","createdAt":"2016-11-25T02:31:40.620Z","__type":"File","url":"http://ac-nuIdDhh1.clouddn.com/dab7df5c9d8c775914f3.jpg","metaData":{"owner":"unknown","size":13641,"mime_type":"image/jpeg"},"bucket":"nuIdDhh1"}
     * type : default
     * createdAt : 2016-11-25T02:31:41.158Z
     * updatedAt : 2016-11-25T02:31:41.158Z
     * objectId : 5837a28d128fe1006bd34654
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * mime_type : image/jpeg
         * updatedAt : 2016-11-25T02:31:40.620Z
         * key : dab7df5c9d8c775914f3.jpg
         * name : default.jpg
         * objectId : 5837a28cac502e006c10702e
         * createdAt : 2016-11-25T02:31:40.620Z
         * __type : File
         * url : http://ac-nuIdDhh1.clouddn.com/dab7df5c9d8c775914f3.jpg
         * metaData : {"owner":"unknown","size":13641,"mime_type":"image/jpeg"}
         * bucket : nuIdDhh1
         */

        private FileBean file;
        private String type;
        private String title;
        private String depict;
        private String createdAt;
        private String updatedAt;
        private String objectId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDepict() {
            return depict;
        }

        public void setDepict(String depict) {
            this.depict = depict;
        }

        public FileBean getFile() {
            return file;
        }

        public void setFile(FileBean file) {
            this.file = file;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public static class FileBean {
            private String mime_type;
            private String updatedAt;
            private String key;
            private String name;
            private String objectId;
            private String createdAt;
            private String __type;
            private String url;
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


            @Override
            public String toString() {
                return "FileBean{" +
                        "mime_type='" + mime_type + '\'' +
                        ", updatedAt='" + updatedAt + '\'' +
                        ", key='" + key + '\'' +
                        ", name='" + name + '\'' +
                        ", objectId='" + objectId + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        ", __type='" + __type + '\'' +
                        ", url='" + url + '\'' +
                        ", metaData=" + metaData.toString() +
                        ", bucket='" + bucket + '\'' +
                        '}';
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

                @Override
                public String toString() {
                    return "MetaDataBean{" +
                            "owner='" + owner + '\'' +
                            ", size=" + size +
                            ", mime_type='" + mime_type + '\'' +
                            '}';
                }
            }
        }
    }
}
