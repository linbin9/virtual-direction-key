package com.example.administrator.directionkey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/8/24.
 */

public class DU extends View {
    public DU(Context context){
        super(context);
    }
    public DU(Context context, AttributeSet set){
        super(context);
    }
    public void onDraw(Canvas canvas){
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        Path pathLeft = new Path();
        pathLeft.moveTo(0,height);
        pathLeft.lineTo(0,height/2);
        pathLeft.lineTo(width/2,0);
        pathLeft.lineTo(width,height/2);
        pathLeft.lineTo(width,height);
        pathLeft.close();

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawPath(pathLeft, paint);

        Rect targetRect = new Rect(0,height,width,height/2);
        paint.setStrokeWidth(3);
        paint.setTextSize(40);
        String testString = "上";
        paint.setColor(Color.BLACK);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        int baseline2=targetRect.bottom-((targetRect.bottom-targetRect.top-fontMetrics.bottom+fontMetrics.top)/2+fontMetrics.bottom);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(testString, targetRect.centerX(), baseline, paint);
    }
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("按下：","上");
        }
        return true;
    }
}
