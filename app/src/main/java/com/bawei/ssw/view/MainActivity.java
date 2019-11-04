package com.bawei.ssw.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.ssw.R;
import com.bawei.ssw.adapter.RecycleAdapter;
import com.bawei.ssw.api.Api;
import com.bawei.ssw.base.BaseActivity;
import com.bawei.ssw.base.BasePresenter;
import com.bawei.ssw.bean.Beans;
import com.bawei.ssw.contract.Contract;
import com.bawei.ssw.custom.Coustom;
import com.bawei.ssw.custom.Flow;
import com.bawei.ssw.presenter.Presenter;

import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends BaseActivity implements Contract.iView, Coustom.callbacklist {

    private RecyclerView recyclerView;
    private Coustom coustom;
    private Presenter presenter;
    private Flow flow;

    @Override
    protected void initData() {
     Presenter presenter = (Presenter) p;
     presenter.getRequest("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=5&keyword=%E6%9D%BF%E9%9E%8B");
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        coustom = findViewById(R.id.coustom);
        coustom.setcallback(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        flow = findViewById(R.id.flow);
    }
    @Override
    protected BasePresenter getPro() {
        presenter = new Presenter();
        return presenter;
    }
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
    @Override
    public void success(Beans s) {
        RecycleAdapter recycleAdapter = new RecycleAdapter(this,s.result);
        recyclerView.setAdapter(recycleAdapter);
    }
    @Override
    public void setBut() {
        String text = coustom.edtext.getText().toString();
        String encode = URLEncoder.encode(text);
        String json = Api.getJson(encode, 1, 5);
        presenter.getRequest(json);
        Button button = new Button(this);
        String string = coustom.edtext.getText().toString();
        button.setText(string);
        flow.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               flow.removeView(v);
            }
        });


    }
}
