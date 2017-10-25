package com.example.ye.mvpproject.View;

import com.example.ye.mvpproject.Bean.EachDayData;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public interface IEachDayDataView {
    String getUrl();
    void success(EachDayData eachDayData);
    void error();

}
