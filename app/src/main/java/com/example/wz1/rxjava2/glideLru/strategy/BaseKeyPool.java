package com.example.wz1.rxjava2.glideLru.strategy;

import com.bumptech.glide.util.Util;

import java.util.Queue;

/**
 * Created by Administrator on 2018-11-28.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2
 */
public abstract class BaseKeyPool <T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(MAX_SIZE);

    protected T get() {
        T result = keyPool.poll();
        if (result == null) {
            result = create();
        }
        return result;
    }

    public void offer(T key) {
        if (keyPool.size() < MAX_SIZE) {
            keyPool.offer(key);
        }
    }

    protected abstract T create();
}
