package com.example.mvpwork.view;

import com.example.mvpwork.base.BaseView;
import com.example.mvpwork.bean.NewsBean;

import java.util.List;

public interface NewsView extends BaseView{
    void updateNews(List<NewsBean.NewslistBean> newslist);

    void ErrorMsg(String msg);
}
