package itworks.tomer.edu.touchdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;


public class DroidView extends View {
    private final int width, height;
    float x, y;

    private final Bitmap hat, face, mustache;
    public DroidView(Context context) {
        super(context);
        hat = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
        face = BitmapFactory.decodeResource(getResources(), R.drawable.face);
        mustache = BitmapFactory.decodeResource(getResources(), R.drawable.mustache);
        width = hat.getWidth();
        height = hat.getHeight();
    }
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(hat, x +200, y+200, null);
        canvas.drawBitmap(face, x, y, null);
        canvas.drawBitmap(mustache, x, y, null);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if (testColision(event)) {
            x = event.getX() - width / 2;
            y = event.getY() - height / 2;
            invalidate();
        }
        return true;
    }
     private boolean testColision(MotionEvent e){
        boolean isXcolision = e.getX() <= x + width && e.getX() >= x;
        boolean isYcolision = e.getY() <= y + height && e.getY() >= y;
        return isXcolision && isYcolision;
    }
}
