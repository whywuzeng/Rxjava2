package com.example.wz1.rxjava2.polling;

/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk.polling
 */

public interface Event {

    enum ActivityEvent implements EventInterface{
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTORY
    }

    enum FragmentEvent implements EventInterface{
        ATTCH,
        CREATE,
        CREATEVIEW,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTORYVIEW,
        DESTORY,
        DETACH,
    }

    enum BHEvent implements EventInterface{
        INTERVAL,
        TIMER,
        STOP,
        ALL
    }
}
