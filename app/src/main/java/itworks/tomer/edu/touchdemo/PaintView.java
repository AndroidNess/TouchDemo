package itworks.tomer.edu.touchdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Dev on 19/04/2016.
 */
public class PaintView extends View {
    Paint paint;
    Path path;
    //Constructor
    public PaintView(Context context) {
        super(context);
        initPaint();
        path = new Path();
    }

    //Constructor


    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        path = new Path();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(0xFFdd00ff);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                path.lineTo(x, y);
                break;
        }
        invalidate();
        return true;
    }

    public void clear() {
        path.reset();
        invalidate();
    }

    public void changeColor(String color) {
        if (color.equals("red")){
            paint.setColor(0xffff0000);
        }
    }
}
