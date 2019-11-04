package com.bawei.ssw.contract;

import com.bawei.ssw.bean.Beans;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 08 54 01<p>
 *  * <p>版本号：1<p>
 */
public interface Contract {
    interface iView{
        void success(Beans s);
    }
    interface iModel{
        void success(String s);
        void failure(String f);
    }
    interface iPresenter{
        void getRequest(String request);
    }
}
