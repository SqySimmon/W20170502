package com.sqy.w20170502.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by SQY on 2017/5/5.
 */

public class RectView extends View {
    private float startX = 100;
    private float startY = 100;

    public RectView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);

        //新建矩形r1
        RectF r1 = new RectF();
        r1.left = 50;
        r1.right = 550;
        r1.top = 50;
        r1.bottom = 350;
        canvas.drawRect(r1, paint);
        //新建矩形r2
        RectF r2 = new RectF();
        r2.left = 55;
        r2.right = 545;
        r2.top = 55;
        r2.bottom = 345;
        paint.setColor(Color.BLUE);
        //画出矩形r1
        canvas.drawRect(r2, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
