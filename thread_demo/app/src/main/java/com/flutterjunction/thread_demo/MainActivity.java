package com.flutterjunction.thread_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new thread
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code to be executed in the thread
                for (int i = 1; i <= 15; i++) {
                    Log.d("MyThread", "Thread: " + i);

                    try {
                        // Introduce a short delay between each iteration
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Start the thread
        myThread.start();

        // Code executed by the main (UI) thread
        for (int i = 1; i <= 15; i++) {
            Log.d("MyThread", "Main: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
