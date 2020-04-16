package com.mryan.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mryan.myrecycleview.base.BaseRecycleViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button baseRecycleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseRecycleButton = findViewById(R.id.base_recycle_view);
        baseRecycleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.base_recycle_view:
                intent = new Intent(this, BaseRecycleViewActivity.class);
                break;
            default:
                Log.e(TAG, "onClick: " + v.getId());
                break;
        }
        startActivity(intent);
    }
}
