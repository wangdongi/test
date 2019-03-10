package com.example.mvpwork.presenter;

import com.example.mvpwork.base.BasePresenter;
import com.example.mvpwork.bean.NewsBean;
import com.example.mvpwork.callback.CallBack;
import com.example.mvpwork.model.NewsModel;
import com.example.mvpwork.view.NewsView;

public class NewsPresenter extends BasePresenter<NewsView> {

    private NewsModel newsModel;

    @Override
    protected void initModel() {
        newsModel = new NewsModel();
        models.add(newsModel);
    }

    public void getData(int page) {
        newsModel.getData(page, new CallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean bean) {
                mView.updateNews(bean.getNewslist());
            }

            @Override
            public void onFailed(String msg) {
                mView.ErrorMsg(msg);
            }
        });
    }
}
