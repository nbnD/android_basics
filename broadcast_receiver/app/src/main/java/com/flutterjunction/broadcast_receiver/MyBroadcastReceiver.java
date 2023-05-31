package com.flutterjunction.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Check the action of the received intent
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            // The device is connected to a power source
            Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            // The device is disconnected from a power source
            Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}

