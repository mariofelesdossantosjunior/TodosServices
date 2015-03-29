package com.box.personal.ricardo.todosservices;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ricardo on 29/03/2015.
 */
public class MeuIntentService extends IntentService{

    public MeuIntentService() {
        super("MeuIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(MainActivity.TAG, "MeuIntentService - OnHandleIntent Start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(MainActivity.TAG, "MeuIntentService - OnHandleIntent End");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(MainActivity.TAG, "MeuIntentService - OnDestroy");
    }
}
