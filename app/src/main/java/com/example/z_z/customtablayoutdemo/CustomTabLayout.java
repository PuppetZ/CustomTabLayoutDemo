package com.example.z_z.customtablayoutdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * Created by Z_z on 2017/12/18.
 * 自定义TabLayout
 */

public class CustomTabLayout extends TabLayout {
    private Bitmap mBitmap;//自定义的bt


    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_indicate);
    }

    /**
     *
     * 绘制下方指示器
     * @param canvas  画布
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mBitmap != null) {
            canvas.save();
            canvas.drawBitmap(mBitmap,0,0,null);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }
}
