package com.bwie.demo;


import java.util.List;

/**
 * 类描述:
 * 作者：陈文梦
 * 时间:2017/2/25 08:34
 * 邮箱:18310832074@163.com
 */

public class CarouselBean {


    /**
     * pageBean : {"size":20,"total":0,"count":0,"current":1,"pages":[]}
     * items : [{"mobilePushId":288,"title":"血肉模糊的手外伤保肢，值得吗？","body":"血肉模糊的手外伤保肢，值得吗？","url":"http://www.dxy.cn/bbs/topic/36140806","path":"http://res.dxycdn.com/upload/2017/02/23/07/72230524.jpg","avatarPath":"","sortTime":"2017-02-23 00:00:00"},{"mobilePushId":287,"title":"服用二甲双胍 这 8 大要点要知道","body":"服用二甲双胍 这 8 大要点要知道","url":"http://www.dxy.cn/bbs/topic/36144247","path":"http://res.dxycdn.com/upload/2017/02/23/05/62071912.jpg","avatarPath":"","sortTime":"2017-02-23 00:00:00"},{"mobilePushId":286,"title":"考研复试怎么准备？师兄为你来解答 ","body":"考研复试怎么准备？师兄为你来解答 ","url":"http://dxy.me/3MbaIr","path":"http://res.dxycdn.com/upload/2017/02/21/08/40171194.jpg!640","avatarPath":"","sortTime":"2017-02-22 00:00:00"}]
     * status : success
     */

    private PageBeanBean pageBean;
    private String status;
    private List<ItemsBean> items;

    public PageBeanBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBeanBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class PageBeanBean {
        /**
         * size : 20
         * total : 0
         * count : 0
         * current : 1
         * pages : []
         */

        private int size;
        private int total;
        private int count;
        private int current;
        private List<?> pages;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public List<?> getPages() {
            return pages;
        }

        public void setPages(List<?> pages) {
            this.pages = pages;
        }
    }

    public static class ItemsBean {
        /**
         * mobilePushId : 288
         * title : 血肉模糊的手外伤保肢，值得吗？
         * body : 血肉模糊的手外伤保肢，值得吗？
         * url : http://www.dxy.cn/bbs/topic/36140806
         * path : http://res.dxycdn.com/upload/2017/02/23/07/72230524.jpg
         * avatarPath :
         * sortTime : 2017-02-23 00:00:00
         */

        private int mobilePushId;
        private String title;
        private String body;
        private String url;
        private String path;
        private String avatarPath;
        private String sortTime;

        public int getMobilePushId() {
            return mobilePushId;
        }

        public void setMobilePushId(int mobilePushId) {
            this.mobilePushId = mobilePushId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getAvatarPath() {
            return avatarPath;
        }

        public void setAvatarPath(String avatarPath) {
            this.avatarPath = avatarPath;
        }

        public String getSortTime() {
            return sortTime;
        }

        public void setSortTime(String sortTime) {
            this.sortTime = sortTime;
        }
    }
}
