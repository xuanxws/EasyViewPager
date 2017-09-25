package com.example.administrator.easyviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017/9/23.
 */

public class ZoomOutTransformer implements ViewPager.PageTransformer {

    private static final float MIN_WIDTH_SCALE = 0.65f;//宽度最小缩小比例
    private static final float MIN_HEIGHT_SCALE = 0.6f;//高度最小缩小比例
    private static final float MIN_ALPHA = 0.5f;//最小透明度

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position <= -1) {//超出最左边，此时不可见隐藏即可
            view.setAlpha(MIN_ALPHA);
            view.setScaleX(MIN_WIDTH_SCALE);
            view.setScaleY(MIN_HEIGHT_SCALE);
        } else if(position > -1 && position < 0){
            //float fraction = position + 1;
            view.setScaleX((1 - MIN_WIDTH_SCALE) * position + 1);
            view.setScaleY((1 - MIN_HEIGHT_SCALE) * position + 1);
            view.setAlpha((1 - MIN_ALPHA) * position + 1);
        } else if (position < 1 && position >= 0) {//还原数据
            view.setAlpha(1);
            view.setScaleX(1 - (1 - MIN_WIDTH_SCALE) * position);
            view.setScaleY(1 - (1 - MIN_HEIGHT_SCALE) * position);
            view.setAlpha(1 - (1 - MIN_ALPHA) * position);
        } else {//超出最右边，此时不可见隐藏即可
            view.setAlpha(MIN_ALPHA);
            view.setScaleX(MIN_WIDTH_SCALE);
            view.setScaleY(MIN_HEIGHT_SCALE);
        }
    }
}
