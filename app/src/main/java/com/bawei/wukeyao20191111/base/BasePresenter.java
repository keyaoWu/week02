package com.bawei.wukeyao20191111.base;

import com.bawei.wukeyao20191111.contract.Contract;

import java.lang.ref.WeakReference;

/**
 * 功能：BasePresenter类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:07
 */
public abstract class BasePresenter <V extends Contract.IView> implements Contract.Presenter {

    private WeakReference<V> mWerak;

    public BasePresenter() {
        initModel();
    }

    //定义一个model层
    abstract protected  void initModel();

    public void onAttachView(V view){
        mWerak = new WeakReference<>(view);
    }

    public void onDeattch(){
        if (mWerak!=null){
            mWerak.clear();
            mWerak=null;
        }
    }

    //获取view
    public V getView(){
        return mWerak.get();
    }
}
