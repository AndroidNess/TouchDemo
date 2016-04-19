package itworks.tomer.edu.touchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DroidView(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                System.out.println("Down");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("Move");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("Up");
                break;
        }

        System.out.println(event.getX());
        System.out.println(event.getY());
        return true;
    }
}
