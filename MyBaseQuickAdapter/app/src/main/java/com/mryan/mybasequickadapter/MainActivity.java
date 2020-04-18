package com.mryan.mybasequickadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.mryan.mybasequickadapter.bean.PersonBean;
import com.mryan.mybasequickadapter.bean.PersonDataManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_id);
        MyAdapter myAdapter = new MyAdapter(R.layout.item_recycler_view, generateData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        recyclerView.setAdapter(myAdapter);
        /**
         * 说明：此头部并不是item的头部，而是整个Adapter的头部
         * 设置headerView
         * https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/readme/2-BaseQuickAdapter%E7%A9%BA%E5%B8%83%E5%B1%80.md
         * 并不会改变布局的Item的position
         */
//        View view = LayoutInflater.from(getApplication()).inflate(R.layout.item_recycler_view, null);
//        myAdapter.addHeaderView(view);
//        View view2 = LayoutInflater.from(getApplication()).inflate(R.layout.item_recycler_view, null);
//        myAdapter.addHeaderView(view2);
//        View view3 = LayoutInflater.from(getApplication()).inflate(R.layout.item_recycler_view, null);
//        myAdapter.addHeaderView(view3);
//        View view4 = LayoutInflater.from(getApplication()).inflate(R.layout.item_recycler_view, null);
//        myAdapter.addHeaderView(view4);
//        View view5 = LayoutInflater.from(getApplication()).inflate(R.layout.item_recycler_view_copy, null);
//        myAdapter.addHeaderView(view5, 3);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Toast.makeText(getApplicationContext(), "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        myAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Toast.makeText(getApplicationContext(), "the child item:" + view.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        /**
         *  注册子item的监听事件，说明：
         *  以前实在ViewHolader中注册的，现在迁移到adapter中
         */
        myAdapter.addChildClickViewIds(R.id.image_id);
        myAdapter.addChildClickViewIds(R.id.name_id);
        myAdapter.addChildClickViewIds(R.id.age_id);
        myAdapter.addChildClickViewIds(R.id.addr_id);
    }

    private List<PersonBean> generateData() {
        return PersonDataManager.getInstance().generatePersonData(20, false);
    }
}
