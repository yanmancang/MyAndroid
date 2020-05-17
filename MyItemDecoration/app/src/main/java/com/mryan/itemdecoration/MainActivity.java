package com.mryan.itemdecoration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * 主要用来测试ItemDecoration
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        // No.1:添加默认的水平线效果 -------------------
        //recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        // No.2:自定义渐变线
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        //dividerItemDecoration.setDrawable(this.getDrawable(R.drawable.custom_divider));
        //recyclerView.addItemDecoration(dividerItemDecoration);
        // No.3 自定义RecyclerView的分割线装饰器
       // recyclerView.addItemDecoration(new RecycleViewDivider(this,LinearLayoutManager.VERTICAL));
        //添加自定义分割线：可自定义分割线drawable
//        recyclerView.addItemDecoration(new RecycleViewDivider(
//                this, LinearLayoutManager.HORIZONTAL, R.drawable.custom_divider));
        //添加自定义分割线：可自定义分割线高度和颜色
        recyclerView.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, 10, getResources().getColor(R.color.colorAccent)));
        recyclerView.setOnClickListener(new RecyclerView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " );
                Toast.makeText(v.getContext(), "recycler", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    public void test(View view) {
        Log.e(TAG, "test: " );
    }
}
