package com.example.wz1.rxjava2.retrofit;

/**
 * Created by Administrator on 2018-11-19.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.retrofit
 */
class User {
    public User(String name, String price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    private String name;
    private String price;
    private String location;
}
