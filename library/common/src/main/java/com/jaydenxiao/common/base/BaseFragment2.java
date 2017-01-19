package com.jaydenxiao.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/1/17.
 */

public abstract class BaseFragment2 extends Fragment {
    protected abstract void initListener();
    protected abstract void initData();
    protected abstract void initView();
    protected abstract int setFragmentLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(setFragmentLayoutId(),container,false);
        initListener();
        initData();
        initView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

        }
    }

    protected void LazyLoadData(){}

}
