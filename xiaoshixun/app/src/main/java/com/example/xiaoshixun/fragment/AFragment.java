package com.example.xiaoshixun.fragment;


import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.xiaoshixun.MyServer;
import com.example.xiaoshixun.R;
import com.example.xiaoshixun.adapter.MyXlvAd;
import com.example.xiaoshixun.adapter.Wbean;
import com.example.xiaoshixun.bean.NewsBean;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyXlvAd.ItemClickListener {

    String channelId;
    private View view;
    private XRecyclerView mXlv;
    private MyXlvAd myXlvAd;
    private ArrayList<NewsBean.DataBean.NewListBean> list;

    public AFragment() {
        // Required empty public constructor
    }

    private static final String TAG = "AFragment";
    @SuppressLint("ValidFragment")
    public AFragment(String channelId) {
        this.channelId = channelId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initData() {
        /*OkHttpClient client = new OkHttpClient();
        Wbean wbean = new Wbean();
        wbean.setChannelId(channelId);
        wbean.setCursor("0");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(wbean));
        Request request = new Request.Builder()
                .url("https://www.firstgainfo.com/firstga/app/news/upListNews")
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NewsBean newsBean = new Gson().fromJson(result, NewsBean.class);
                        list.addAll(newsBean.getData().getNewList());
                        myXlvAd.setList(list);
                    }
                });
            }
        });*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Wbean wbean = new Wbean();
        wbean.setChannelId(channelId);
        wbean.setCursor("0");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(wbean));
        Observable<NewsBean> observable = retrofit.create(MyServer.class).getNews(requestBody);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        list.addAll(newsBean.getData().getNewList());
                        myXlvAd.setList(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void initView(View inflate) {
        mXlv = (XRecyclerView) inflate.findViewById(R.id.xlv);
        mXlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        myXlvAd = new MyXlvAd(list, getActivity());
        mXlv.setAdapter(myXlvAd);
        myXlvAd.setItemClickListener(this);
    }

    @Override
    public void itemClik(NewsBean.DataBean.NewListBean newsBean) {
        getPop(newsBean);
    }

    private void getPop(NewsBean.DataBean.NewListBean newsBean) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_pop, null);
        TextView txt = inflate.findViewById(R.id.txt);
        txt.setText(newsBean.getTitle());
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 300, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);
    }
}
