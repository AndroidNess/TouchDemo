package itworks.tomer.edu.touchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = (PaintView)findViewById(R.id.paintView);
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

    public void clear(View view) {
        paintView.clear();
    }

    public void red(View view) {
        paintView.changeColor("red");
    }
}
