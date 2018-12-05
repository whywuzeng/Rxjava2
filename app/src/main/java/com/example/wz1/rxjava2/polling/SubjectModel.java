package com.example.wz1.rxjava2.polling;


import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk
 */

public class SubjectModel<T> {

    public BehaviorSubject<T> getBehaviorSubject() {
        return behaviorSubject;
    }

    //subject
    private BehaviorSubject<T> behaviorSubject;

    //订阅关系
    private Disposable disposable;

    public SubjectModel(BehaviorSubject<T> behaviorSubject, PollingRequest pollingRequest) {
        this.behaviorSubject = behaviorSubject;
        this.disposable= behaviorSubject.subscribe();
        this.pollingRequest = pollingRequest;
    }

    public void clearSubject(){
        if (null == disposable&& disposable.isDisposed())
            return;

        disposable.dispose();
    }

    private PollingRequest pollingRequest;

    public void startPolling(PollingManager manager){
        pollingRequest.execute(manager);
    }

}
