package com.bawei.ssw.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 14 13 49<p>
 *  * <p>版本号：1<p>
 */
public class Flow extends ViewGroup {

    private int size;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        size = MeasureSpec.getSize(widthMeasureSpec);
        int left= 20;
        int top = 20;
        int margin = 20;
        for (int i = 0; i <getChildCount(); i++) {
            View childAt = getChildAt(i);
            int height = childAt.getMeasuredHeight();
            int width = childAt.getMeasuredWidth();
            if (left+width>=size){
                top+=height+margin;
                left=20;
            }
            left+=width+margin;
            if (i==getChildCount()-1){
                top+=height+margin;
            }
        }
        setMeasuredDimension(size,top);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 20;
        int top = 20;
        int margin=20;
        for (int i = 0; i <getChildCount(); i++) {
            View childAt = getChildAt(i);
            int height = childAt.getMeasuredHeight();
            int width = childAt.getMeasuredWidth();
            if (left + width >= size) {
                top += height + margin;
                left = 20;

            }
            childAt.layout(left,top,left+width,top+height);
            left+=width+margin;
        }
    }
}
