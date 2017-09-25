package com.example.administrator.easyviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/23.
 */

public class ZoomAdvertActivity extends Activity {


    LooperPagerView looperPagerView;
    private ArrayList<Integer> imageList = new ArrayList<>();
    LooperPagerAdapter looperPagerAdapter;
    ZoomAdvertActivity mContext;
    private int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        looperPagerView = (LooperPagerView) findViewById(R.id.looperPagerView);
        initView();
    }

    private void getScreenWidthDip() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
    }

    private void initView() {
        getScreenWidthDip();
        imageList.add(R.drawable.guide_one);
        imageList.add(R.drawable.guide_two);
        imageList.add(R.drawable.guide_three);
        imageList.add(R.drawable.guide_four);
        imageList.add(R.drawable.guide_five);

        looperPagerAdapter = new LooperPagerAdapter(mContext);
        looperPagerView.setAdapter(looperPagerAdapter);
        looperPagerAdapter = new LooperPagerAdapter(mContext);
        looperPagerView.setBounds(400, 200);
        looperPagerView.setAdapter(looperPagerAdapter);
        looperPagerAdapter.setDatas(imageList);
        looperPagerAdapter.notifyDataSetChanged();
        looperPagerView.notifyChanged();
        looperPagerView.startLooping(3000);
    }
}
