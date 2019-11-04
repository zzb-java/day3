package com.bawei.ssw.adapter;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/30 14 00 31<p>
 *  * <p>版本号：1<p>
 */
public class Api {
    public static String getJson(String keywork,int page,int count){
        String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page="+page+"&count="+count+"&keyword="+keywork;
        return url;
    }

}
