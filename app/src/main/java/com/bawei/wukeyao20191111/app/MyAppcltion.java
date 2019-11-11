package com.bawei.wukeyao20191111.app;

import android.app.Application;
import android.content.Context;

/**
 * 功能：MyAppcltion类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：8:54
 */
public class MyAppcltion  extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
