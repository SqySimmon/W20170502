package com.sqy.w20170502.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQY on 2017/5/5.
 */

public class TriangleView extends View {

    public static int POINTNUM = 3;

    private int pointCount = 0; // 点击的点数

    private List<Point> points = new ArrayList<>(); // 点击的点

    public TriangleView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("开始画图", "开始画图");
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < points.size(); i++) {
            Log.e("开始画图", "开始画图" + i);
            canvas.drawLine(points.get(i).x, points.get(i).y, points.get((i + 1) % points.size()).x, points.get((i + 1) % points.size()).y, paint);
        }
        if (pointCount == POINTNUM) {
            pointCount = 0;
            points.clear();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("nishishabi", "nishishabi");
                pointCount++;
                Point point = new Point();
                point.x = (int) event.getX();
                point.y = (int) event.getY();
                points.add(point);
                invalidate();
                break;
        }
        return true;
    }
}
