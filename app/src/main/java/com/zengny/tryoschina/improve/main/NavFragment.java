package com.zengny.tryoschina.improve.main;


import android.support.v4.app.Fragment;
import android.view.View;

import com.zengny.tryoschina.R;
import com.zengny.tryoschina.improve.base.fragments.BaseFragment;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by 曾南勇
 * on 2016/10/14.
 */

public class NavFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.nav_item_news)
    NavigationButton mNavNews;
    @Bind(R.id.nav_item_tweet)
    NavigationButton mNavTweet;
    @Bind(R.id.nav_item_explore)
    NavigationButton mNavExplore;
    @Bind(R.id.nav_item_me)
    NavigationButton mNavMe;

    public NavFragment() {
    }

    @OnClick({
            R.id.nav_item_news,
            R.id.nav_item_tweet,
            R.id.nav_item_explore,
            R.id.nav_item_me,
            R.id.nav_item_tweet_pub
    })
    @Override
    public void onClick(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }
}
