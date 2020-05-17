package com.mryan.sharedelement;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.image_view).setBackground(this.getDrawable(R.drawable.ic_launcher_background));
        ((TextView)findViewById(R.id.text_image)).setText("我是第二页的描述");
    }
}
