package com.example.ye.mvpproject.Model;

import android.os.Handler;

import com.example.ye.mvpproject.Bean.EachDayData;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public class EachDayDataModel implements IEachDayDataModel {

    private ResultCallback<EachDayData> callback;
    private Handler handler = new Handler();

    public EachDayDataModel(ResultCallback<EachDayData> callback) {
        this.callback = callback;
    }

    public void getEachDayDataByRetrofit(String date) {
        String url = "http://gank.io/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        EachDayDataService service = retrofit.create(EachDayDataService.class);
        service.getEachDayData(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EachDayData>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull final EachDayData eachDayData) {
                        if (callback != null) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callback.onResponse(eachDayData);
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getEachDayData(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onError();
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) {
                    final EachDayData eachDayData = new Gson().fromJson(response.body().string(), EachDayData.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onResponse(eachDayData);
                        }
                    });
                }
            }
        });
    }
}
