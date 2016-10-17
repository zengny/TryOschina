package com.zengny.tryoschina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zengny.tryoschina.improve.main.MainActivity;

/**
 * Created by Administrator on 2016/10/14.
 */

public class AppStart extends Activity {
    private static final String TAG = "AppStart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate()");
        setContentView(R.layout.app_start_view);
        findViewById(R.id.app_start_view).postDelayed(new Runnable() {
            @Override
            public void run() {
                redirecTo();
            }
        }, 800);
    }

    private void redirecTo() {
        Log.e(TAG,"redirecto()");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume()");
    }
}
