package com.bawei.wukeyao20191111.contract;

/**
 * 功能：Contract类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:05
 */
public interface Contract {
    interface IModel{
        void getInfo(String url,MyCallBack myCallBack);
        void postInfo(String url,MyCallBack myCallBack);
    }

    interface IView{
        void onSuccess(String json);
        void onError(String error);
    }

    interface Presenter{
        void onStartRequest(String url);
    }
    interface MyCallBack{
        void onSuccess(String json);
        void onError(String error);
    }
}
