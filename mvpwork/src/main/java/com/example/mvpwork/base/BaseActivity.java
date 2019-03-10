package com.example.mvpwork.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView,T extends BasePresenter> extends AppCompatActivity {
    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter=initPresenter();
        if (presenter!=null){
            presenter.attachModel((V)this);
        }
        initView();
        initData();
    }

    protected abstract T initPresenter();

    protected void initView() {
    }

    protected void initData() {
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.onDestroy();
        }
    }
}
