package com.example.ye.mvpproject.Model;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public interface ResultCallback<T> {
    void onResponse(T t);
    void onError();
}
