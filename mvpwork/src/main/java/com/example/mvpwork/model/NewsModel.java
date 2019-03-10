package com.example.mvpwork.model;

import com.example.mvpwork.api.ApiServer;
import com.example.mvpwork.base.BaseModel;
import com.example.mvpwork.base.BaseObserver;
import com.example.mvpwork.bean.NewsBean;
import com.example.mvpwork.callback.CallBack;
import com.example.mvpwork.utils.HttpUtils;
import com.example.mvpwork.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsModel extends BaseModel {

    public void getData(int page, final CallBack callBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.baseApi, ApiServer.class);
        Observable<NewsBean> observable = apiserver.getData(page);
        /*observable.compose(RxUtils.<NewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        callBack.onSuccess(newsBean);
                    }
                });*/
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        callBack.onSuccess(newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
