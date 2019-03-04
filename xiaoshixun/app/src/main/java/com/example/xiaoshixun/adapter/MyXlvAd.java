package com.example.xiaoshixun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xiaoshixun.GlideApp;
import com.example.xiaoshixun.R;
import com.example.xiaoshixun.bean.NewsBean;

import java.util.ArrayList;

public class MyXlvAd extends RecyclerView.Adapter<MyXlvAd.ViewHolder> {
    private ArrayList<NewsBean.DataBean.NewListBean> list;
    private Context context;


    public MyXlvAd(ArrayList<NewsBean.DataBean.NewListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<NewsBean.DataBean.NewListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final NewsBean.DataBean.NewListBean newListBean = list.get(i);
        holder.desc.setText(newListBean.getPublishTime());
        holder.title.setText(newListBean.getTitle());
        RequestOptions requestOptions1 = new RequestOptions().circleCrop();
        Glide.with(context).load(newListBean.getImageListThumb().get(0)).apply(requestOptions1).into(holder.iv);
        /*RequestOptions requestOptions = RequestOptions.circleCropTransform().skipMemoryCache(true);
        GlideApp.with(context).load(newListBean.getImageListThumb().get(0)).apply(requestOptions).into(holder.iv);*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener!=null){
                    itemClickListener.itemClik(newListBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
        }
    }


    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void itemClik(NewsBean.DataBean.NewListBean newsBean);
    }
}
