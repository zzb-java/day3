package com.bawei.ssw.presenter;

import android.util.Log;

import com.bawei.ssw.R;
import com.bawei.ssw.base.BaseActivity;
import com.bawei.ssw.base.BasePresenter;
import com.bawei.ssw.bean.Beans;
import com.bawei.ssw.contract.Contract;
import com.bawei.ssw.model.Model;
import com.bawei.ssw.view.MainActivity;
import com.google.gson.Gson;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 08 54 45<p>
 *  * <p>版本号：1<p>
 */
public class Presenter extends BasePresenter implements Contract.iPresenter {

    public com.bawei.ssw.model.Model model;
    @Override
    protected void iModel() {
        model = new Model();
    }

    @Override
    public void getRequest(String request) {
        model.getData(request, new Contract.iModel() {
            @Override
            public void success(String s) {
                Log.e("a",""+s);
                Gson gson = new Gson();
                Beans beans = gson.fromJson(s, Beans.class);
                MainActivity mainActivity = (MainActivity) v;
                mainActivity.success(beans);
            }

            @Override
            public void failure(String f) {

            }
        });
    }
}
