package com.example.administrator.easyviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017/9/23.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_WIDTH_SCALE = 0.65f;
    private static final float MIN_HEIGHT_SCALE = 0.6f;
    private static final float MIN_ALPHA = 0.3f;
    private static final float MAX_ALPHA = 0.8f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position <= -1) {//超出最左边，此时不可见隐藏即可
            view.setAlpha(0);
        } else if(position > -1 && position < 0){
            float fraction = position + 1;
            view.setTranslationX(-position * pageWidth);
            view.setScaleX(MIN_WIDTH_SCALE + (1 - MIN_WIDTH_SCALE) * fraction);
            view.setScaleY(MIN_HEIGHT_SCALE + (1 - MIN_HEIGHT_SCALE) * fraction);
            view.setAlpha(MIN_ALPHA + (MAX_ALPHA - MIN_ALPHA) * fraction);
        } else if (position < 1 && position >= 0) {//还原数据
            view.setTranslationX(0);
            view.setAlpha(1);
            view.setScaleX(1);
            view.setScaleY(1);
        } else {//超出最右边，此时不可见隐藏即可
            view.setAlpha(0);
        }
    }
}