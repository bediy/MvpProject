package com.example.ye.mvpproject.Presenter;

import com.example.ye.mvpproject.Bean.EachDayData;
import com.example.ye.mvpproject.Model.EachDayDataModel;
import com.example.ye.mvpproject.Model.ResultCallback;
import com.example.ye.mvpproject.View.IEachDayDataView;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public class EachDayDataPresenter implements IEachDayDataPresenter, ResultCallback<EachDayData>{

    private IEachDayDataView eachDayDataView;
    private EachDayDataModel eachDayDataModel = new EachDayDataModel(this);


    @Override
    public void attach(IEachDayDataView view) {
        eachDayDataView = view;
    }

    @Override
    public void detach() {
        eachDayDataView = null;
        eachDayDataModel = null;
    }

    @Override
    public void getEachDayData() {
//        eachDayDataModel.getEachDayData(eachDayDataView.getUrl());
        eachDayDataModel.getEachDayDataByRetrofit("2015/08/07");
    }

    @Override
    public void onResponse(EachDayData eachDayData) {
        eachDayDataView.success(eachDayData);
    }

    @Override
    public void onError() {
        eachDayDataView.error();
    }
}
