package com.example.wz1.rxjava2;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018-11-28.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getInstance(){
        return context;
    }
}
