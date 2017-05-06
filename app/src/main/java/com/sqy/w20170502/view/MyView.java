package com.sqy.w20170502.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by SQY on 2017/5/2.
 */

public class MyView extends View {
    private int x = 0;
    private int y = 0;

    private int pressX; // 点击位置
    private int pressY; // 点击位置

    public MyView(Context context) {
        super(context);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
//        paint.setAntiAlias(true);
////        canvas.drawColor(Color.YELLOW);
//        paint.setTextSize(50);
//        paint.setColor(Color.RED);
//        canvas.drawText("Android多媒体程序设计", 100, 100, paint);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        canvas.drawRect(x, y, x + 200, y + 200, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pressX = (int) event.getX() - x;
                pressY = (int) event.getY() - y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (0 < pressX && pressX < 200 && 0 < pressY && pressY < 200) {
                    x = (int) event.getX() - pressX;
                    y = (int) event.getY() - pressY;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
