package com.example.wz1.rxjava2;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018-11-28.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2
 */
public interface LruPoolStrategy {
    void put(Bitmap bitmap);
    Bitmap get(int width, int height, Bitmap.Config config);
    Bitmap removeLast();
    String logBitmap(Bitmap bitmap);
    String logBitmap(int width, int height, Bitmap.Config config);
    int getSize(Bitmap bitmap);
}
