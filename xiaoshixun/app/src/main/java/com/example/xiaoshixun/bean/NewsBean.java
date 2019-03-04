package com.example.xiaoshixun.bean;

import java.util.List;

public class NewsBean {

    /**
     * code : 0
     * data : {"maxCursor":"153051408042cd467f82d14d3a905686ea75e4362b","tops":0,"newList":[{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/144601ehnu2h6rr2juhrxe.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"42cd467f82d14d3a905686ea75e4362b","origin":"","pageviews":1572,"publishTime":"2018-07-02","title":"镇雄通用机场空域使用方案军地协调会召开"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/143849f7zx1i1xz187iqob.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"0547641ccf2749259d2723ca3505926b","origin":"","pageviews":1152,"publishTime":"2018-07-02","title":"2020年我国通用机场将超500个 部分地区将县县通机场"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/143349n3u5d53z573im3es.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"02c98bdb6db04b1e839c22d36ef19ca2","origin":"","pageviews":1459,"publishTime":"2018-07-02","title":"美国加州野火失控延烧 超过100辆消防车和10多架直升机参与灭火"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180702/1_180702143128_1-lp.JPG"],"isTop":0,"layoutType":"1","newsId":"3acb400326754d27925903f71b0d0360","origin":"","pageviews":242,"publishTime":"2018-07-02","title":"富蕴机场\u201c富蕴-喀纳斯\u201d航线首航成功"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/142820saqiirjv90in0k9a.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"0c0358578e4c4c4289c1a5de4887f83d","origin":"","pageviews":179,"publishTime":"2018-07-02","title":"五年内第二次越狱 法国一服刑惯犯乘直升机出逃"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/141924nz0oms0ou8piqrr0.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"9ba9f099e1444bdfb82ba1f59ffef3aa","origin":"","pageviews":144,"publishTime":"2018-07-02","title":"《合肥市通用航空产业发展规划》力争年内完成并对外发布"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201807/02/194055358486.png"],"isTop":0,"layoutType":"1","newsId":"8a52d28613b54f7587764e4fe7c84020","origin":"","pageviews":70,"publishTime":"2018-07-02","title":"最新取证通航机场、驾驶证汇总"}],"minCursor":"15304608008a52d28613b54f7587764e4fe7c84020"}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * maxCursor : 153051408042cd467f82d14d3a905686ea75e4362b
         * tops : 0
         * newList : [{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/144601ehnu2h6rr2juhrxe.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"42cd467f82d14d3a905686ea75e4362b","origin":"","pageviews":1572,"publishTime":"2018-07-02","title":"镇雄通用机场空域使用方案军地协调会召开"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/143849f7zx1i1xz187iqob.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"0547641ccf2749259d2723ca3505926b","origin":"","pageviews":1152,"publishTime":"2018-07-02","title":"2020年我国通用机场将超500个 部分地区将县县通机场"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/143349n3u5d53z573im3es.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"02c98bdb6db04b1e839c22d36ef19ca2","origin":"","pageviews":1459,"publishTime":"2018-07-02","title":"美国加州野火失控延烧 超过100辆消防车和10多架直升机参与灭火"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180702/1_180702143128_1-lp.JPG"],"isTop":0,"layoutType":"1","newsId":"3acb400326754d27925903f71b0d0360","origin":"","pageviews":242,"publishTime":"2018-07-02","title":"富蕴机场\u201c富蕴-喀纳斯\u201d航线首航成功"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/142820saqiirjv90in0k9a.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"0c0358578e4c4c4289c1a5de4887f83d","origin":"","pageviews":179,"publishTime":"2018-07-02","title":"五年内第二次越狱 法国一服刑惯犯乘直升机出逃"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201807/02/141924nz0oms0ou8piqrr0.jpg.thumb.jpg"],"isTop":0,"layoutType":"2","newsId":"9ba9f099e1444bdfb82ba1f59ffef3aa","origin":"","pageviews":144,"publishTime":"2018-07-02","title":"《合肥市通用航空产业发展规划》力争年内完成并对外发布"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201807/02/194055358486.png"],"isTop":0,"layoutType":"1","newsId":"8a52d28613b54f7587764e4fe7c84020","origin":"","pageviews":70,"publishTime":"2018-07-02","title":"最新取证通航机场、驾驶证汇总"}]
         * minCursor : 15304608008a52d28613b54f7587764e4fe7c84020
         */

        private String maxCursor;
        private int tops;
        private String minCursor;
        private List<NewListBean> newList;

        public String getMaxCursor() {
            return maxCursor;
        }

        public void setMaxCursor(String maxCursor) {
            this.maxCursor = maxCursor;
        }

        public int getTops() {
            return tops;
        }

        public void setTops(int tops) {
            this.tops = tops;
        }

        public String getMinCursor() {
            return minCursor;
        }

        public void setMinCursor(String minCursor) {
            this.minCursor = minCursor;
        }

        public List<NewListBean> getNewList() {
            return newList;
        }

        public void setNewList(List<NewListBean> newList) {
            this.newList = newList;
        }

        public static class NewListBean {
            /**
             * imageListThumb : ["http://www.lyunx.com/data/attachment/portal/201807/02/144601ehnu2h6rr2juhrxe.jpg.thumb.jpg"]
             * isTop : 0
             * layoutType : 2
             * newsId : 42cd467f82d14d3a905686ea75e4362b
             * origin :
             * pageviews : 1572
             * publishTime : 2018-07-02
             * title : 镇雄通用机场空域使用方案军地协调会召开
             */

            private int isTop;
            private String layoutType;
            private String newsId;
            private String origin;
            private int pageviews;
            private String publishTime;
            private String title;
            private List<String> imageListThumb;

            public int getIsTop() {
                return isTop;
            }

            public void setIsTop(int isTop) {
                this.isTop = isTop;
            }

            public String getLayoutType() {
                return layoutType;
            }

            public void setLayoutType(String layoutType) {
                this.layoutType = layoutType;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getPageviews() {
                return pageviews;
            }

            public void setPageviews(int pageviews) {
                this.pageviews = pageviews;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<String> getImageListThumb() {
                return imageListThumb;
            }

            public void setImageListThumb(List<String> imageListThumb) {
                this.imageListThumb = imageListThumb;
            }
        }
    }
}
