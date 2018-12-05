package com.example.wz1.rxjava2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.wz1.rxjava2.polling.Event;
import com.example.wz1.rxjava2.polling.PollingManager;
import com.example.wz1.rxjava2.polling.onActivityLiftListener;

import io.reactivex.ObservableTransformer;

/**
 * Created by Administrator on 2018-10-15.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2
 */

public abstract class BaseActivity extends AppCompatActivity implements LifeInteface {

    private ObservableTransformer<Long,Long> transformer =null;

    protected onActivityLiftListener liftListener=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bindLift();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PollingManager.getInstance().stopPolling(getTag(), Event.ActivityEvent.DESTORY);
    }
}
