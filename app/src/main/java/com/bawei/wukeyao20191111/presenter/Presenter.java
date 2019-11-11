package com.bawei.wukeyao20191111.presenter;

import com.bawei.wukeyao20191111.base.BasePresenter;
import com.bawei.wukeyao20191111.contract.Contract;
import com.bawei.wukeyao20191111.model.Model;

/**
 * 功能：Presenter类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:15
 */
public class Presenter extends BasePresenter {
    private Contract.IModel model;
    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void onStartRequest(String url) {
     model.getInfo(url, new Contract.MyCallBack() {
         @Override
         public void onSuccess(String json) {
             getView().onSuccess(json);
         }

         @Override
         public void onError(String error) {
          getView().onError(error);
         }
     });
    }
}
