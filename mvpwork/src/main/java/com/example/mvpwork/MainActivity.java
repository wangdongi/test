package com.example.mvpwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.mvpwork.adapter.NewsAdapter;
import com.example.mvpwork.base.BaseActivity;
import com.example.mvpwork.bean.NewsBean;
import com.example.mvpwork.model.NewsModel;
import com.example.mvpwork.presenter.NewsPresenter;
import com.example.mvpwork.utils.Logger;
import com.example.mvpwork.view.NewsView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<NewsView,NewsPresenter> implements NewsView{

    @BindView(R.id.xlv)
    XRecyclerView mXlv;
    private NewsAdapter adapter;
    private int page=1;
    private static final String TAG = "MainActivity";

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mXlv.setLayoutManager(new LinearLayoutManager(this));
        mXlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        ArrayList<NewsBean.NewslistBean> list = new ArrayList<>();
        adapter = new NewsAdapter(list, this);
        mXlv.setAdapter(adapter);
        mXlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                adapter.list.clear();
                presenter.getData(page);
            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.getData(page);
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getData(page);
    }

    @Override
    public void updateNews(List<NewsBean.NewslistBean> newslist) {
        adapter.setAll(newslist);
        mXlv.refreshComplete();
        mXlv.loadMoreComplete();
    }

    @Override
    public void ErrorMsg(String msg) {
        Logger.logD(TAG,msg);
    }
}
