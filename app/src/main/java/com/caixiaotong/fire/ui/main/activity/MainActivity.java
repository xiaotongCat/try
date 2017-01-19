package com.caixiaotong.fire.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.caixiaotong.fire.R;
import com.caixiaotong.fire.bean.TabEntity;
import com.caixiaotong.fire.ui.main.fragment.CareMainFragment;
import com.caixiaotong.fire.ui.main.fragment.NewsMainFragment;
import com.caixiaotong.fire.ui.main.fragment.PhotoMainFragment;
import com.caixiaotong.fire.ui.main.fragment.VideoMainFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaydenxiao.common.base.BaseActivity;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"首页","美女","视频","关注"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal,R.mipmap.ic_girl_normal,R.mipmap.ic_video_normal,R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected,R.mipmap.ic_girl_selected, R.mipmap.ic_video_selected,R.mipmap.ic_care_selected};

    private ArrayList<CustomTabEntity>  mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment lastFragment;

    private NewsMainFragment newsMainFragment;
    private PhotoMainFragment photoMainFragment;
    private VideoMainFragment videoMainFragment;
    private static  int TabLayoutHeight;

    private CareMainFragment careMainFragment;
    @Override
    public void initView() {

        initTab();
    }

    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void switchTab(int position) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    public void initPresenter() {

    }

    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }
}
