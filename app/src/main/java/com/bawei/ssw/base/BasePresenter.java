package com.bawei.ssw.base;

import com.bawei.ssw.view.MainActivity;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 08 53 21<p>
 *  * <p>版本号：1<p>
 */
public abstract class BasePresenter<V extends BaseActivity> {
    public V v;
    public BasePresenter(){
        iModel();
    }

    protected abstract void iModel();
    public void attach(V v){
        this.v = v;
    }
    public  void  attach2(){
        v =null;
    }
}
