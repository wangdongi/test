package com.example.mvpwork.callback;

public interface CallBack<T> {
    void onSuccess(T bean);
    void onFailed(String msg);
}
