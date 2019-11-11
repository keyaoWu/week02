package com.bawei.wukeyao20191111.model;

import com.bawei.wukeyao20191111.contract.Contract;
import com.bawei.wukeyao20191111.until.VolleyUntil;

/**
 * 功能：Model类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:14
 */
public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, final Contract.MyCallBack myCallBack) {
        VolleyUntil.getInstance().getInfo(url, new VolleyUntil.VolleyCallBack() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
               myCallBack.onError(error);
            }
        });
    }

    @Override
    public void postInfo(String url, final Contract.MyCallBack myCallBack) {
       VolleyUntil.getInstance().postInfo(url, new VolleyUntil.VolleyCallBack() {
           @Override
           public void onSuccess(String json) {
               myCallBack.onSuccess(json);
           }

           @Override
           public void onError(String error) {
             myCallBack.onError(error);
           }
       });
    }
}
