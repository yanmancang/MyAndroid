package com.mryan.mybasequickadapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.mryan.mybasequickadapter.adapter.MyAdapter;
import com.mryan.mybasequickadapter.bean.MultiItemPersonBean;
import com.mryan.mybasequickadapter.bean.PersonBean;
import com.mryan.mybasequickadapter.bean.PersonDataManager;

import java.util.ArrayList;
import java.util.List;

public class BaseMultiItemQuickActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    List<MultiItemPersonBean> personBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_quick_activity_main);
        recyclerView = findViewById(R.id.recyclerView_id);

        final MyBaseMultiItemQuickAdapter myAdapter = new MyBaseMultiItemQuickAdapter(generateData(true));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
         * 加载更多Adapter必须实现LoadMoreMoudle接口
         */
        myAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                // myAdapter.getLoadMoreModule().setEnableLoadMore(true);
                Log.e(TAG, "onLoadMore: ");
                generateData(true);
                //必须添加这个才能刷新界面
                myAdapter.getLoadMoreModule().loadMoreComplete();
                //说没有更多数据可以进行加载
                //myAdapter.getLoadMoreModule().loadMoreEnd();
            }
        });
        // 设置预加载数量
        //myAdapter.getLoadMoreModule().setPreLoadNumber(5);
        //myAdapter.getLoadMoreModule().setAutoLoadMore(true);
        myAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        /**
         *  注册子item的监听事件，说明：
         *  以前实在ViewHolader中注册的，现在迁移到adapter中
         */
        myAdapter.addChildClickViewIds(R.id.image_id);
        myAdapter.addChildClickViewIds(R.id.name_id);
        myAdapter.addChildClickViewIds(R.id.age_id);
        myAdapter.addChildClickViewIds(R.id.addr_id);
        myAdapter.addChildClickViewIds(R.id.image_id1);
        myAdapter.addChildClickViewIds(R.id.name_id1);
        myAdapter.addChildClickViewIds(R.id.age_id1);
        myAdapter.addChildClickViewIds(R.id.addr_id1);
        // 设置动画效果
        myAdapter.setAnimationEnable(true);
        myAdapter.setAnimationFirstOnly(true);
        myAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn);
    }

    private List<MultiItemPersonBean> generateData(boolean adding) {
        return PersonDataManager.getInstance().generateMultiItemPersonData(10, adding);
    }
}
