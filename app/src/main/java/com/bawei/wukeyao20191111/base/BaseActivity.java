package com.bawei.wukeyao20191111.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.wukeyao20191111.contract.Contract;

/**
 * 功能：BaseActivity类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:10
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
 public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (providerLayoutId()!=0){
            setContentView(providerLayoutId());
            initView();
            initData();
            mPresenter = initPresenter();
            if (mPresenter!=null){
                mPresenter.onAttachView(this);
            }
            startCoding();
        }
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();


    protected abstract int providerLayoutId();

    //内存泄漏

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDeattch();
        }
    }
}
