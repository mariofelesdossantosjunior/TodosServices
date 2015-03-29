package com.box.personal.ricardo.todosservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    public static String TAG = "EX_SERVCIES";

    private ServiceConnection sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MeuService.class);
        startService(i);

        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MeuBindService.MeuBinder meuBinder = (MeuBindService.MeuBinder)iBinder;
                meuBinder.getService().geraNumero();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };

        Intent intent = new Intent(this, MeuBindService.class);
        bindService(intent, sc, Context.BIND_AUTO_CREATE);

        Intent iService = new Intent(this, MeuIntentService.class);
        startService(iService);
        startService(iService);
        startService(iService);
        startService(iService);
        startService(iService);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sc != null) {
            unbindService(sc);
        }
    }
}
