package com.example.administrator.easyviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

/**
 * Created by Administrator on 2017/9/23.
 */

public class RotationActivity extends Activity {

    ViewPager mViewPager;
    RotationActivity mContext;

    int[] drawables = new int[]{R.drawable.guide_one, R.drawable.guide_two, R.drawable.guide_three, R.drawable.guide_four, R.drawable.guide_five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        mContext = this;
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyAdapter myAdapter = new MyAdapter(drawables,mContext);
        mViewPager.setPageTransformer(false,new RotateDownPageTransformer());
        mViewPager.setAdapter(myAdapter);
    }
}
