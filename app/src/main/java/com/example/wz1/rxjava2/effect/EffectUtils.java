package com.example.wz1.rxjava2.effect;

/**
 * Created by Administrator on 2018-12-05.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.effect
 */
public class EffectUtils {

    //音效类型

    public static final int MODE_NORMAL = 0;
    public static final int MODE_LUOLI = 1;
    public static final int MODE_DASHU = 2;
    public static final int MODE_JINGSONG = 3;
    public static final int MODE_GAOGUAI = 4;
    public static final int MODE_KONGLING = 5;

    /**
     * 音效处理
     * @param path
     * @param type
     */
    public native static void fix(String path,int type);

    static
    {
        System.loadLibrary("fmodL");
        System.loadLibrary("fmod");
        System.loadLibrary("qq_voicer");
    }

}
