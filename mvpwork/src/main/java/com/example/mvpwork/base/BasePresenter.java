package com.example.mvpwork.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;

    protected ArrayList<BaseModel> models=new ArrayList<>();
    public void attachModel(V view) {
        mView=view;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void onDestroy() {
        mView=null;
        if (mView!=null){
            if (models.size()>0){
                for (BaseModel model:models) {
                    model.onDestroy();
                }
            }
        }
    }
}
