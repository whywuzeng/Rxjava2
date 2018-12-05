package com.example.wz1.rxjava2.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;

/**
 * Created by Administrator on 2018-11-19.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.retrofit
 */
public class RetrofitTest {

    public void runRetrofit(){
        final Retrofit build = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final RetrofitService retrofitService = build.create(RetrofitService.class);

        final Observable<User> back = retrofitService.createUser(new User("1","2","3"));

        back.subscribe(new Observer<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User s) {

            }
        });
    }
}
