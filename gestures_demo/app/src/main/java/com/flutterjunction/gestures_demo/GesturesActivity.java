package com.flutterjunction.gestures_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GesturesActivity extends AppCompatActivity implements  GestureDetector.OnGestureListener, View.OnTouchListener,GestureDetector.OnDoubleTapListener {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        gestureDetector = new GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        View touchView = findViewById(R.id.touch_view);
        touchView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(this, "Touch Gesture: Down", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }


    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this, "Touch Gesture: Single Tap Up", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this, "Touch Gesture: Scroll", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "Touch Gesture: Long Press", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(this, "Touch Gesture: Fling", Toast.LENGTH_SHORT).show();
        return true;
    }

    // Double Tap Gesture

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Toast.makeText(this, "Double Tap Gesture: Single Tap Confirmed", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(this, "Double Tap Gesture: Double Tap", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Toast.makeText(this, "Double Tap Gesture: Double Tap Event", Toast.LENGTH_SHORT).show();
        return true;
    }

}