package com.example.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg;
    /**
     * 上传文件
     */
    private static final String TAG = "Main2Activity";
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                uploadFile();
                break;
        }
    }

    private void uploadFile() {
        String filePath = Environment.getExternalStorageDirectory() + File.separator + "i.jpg";
        File file = new File(filePath);
        if (file.exists()){
            Log.d(TAG, "uploadFile: "+true);
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "img")
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://yun918.cn/study/public/file_upload.php")
                .post(multipartBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            JSONObject data = jsonObject.getJSONObject("data");
                            String url = data.getString("url");
                            RequestOptions requestOptions = RequestOptions.circleCropTransform().skipMemoryCache(true);
                            GlideApp.with(Main2Activity.this)
                                    .load(url)
                                    .apply(requestOptions)
                                    .into(mImg);
                            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                            intent.putExtra("url",url);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }
}
