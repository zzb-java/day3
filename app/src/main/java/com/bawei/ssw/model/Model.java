package com.bawei.ssw.model;

import com.bawei.ssw.contract.Contract;
import com.bawei.ssw.http.HttUtils;

import java.net.HttpRetryException;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 08 54 25<p>
 *  * <p>版本号：1<p>
 */
public class Model {
    public void getData(String url, Contract.iModel iModel){
        HttUtils.httUtils.toget(url, iModel);
    }
}
