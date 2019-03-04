package com.example.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;

public class Main3Activity extends AppCompatActivity {

    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if (url!=null){
            RequestOptions requestOptions = RequestOptions.circleCropTransform().skipMemoryCache(true);
            GlideApp.with(Main3Activity.this)
                    .load(url)
                    .apply(requestOptions)
                    .into(mImg);
        }
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this,Main2Activity.class));
            }
        });
    }
}
