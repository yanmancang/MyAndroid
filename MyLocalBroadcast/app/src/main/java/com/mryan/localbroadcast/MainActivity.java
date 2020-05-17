package com.mryan.localbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocalBroadcastReceive localBroadcastReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "------------------" + System.currentTimeMillis());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TextView");
        localBroadcastReceive = new LocalBroadcastReceive(list, findViewById(R.id.text_view));
        LocalBroadcastManager.getInstance(this).registerReceiver(localBroadcastReceive, intentFilter);
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localBroadcastReceive);
        super.onDestroy();
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("TextView");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
