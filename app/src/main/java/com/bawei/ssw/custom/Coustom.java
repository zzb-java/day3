package com.bawei.ssw.custom;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.ssw.R;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 13 44 44<p>
 *  * <p>版本号：1<p>
 */
public class Coustom extends LinearLayout {
    public callbacklist callbacklist;
    public EditText edtext;
    public Button button;
    public Coustom(Context context) {
        super(context);
    }

    public Coustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.coustom, this);
        edtext = view.findViewById(R.id.edtext);
        button = view.findViewById(R.id.bton);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacklist.setBut();
            }
        });
    }
    public  interface callbacklist{
        void setBut();
    }
    public void setcallback(callbacklist callbacklist){
        this.callbacklist=callbacklist;
    }

}
