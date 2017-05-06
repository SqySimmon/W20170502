package com.sqy.w20170502.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Message;
import android.view.View;

import com.sqy.w20170502.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SQY on 2017/5/5.
 */

public class ImgView extends View {
    private int left = 0;
    private int top = 0;

    private android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            invalidate();
        }
    };

    public ImgView(Context context) {
        super(context);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendMessage(new Message());
            }
        }, 1000, 500);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Bitmap soilder = BitmapFactory.decodeResource(
                this.getResources(), R.mipmap.image);
        Rect src = new Rect(left, 0, left + soilder.getWidth() / 4,
                soilder.getHeight());
        Rect dst = new Rect(100, 100, 300, 500);
        canvas.drawBitmap(soilder, src, dst, paint);

        left += soilder.getWidth() / 4;
        left = left % soilder.getWidth();
    }
}
