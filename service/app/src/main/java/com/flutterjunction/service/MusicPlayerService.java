package com.flutterjunction.service;

// MusicPlayerService.java

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicPlayerService extends Service {
    private MediaPlayer mediaPlayer;
//https://developer.android.com/reference/android/media/MediaPlayer
//    https://developer.android.com/develop/background-work/services
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.song); // Load a sample music file
        mediaPlayer.setLooping(true); // Set looping to true so that the music repeats
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start(); // Start playing the music
        return START_STICKY; // Indicates that the service should be restarted if it gets terminated
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop(); // Stop the music
        mediaPlayer.release(); // Release the resources used by the MediaPlayer
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // This service does not support binding, so return null
    }
}


