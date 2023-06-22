package com.flutterjunction.canvas_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    private class CustomView extends View {
        private Paint paint;
        private Bitmap bitmap;

        public CustomView(Context context) {
            super(context);
            paint = new Paint();
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Set the background color
            canvas.drawColor(Color.WHITE);

            // Set the paint color and style
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            paint.setColor(Color.RED);


            // Draw a rounded rectangle
            RectF rect = new RectF(50, 50, 250, 150);
            canvas.drawRoundRect(rect, 20, 20, paint);

            // Draw a circle
            paint.setColor(Color.BLUE);
            canvas.drawCircle(400, 100, 50, paint);

            // Draw text
            paint.setColor(Color.BLACK);
            paint.setTextSize(40);
            canvas.drawText("Hello, Android!", 50, 250, paint);

            // Draw a bitmap
            canvas.drawBitmap(bitmap, 300, 200, null);

            // Draw an ARGB color
            canvas.drawARGB(128, 255, 0, 0);
        }
    }
}
