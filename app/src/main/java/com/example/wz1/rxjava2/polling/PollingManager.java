package com.example.wz1.rxjava2.polling;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

import static com.example.wz1.rxjava2.polling.Event.BHEvent.ALL;


/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.system.bhouse.utils.apk
 */

public class PollingManager {
    private static final String TAG = "PollingManager";

    private HashMap<String,SubjectModel<EventInterface>> modelHashMap=new HashMap<>();

    private final static class HODLER{
        private final static PollingManager MANAGER=new PollingManager();
    }

    public static PollingManager getInstance(){
        return HODLER.MANAGER;
    }

    public BehaviorSubject<EventInterface> getSubject(String tag)
    {
        final SubjectModel<EventInterface> model = modelHashMap.get(tag);
        if (model!=null)
        {
            return model.getBehaviorSubject();
        }
        return null;
    }

    public ObservableTransformer<Long,Long> composeEvent(final String tag,final EventInterface outEvent)
    {
        final BehaviorSubject<EventInterface> subject = getSubject(tag);
        if (null == subject)
        {
            Log.e(TAG, "composeEvent: subject == null");
            return new EmptyObservableTransformer();
        }
        final Observable observable =  subject.filter(new Predicate<EventInterface>() {
            @Override
            public boolean test(EventInterface eventInterface) {
                Log.e(TAG, "call: eventInterface:"+eventInterface);
                boolean filter = outEvent == eventInterface|| eventInterface == ALL;
                if (filter)
                    clearSubject(tag);
                return filter;
            }
        });

        return new ObservableTransformer<Long, Long>() {
            @Override
            public ObservableSource<Long> apply(io.reactivex.Observable<Long> upstream) {
                return upstream.subscribeOn(Schedulers.io()).takeUntil(observable);
            }
        };

    }

    private void clearSubject(String tag) {
        final SubjectModel<EventInterface> eventInterfaceSubjectModel = modelHashMap.get(tag);
        eventInterfaceSubjectModel.clearSubject();
    }

    public BehaviorSubject<EventInterface> bindIntervalEvent(int interval, @NonNull String tag,@NonNull EventInterface eventInterface,PollingAction action)
    {
        final IntervalPolling intervalPolling = new IntervalPolling(tag, eventInterface, action, interval);

        createSubject(intervalPolling);

        startPolling(tag);

        return modelHashMap.get(tag).getBehaviorSubject();
    }

    public boolean stopPolling(String tag,EventInterface event)
    {
        final BehaviorSubject<EventInterface> subject = getSubject(tag);
        if (null == subject)
        {
            Log.e(TAG, "stopPolling: subject ==null" );
            return false;
        }
        subject.onNext(event);

        Log.e(TAG, "stopPolling: SubjectTag =" + tag + ", Event = " + event.toString() );
        return true;
    }



    private void startPolling(String tag ) {
        final SubjectModel<EventInterface> eventInterfaceSubjectModel = modelHashMap.get(tag);
        eventInterfaceSubjectModel.startPolling(this);
//        emitEvent();

    }

    public void emitEvent(@NonNull EventInterface event)
    {
        if (null == modelHashMap)return;

        for (Map.Entry<String,SubjectModel<EventInterface>> next:
             modelHashMap.entrySet()) {
            final BehaviorSubject<EventInterface> behaviorSubject = next.getValue().getBehaviorSubject();
            if (null!=behaviorSubject)
            {
                behaviorSubject.onNext(event);
            }
        }
    }

    private void createSubject(IntervalPolling intervalPolling) {
        final SubjectModel subjectModel = new SubjectModel(BehaviorSubject.create(), intervalPolling);
        modelHashMap.put(intervalPolling.getTag(),subjectModel);
    }

}
