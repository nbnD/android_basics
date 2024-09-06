package com.flutterjunction.service;

// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton=findViewById(R.id.start_button);
        Button stopButton=findViewById(R.id.stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMusicService(v);
                view=v;
            }
        });
            stopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopMusicService(v);
                }
            });

        }

    public void startMusicService(View view) {
        Intent serviceIntent = new Intent(this, MusicPlayerService.class);
        startService(serviceIntent);
    }

    public void stopMusicService(View view) {
        Intent serviceIntent = new Intent(this, MusicPlayerService.class);
        stopService(serviceIntent);
    }
}
