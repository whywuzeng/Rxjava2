package com.example.wz1.rxjava2.ndk;

/**
 * Created by Administrator on 2018-12-03.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.ndk
 */
public class MyNdk {
    static {
        System.loadLibrary("MyLibrary");
    }

    public native static String getStringFromC();
}
