package com.bawei.wukeyao20191111.glide;

import android.widget.ImageView;

import com.bawei.wukeyao20191111.R;
import com.bawei.wukeyao20191111.app.MyAppcltion;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

/**
 * 功能：GlideHolder类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：9:36
 */
public class GlideHolder {
    public static void imageHolder(String url, ImageView view){
        Glide.with(MyAppcltion.mContext)
                .load(url)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .into(view);
    }
}
