package com.bawei.ssw.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.ssw.app.App_a;
import com.bawei.ssw.contract.Contract;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 08 55 07<p>
 *  * <p>版本号：1<p>
 */
public class HttUtils {
    public static HttUtils httUtils = new HttUtils();
    public HttUtils(){}

    private HttUtils getHttUtils() {
        return httUtils;
    }
    public boolean network(Context context){
        if (context!=null){
           ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
            if (activeNetworkInfo!=null){
                return  activeNetworkInfo.isConnected();
            }
        }
        return false;
    }
    public void toget(String url,final Contract.iModel iModel){
         final  RequestQueue requestQueue = Volley.newRequestQueue(App_a.context);
        final StringRequest stringRequest = new StringRequest(0, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iModel.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iModel.failure(error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
}
