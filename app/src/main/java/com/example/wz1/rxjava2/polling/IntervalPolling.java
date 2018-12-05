package com.example.wz1.rxjava2.polling;


import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk.polling
 */

public class IntervalPolling extends PollingRequest {

    private static final String TAG = "IntervalPolling";

    private int interval;

    public IntervalPolling(String tag, EventInterface eventInterface, PollingAction action, int interval) {
        super(tag, eventInterface, action);
        this.interval = interval;
    }

    @Override
    public Disposable execute(PollingManager manager) {

        return Observable.interval(interval, TimeUnit.SECONDS).
                compose(manager.composeEvent(tag,eventInterface)).
                observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "accept: emit interval polling, Tag = " + tag + ", num = " + aLong);
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (null != action)
                        {
                            action.doAction(aLong);
                        }
                        Log.e(TAG, "accept: emit interval polling, Tag = " + tag + ", num = " + aLong);
                    }
                })
                ;
    }
}
