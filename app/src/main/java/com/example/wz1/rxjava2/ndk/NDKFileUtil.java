package com.example.wz1.rxjava2.ndk;

/**
 * Created by Administrator on 2018-12-03.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.ndk
 */
public class NDKFileUtil {

    static {
        System.loadLibrary("MyLibrary");
    }

    /**
     * 分包
     * @param path  原文件路径
     * @param patternPath 分包文件的路径
     * @param count 要分成几份
     */
    public native static void diff(String path,String patternPath,int count);

    public native static void patch(String path,String patternPath,int count);
}
