package com.example.wz1.rxjava2.retrofit;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2018-11-19.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.retrofit
 */
public interface RetrofitService {

    @GET("goto/{user}")
    Observable<String> getCallWeb(@Path("user") String user);

    @POST("users/new")
    Observable<User> createUser(@Body User user);
}
