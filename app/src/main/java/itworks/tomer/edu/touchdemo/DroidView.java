package itworks.tomer.edu.touchdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Dev on 19/04/2016.
 */
public class DroidView extends View {
    private final int width;
    private final int height;
    float x, y;
    private final Bitmap hat;

    public DroidView(Context context) {
        super(context);
        hat = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
        width = hat.getWidth();
        height = hat.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(hat, x, y, null);
    }

    @Override
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
