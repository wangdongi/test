package com.example.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.xiaoshixun.adapter.MyVpAd;
import com.example.xiaoshixun.bean.TabBean;
import com.example.xiaoshixun.fragment.AFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTab;
    /**
     * 打开上传界面
     */
    private Button mBtn;
    private ViewPager mVp;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<TabBean> observable = retrofit.create(MyServer.class).getTab();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean tabBean) {
                        List<TabBean.DataBean.NewsChannelListBean> newsChannelList = tabBean.getData().getNewsChannelList();
                        ArrayList<Fragment> fragments = new ArrayList<>();
                        for (int i = 0; i < newsChannelList.size(); i++) {
                            mTab.addTab(mTab.newTab().setText(newsChannelList.get(i).getChannelName()));
                            fragments.add(new AFragment(newsChannelList.get(i).getChannelId()));
                        }
                        MyVpAd myVpAd = new MyVpAd(getSupportFragmentManager(), fragments);
                        mVp.setAdapter(myVpAd);
                        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                            @Override
                            public void onTabSelected(TabLayout.Tab tab) {
                                mVp.setCurrentItem(tab.getPosition());
                            }

                            @Override
                            public void onTabUnselected(TabLayout.Tab tab) {

                            }

                            @Override
                            public void onTabReselected(TabLayout.Tab tab) {

                            }
                        });
                        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

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

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mVp = (ViewPager) findViewById(R.id.vp);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                break;
        }
    }
}
