package com.example.wz1.rxjava2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wz1.rxjava2.polling.Event;
import com.example.wz1.rxjava2.polling.PollingAction;
import com.example.wz1.rxjava2.polling.PollingManager;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PollingManager.getInstance().bindIntervalEvent(1, TAG, Event.BHEvent.INTERVAL, new PollingAction() {
                    @Override
                    public void doAction(Long num) {
                        Log.e(TAG, "doAction: num ="+num );
                    }
                });


            }
        });

        findViewById(R.id.stopbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PollingManager.getInstance().stopPolling(TAG,Event.BHEvent.INTERVAL);
            }
        });
//        final RetrofitTest retrofitTest = new RetrofitTest();
//        retrofitTest.runRetrofit();

    }

    @Override
    public String getTag() {
        return TAG;
    }

    @Override
    public void bindLift() {
//        PollingManager.getInstance().bindIntervalEvent(1, TAG, Event.ActivityEvent.PAUSE, new PollingAction() {
//            @Override
//            public void doAction(Long num) {
//                Log.e(TAG, "doAction: num ="+num );
//            }
//        });
    }
}
