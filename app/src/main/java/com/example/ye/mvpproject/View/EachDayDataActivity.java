package com.example.ye.mvpproject.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ye.mvpproject.Bean.EachDayData;
import com.example.ye.mvpproject.Presenter.EachDayDataPresenter;
import com.example.ye.mvpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EachDayDataActivity extends AppCompatActivity implements IEachDayDataView {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.android_desc)
    TextView androidDesc;
    @BindView(R.id.android_who)
    TextView androidWho;
    @BindView(R.id.iOS_desc)
    TextView iOSDesc;
    @BindView(R.id.iOS_who)
    TextView iOSWho;

    private EachDayDataPresenter eachDayDataPresenter = new EachDayDataPresenter();

    private static final String URL = "http://gank.io/api/day/2015/08/07";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        eachDayDataPresenter.attach(this);
        editText.setText(URL);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        eachDayDataPresenter.getEachDayData();
    }

    @Override
    public String getUrl() {
        return editText.getText().toString();
    }

    @Override
    public void success(EachDayData eachDayData) {
        if (eachDayData != null) {
            androidDesc.setText(eachDayData.getResults().getAndroid().get(0).getDesc());
            androidWho.setText(eachDayData.getResults().getAndroid().get(0).getWho());
            iOSDesc.setText(eachDayData.getResults().getiOS().get(0).getDesc());
            iOSWho.setText(eachDayData.getResults().getiOS().get(0).getWho());
        }
    }

    @Override
    public void error() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eachDayDataPresenter.detach();
    }
}
