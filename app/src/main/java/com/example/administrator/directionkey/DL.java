package com.example.administrator.directionkey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/8/24.
 */

public class DL extends View {
    public DL(Context context){
        super(context);
    }
    public DL(Context context, AttributeSet set){
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas){
        //画布的宽
        int width = canvas.getWidth();
        //画布的高
        int height = canvas.getHeight();
        /*
        （小提示：在计算机中一般都是将左上角作为坐标原点的）
        画布上四个顶点和中心点的坐标如下：
        左上点 0，0
        左下点 0，height
        右上点 width,0
        右下点 width,height
        中心点 width/2,height/2
        */

        //画左方向键背景三角形的路径
        Path pathLeft = new Path();
        //从画布左上点开始
        pathLeft.moveTo(width / 2 - width / 16, height / 2 + height / 16);
        //画直线到画布中心点
        pathLeft.lineTo(width / 2 - width / 8 - width / 16, height / 2 + height / 16);
        pathLeft.lineTo(width / 2 - width / 4 - width / 16, height / 2 + width / 8 + height / 16);
        pathLeft.lineTo(width / 2 - width / 8 - width / 16, height / 2 + width / 4 + height / 16);
        //再画直线到画布左下点
        pathLeft.lineTo(width / 2 - width / 16, height / 2 + width / 4 + height / 16);
        //自动闭合图形。从最后一个点（左下点）画直线到第一个点（左上点）。
        pathLeft.close();

        //准备画笔
        Paint paint = new Paint();
        //设置画笔的颜色
        paint.setColor(Color.RED);
        //设置画笔为实心（默认就是实心，这里不设置也行）
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        //按照刚才的路径设计画了一个实心的红色三角形
        canvas.drawPath(pathLeft, paint);

        Rect targetRect = new Rect(width / 2 - width / 16, height / 2 + height / 16, width / 2 - width / 8 - width / 16, height / 2 + width / 4 + height / 16);
        paint.setStrokeWidth(3);
        paint.setTextSize(80);
        String testString = "左";
        paint.setColor(Color.BLACK);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        int baseline2=targetRect.bottom-((targetRect.bottom-targetRect.top-fontMetrics.bottom+fontMetrics.top)/2+fontMetrics.bottom);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(testString, targetRect.centerX(), baseline, paint);

    }
}
