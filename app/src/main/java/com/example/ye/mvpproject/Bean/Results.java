package com.example.ye.mvpproject.Bean;

import java.util.List;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public class Results {

    private List<ResultDetail> Android;
    private List<ResultDetail> iOS;

    public List<ResultDetail> getAndroid() {
        return Android;
    }

    public List<ResultDetail> getiOS() {
        return iOS;
    }

    public void setAndroid(List<ResultDetail> android) {
        Android = android;
    }

    public void setiOS(List<ResultDetail> iOS) {
        this.iOS = iOS;
    }
}
