package com.example.mvpwork.api;

import com.example.mvpwork.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServer {
    String baseApi="http://api.tianapi.com/";
    @GET("wxnew?key=52b7ec3471ac3bec6846577e79f20e4c&num=10")
    Observable<NewsBean> getData(@Query("page")int page);

}
