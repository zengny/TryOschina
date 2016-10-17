package com.zengny.tryoschina.improve.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zengny.tryoschina.R;
import com.zengny.tryoschina.improve.base.acitivies.BaseActivity;

/**
 * Created by 曾南勇
 * on 2016/10/14.
 */

public class MainActivity extends BaseActivity {
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getContentView() {
        Log.e(TAG,"getContentView");
        return R.layout.activity_main_ui;
    }
}
