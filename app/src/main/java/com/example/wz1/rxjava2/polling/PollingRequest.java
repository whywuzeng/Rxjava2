package com.example.wz1.rxjava2.polling;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk
 */

public abstract class PollingRequest {
    //每个唯一的tag
    protected String tag;

    //事件接口
    protected EventInterface eventInterface;

    //轮询工作
    protected PollingAction action;

    public PollingRequest(String tag, EventInterface eventInterface, PollingAction action) {
        this.tag = tag;
        this.eventInterface = eventInterface;
        this.action = action;
    }

    public abstract Disposable execute(PollingManager manager);

    public String getTag() {
        return tag;
    }

    public EventInterface getEventInterface() {
        return eventInterface;
    }

}

