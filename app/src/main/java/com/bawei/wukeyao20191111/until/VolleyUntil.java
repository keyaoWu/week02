package com.bawei.wukeyao20191111.until;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wukeyao20191111.app.MyAppcltion;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 功能：VolleyUntil类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：8:52
 */
public class VolleyUntil {

    private final RequestQueue queue;

    public VolleyUntil() {
        queue = Volley.newRequestQueue(MyAppcltion.mContext);
    }
    private static class VolleyHolder{
        static VolleyUntil volleyUntil = new VolleyUntil();
    }

    public static VolleyUntil getInstance() {
        return VolleyHolder.volleyUntil;
    }

    //封装get请求
    public void getInfo(String url, final VolleyCallBack volleyCallBack){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String str ="";
                try {
                    str = new String(response.getBytes("ISO-8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                volleyCallBack.onSuccess(str);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onError(error.getMessage());
            }
        });
        queue.add(request);
    }

    //封装post请求
    public void  postInfo(String url, final VolleyCallBack volleyCallBack){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onError(error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        queue.add(request);
    }

    //判断是否有网
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }

    //判断是否有移动网
    public boolean isMobil(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE) {
            return true;
        }else {
            return false;
        }
    }

    //判断是否是wifi
    public boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI) {
            return true;
        }else {
            return false;
        }
    }
    //封装接口
    public interface VolleyCallBack{
        void onSuccess(String json);
        void onError(String error);
    }
}
