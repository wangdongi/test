package com.example.mvpwork.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
