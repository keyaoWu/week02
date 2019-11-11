package com.bawei.wukeyao20191111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bawei.wukeyao20191111.adapter.Myadapter;
import com.bawei.wukeyao20191111.base.BaseActivity;
import com.bawei.wukeyao20191111.base.BasePresenter;
import com.bawei.wukeyao20191111.bean.Bean;
import com.bawei.wukeyao20191111.presenter.Presenter;
import com.bawei.wukeyao20191111.until.VolleyUntil;
import com.bawei.wukeyao20191111.url.HttpUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
   private List<Bean.DataBean.GridDataBean> mList = new ArrayList<>();
    private Myadapter myadapter;

    @Override
    protected void startCoding() {
        mPresenter.onStartRequest(HttpUrl.httpUrL);
        if (VolleyUntil.getInstance().hasNet(this)){
            myadapter = new Myadapter(this, mList);
            recyclerView.setAdapter(myadapter);
            recyclerView.setVisibility(View.VISIBLE);
            myadapter.setOnItemClickListener(new Myadapter.onItemClickListener() {
                @Override
                public void onClick(int position) {
                    Toast.makeText(MainActivity.this, ""+mList.get(position).getPrice(), Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            recyclerView.setVisibility(View.GONE);
        }

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        List<Bean.DataBean.GridDataBean> gridData = new Gson().fromJson(json, Bean.class).getData().getGridData();
        mList.addAll(gridData);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
