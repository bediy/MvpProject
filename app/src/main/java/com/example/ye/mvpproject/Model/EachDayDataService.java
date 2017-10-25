package com.example.ye.mvpproject.Model;

import com.example.ye.mvpproject.Bean.EachDayData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ye on 2017/10/16/0016.
 */

public interface EachDayDataService {
    @GET("api/day/{date}")
    Observable<EachDayData> getEachDayData(@Path("date") String date);
}
