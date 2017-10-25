package com.example.ye.mvpproject.Presenter;

import com.example.ye.mvpproject.View.IEachDayDataView;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public interface IEachDayDataPresenter extends BasePresenter<IEachDayDataView> {
    void getEachDayData();
}
