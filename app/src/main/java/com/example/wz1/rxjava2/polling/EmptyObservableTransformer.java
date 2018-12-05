package com.example.wz1.rxjava2.polling;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk.polling
 */

class EmptyObservableTransformer implements ObservableTransformer<Long,Long> {
    @Override
    public ObservableSource<Long> apply(Observable<Long> upstream) {
        return null;
    }
}
