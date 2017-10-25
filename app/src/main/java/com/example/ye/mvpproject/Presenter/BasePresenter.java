package com.example.ye.mvpproject.Presenter;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public interface BasePresenter<T> {
    void attach(T view);
    void detach();
}
