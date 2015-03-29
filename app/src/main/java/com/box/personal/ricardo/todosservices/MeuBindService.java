package com.box.personal.ricardo.todosservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ricardo on 29/03/2015.
 */
public class MeuBindService extends Service{

    class MeuBinder extends Binder{
        public MeuBindService getService(){
            return MeuBindService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(MainActivity.TAG, "MeuBindService. OnBind");
        return new MeuBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(MainActivity.TAG, "MeuBindService. OnDestroy");
    }

    public void geraNumero(){
        int nr = ((int)(Math.random()*100));
        Log.e(MainActivity.TAG, "Você tem " + nr + "% de passar de ano!");
    }
}
