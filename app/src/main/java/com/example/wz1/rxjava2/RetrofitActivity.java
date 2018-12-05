package com.example.wz1.rxjava2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018-11-19.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2
 */
public class RetrofitActivity extends AppCompatActivity {

    private ImageView iv_centerpic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        iv_centerpic =(ImageView)findViewById(R.id.iv_centerpic);
//        final RetrofitTest retrofitTest = new RetrofitTest();
//        retrofitTest.runRetrofit();

        Glide.with(this).load("https://github.com/whywuzeng/Rxjava3/raw/master/javasync/bg0_fine_day.jpg")
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.webpage_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(300,300)
                .dontAnimate()
                .into(iv_centerpic);

//        Observable.just("32132")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())

        Observable.just("2121")
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
