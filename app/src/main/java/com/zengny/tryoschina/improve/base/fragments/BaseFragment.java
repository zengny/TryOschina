package com.zengny.tryoschina.improve.base.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.ButterKnife;

/**
 * Created by 曾南勇
 * on 2016/10/14.
 */

public abstract class BaseFragment extends Fragment {
    protected View mRoot;
    protected Bundle mBundle;
    private RequestManager mImgLoader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();
        initBundle(mBundle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null) {
                parent.removeView(mRoot);
            }
        }else {
            mRoot = inflater.inflate(getLayoutId(),container,false);
            onBindViewBefore(mRoot);
            ButterKnife.bind(this,mRoot);
            if (savedInstanceState != null) {
                onRestartInstance(savedInstanceState);
            }
            initWidget(mRoot);
            initData();
        }

        return mRoot;
    }

    protected void onBindViewBefore(View root) {
        // ...
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        RequestManager manager = mImgLoader;
        if (manager != null) {
            manager.onDestroy();
        }
        mBundle = null;
    }

    protected void onRestartInstance(Bundle bundle) {

    }
    protected abstract int getLayoutId();

    protected void initBundle(Bundle bundle) {

    }

    protected void initWidget(View root) {

    }

    protected void initData() {

    }

    protected <T extends View> T findView(int viewId){
        return (T)mRoot.findViewById(viewId);
    }

    public synchronized RequestManager getmImgLoader(){
        if (mImgLoader == null) {
            mImgLoader = Glide.with(this);
        }
        return mImgLoader;
    }
    /***
     * 从网络中加载数据
     *
     * @param viewId   view的id
     * @param imageUrl 图片地址
     */
    protected void setImageFromNet(int viewId, String imageUrl) {
        setImageFromNet(viewId, imageUrl, 0);
    }

    /***
     * 从网络中加载数据
     *
     * @param viewId      view的id
     * @param imageUrl    图片地址
     * @param placeholder 图片地址为空时的资源
     */
    protected void setImageFromNet(int viewId, String imageUrl, int placeholder) {
        ImageView imageView = findView(viewId);
        setImageFromNet(imageView, imageUrl, placeholder);
    }

    /***
     * 从网络中加载数据
     *
     * @param imageView imageView
     * @param imageUrl  图片地址
     */
    protected void setImageFromNet(ImageView imageView, String imageUrl) {
        setImageFromNet(imageView, imageUrl, 0);
    }

    /***
     * 从网络中加载数据
     *
     * @param imageView   imageView
     * @param imageUrl    图片地址
     * @param placeholder 图片地址为空时的资源
     */
    protected void setImageFromNet(ImageView imageView, String imageUrl, int placeholder) {
        //ImageLoader.loadImage(getImgLoader(), imageView, imageUrl, placeholder);
    }

    protected  void setGone(int id){
        findView(id).setVisibility(View.GONE);
    }

    protected void setVisibility(int id){
        findView(id).setVisibility(View.VISIBLE);
    }

}

