package com.flutterjunction.gestures_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView touchInfoTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.goToNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GesturesActivity.class);
                startActivity(intent);

            }
        });

        touchInfoTextView = findViewById(R.id.touch_info_textview);
        touchInfoTextView.setOnTouchListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getActionMasked();
        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);

        StringBuilder touchInfoBuilder = new StringBuilder();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
//                This event is triggered when the first finger touches the screen.
                touchInfoBuilder.append("ACTION_DOWN\n");
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
//                Occurs when an additional
//                finger touches the screen while another finger is already touching it.
                touchInfoBuilder.append("ACTION_POINTER_DOWN - pointerId: ").append(pointerId).append("\n");
                break;
            case MotionEvent.ACTION_UP:
//                when the last finger is lifted from the screen.
                touchInfoBuilder.append("ACTION_UP\n");
                break;
            case MotionEvent.ACTION_POINTER_UP:
//                 when one of the multiple fingers is lifted from the screen,
//                 but other fingers are still touching it.
                touchInfoBuilder.append("ACTION_POINTER_UP - pointerId: ").append(pointerId).append("\n");
                break;
            case MotionEvent.ACTION_MOVE:
//                when there is a change in the position of any of the fingers on the screen.
                touchInfoBuilder.append("ACTION_MOVE\n");
                break;
        }

        int pointerCount = event.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int id = event.getPointerId(i);
            float x = event.getX(i);
            float y = event.getY(i);
            touchInfoBuilder.append("Pointer ID: ").append(id)
                    .append(", X: ").append(x)
                    .append(", Y: ").append(y)
                    .append("\n");
        }

        touchInfoTextView.setText(touchInfoBuilder.toString());
        return true;
    }
}
