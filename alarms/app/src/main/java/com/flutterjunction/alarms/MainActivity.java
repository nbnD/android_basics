package com.flutterjunction.alarms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private static final int ALARM_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the desired alarm time (e.g., 8:00 AM)
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 46);
        calendar.set(Calendar.SECOND, 0);

        // Set the RTC_WAKEUP alarm
        setRTCWakeupAlarm(this, calendar.getTimeInMillis());
    }
    private void setRTCWakeupAlarm(Context context, long triggerAtMillis) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ALARM_REQUEST_CODE,
                intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
    }
}

/*RTC_WAKEUP: This alarm type uses real-time clock time (wall clock time)
and wakes up the device if it is asleep.
It is suitable for scheduling alarms that need to trigger at a specific date and time,
regardless of the device's sleep state.
For example, you might use this alarm type for setting up an alarm clock or scheduling a reminder.*/


/*RTC: Similar to RTC_WAKEUP, this alarm type also uses real-time clock time but does not wake up
the device if it is asleep. It triggers the alarm only when the device is awake. It is useful for
scheduling alarms that don't require immediate attention and can be triggered when the user
interacts with the device.*/

/*ELAPSED_REALTIME: This alarm type uses elapsed time since the device was booted (uptime) as a reference.
 It is not affected by changes in the system time (such as time zone changes). ELAPSED_REALTIME alarms are
 not precise and may drift if the device's system time is adjusted.
 They are suitable for periodic tasks or operations that need to be
 performed at fixed intervals, such as polling for updates or refreshing data.
*/

/*ELAPSED_REALTIME_WAKEUP: Similar to ELAPSED_REALTIME, this alarm type uses elapsed time since the device was
booted but wakes up the device if it is asleep. It combines the benefits of ELAPSED_REALTIME and RTC_WAKEUP by
providing a reliable wakeup mechanism along with the simplicity of elapsed time-based scheduling.*/



