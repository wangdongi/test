package com.example.xiaoshixun;

import com.example.xiaoshixun.bean.NewsBean;
import com.example.xiaoshixun.bean.TabBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyServer {
    String url="https://www.firstgainfo.com/firstga/app/news/";

    @POST("listNewsChannel")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<TabBean> getTab();

    @POST("upListNews")
    @Headers("Content-Type:application/json")
    Observable<NewsBean> getNews(@Body RequestBody requestBody);
}
