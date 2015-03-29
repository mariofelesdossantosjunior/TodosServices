package com.box.personal.ricardo.todosservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ricardo on 29/03/2015.
 */
public class MeuService extends Service{

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(MainActivity.TAG, "Service - OnStartCommand");

        TimerTask tTask = new TimerTask() {
            @Override
            public void run() {
                stopSelf();
            }
        };

        Timer timer = new Timer();
        timer.schedule(tTask, 5000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(MainActivity.TAG, "Service - OnDestroy");
        super.onDestroy();
    }
}
