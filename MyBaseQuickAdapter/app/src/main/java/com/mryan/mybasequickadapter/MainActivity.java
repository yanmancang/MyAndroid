package com.mryan.mybasequickadapter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void jumpToActivity(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.base_id:
                intent = new Intent(this, BaseQuickAdapterActivity.class);
                break;
            case R.id.multi_id:
                intent = new Intent(this, BaseMultiItemQuickActivity.class);
                break;
        }
        startActivity(intent);
    }
}
