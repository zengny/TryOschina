package com.zengny.tryoschina.improve.base.acitivies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * Created by 曾南勇
 * on 2016/10/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected RequestManager mImageLoader;
    private boolean mIsDestory;
    private final String mPackageNameUmeng = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (initBundle(getIntent().getExtras())){
            setContentView(getContentView());

            initWindow();

            ButterKnife.bind(this);
            initWidget();
            initDate();
        }else{
            finish();
        }
//        友盟分析工具
        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.mPackageNameUmeng);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.mPackageNameUmeng);
        MobclickAgent.onPause(this);
    }

    protected void initDate() {
    }

    protected void initWidget() {
    }

    protected void initWindow() {
    }

    protected boolean initBundle(Bundle extras) {
        return true;
    }

    protected abstract int getContentView();

    public synchronized RequestManager getImageLoader(){
        if (mImageLoader == null){
            mImageLoader = Glide.with(this);
        }
        return mImageLoader;
    }

    @Override
    protected void onDestroy() {
        mIsDestory = true;
        super.onDestroy();
    }

    public boolean isDestroy(){
        return mIsDestory;
    }
}
