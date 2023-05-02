package com.flutterjunction.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");
    }


//    It is called when the activity becomes visible to the user
    @Override
    protected void onStart() {
        super.onStart();

//        it is called when the app initialize code and maintains the UI
//        i.e when activity is becoming visible to the user
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
//        this is phase where user interacts with the app
        Log.d("lifecycle","onResume invoked");
    }

//    It is called when the app is on the background and does not
//    receive user input
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
//    This phase is called when the activity is no longer visible

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }

//    It is called when the activity restarts after stopping it
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }

//    It is called before the activity is destroyed by the system
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }
}