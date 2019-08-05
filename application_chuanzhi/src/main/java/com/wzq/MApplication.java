package com.wzq;

import android.app.Application;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：2019-07-15<p>
 * <p>文件描述：<p>
 * 全局上下文,和app的生命周期相同;
 * 我们可以再全局上下文中做一些全局配置;
 * 要把自己设置的全局上下文在资源清单中配置
 *
 *
 */
public class MApplication extends Application {

    String temp="";

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
