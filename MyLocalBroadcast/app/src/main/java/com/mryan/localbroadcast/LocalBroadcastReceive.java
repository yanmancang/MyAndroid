package com.mryan.localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class LocalBroadcastReceive extends BroadcastReceiver {
    private static final String TAG = "LocalBroadcastReceive";
    List<String> list;
    int index = 0;
    View view;

    public LocalBroadcastReceive(List<String> list, View view) {
        this.list = list;
        this.view = view;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 回调是在主线程中的
        Log.e(TAG, "onReceive: " + Thread.currentThread());
        if (intent.getAction().equals("TextView")) {
            ((TextView) view).setText(list.get(index)+Thread.currentThread().getName());
            index++;
            if (index >= list.size()) {
                index = 0;
            }
        }
    }
}
