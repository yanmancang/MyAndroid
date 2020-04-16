package com.mryan.myrecycleview.base;

import android.Manifest;
import android.app.Person;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mryan.myrecycleview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BaseRecycleViewActivity extends AppCompatActivity {
    private static final String TAG = "BaseRecycleViewActivity";
    RecyclerView recyclerView;
    List<String> image, sexs;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 1);
            }
        }
        setContentView(R.layout.base_recycle_activity);
        List<String> list = new ArrayList<>();
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2122675991,3713636489&fm=26&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=342384084,2665076075&fm=26&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=2652888150,491713303&fm=11&gp=0.jpg");
        list.add("http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=f8cefcffa0ec8a13141a55e0c738e0b2/dc54564e9258d1091c3c71a2d858ccbf6d814dc7.jpg");
        list.add("http://5b0988e595225.cdn.sohucs.com/images/20170708/acd10d909fa64fbe8de0eed6d33958ca.png");
        list.add("http://img4.imgtn.bdimg.com/it/u=37262944,4020537336&fm=26&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3390735019,3985624395&fm=26&gp=0.jpg");
        list.add("http://ztd00.photos.bdimg.com/ztd/w=700;q=50/sign=428663b7e050352ab161270863788acf/dcc451da81cb39dbce880b56d9160924ab183061.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587067559326&di=0c7e6d29fd985e59f615e2448a9210b2&imgtype=0&src=http%3A%2F%2F1823.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F1%2F4%2F9%2F28%2Fu82730558_12e0661b565g214.jpg");
        image = list;
        List<String> sexs = new ArrayList<>();
        sexs.add("W");
        sexs.add("M");
        this.sexs = sexs;
        new Thread(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }).start();
    }

    private List<PersonData> generateData() {
        List<PersonData> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PersonData personData = new PersonData();
            personData.image = image.get(new Random().nextInt(image.size()));
            personData.sex = sexs.get(new Random().nextInt(sexs.size()));
            personData.name = UUID.randomUUID().toString();
            personData.number = System.currentTimeMillis() + "";
            data.add(personData);
        }
        return data;
    }

    private void init() {
        recyclerView = findViewById(R.id.base_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BaseRecycleViewAdapter(generateData(), this));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                /**
                 * recyclerView: 当前在滚动的RecyclerView
                 * newState: 当前滚动状态.
                 */
                super.onScrollStateChanged(recyclerView, newState);
                Log.e(TAG, "onScrollStateChanged: " + newState);
                Log.e(TAG, "onScrollStateChanged: " + recyclerView.canScrollVertically(1));
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                /**
                 * 回调的三个变量含义:
                 * recyclerView : 当前滚动的view
                 * dx : 水平滚动距离
                 * dy : 垂直滚动距离
                 *
                 * dx > 0 时为手指向左滚动,列表滚动显示右面的内容
                 * dx < 0 时为手指向右滚动,列表滚动显示左面的内容
                 * dy > 0 时为手指向上滚动,列表滚动显示下面的内容
                 * dy < 0 时为手指向下滚动,列表滚动显示上面的内容
                 *
                 */
                Log.e(TAG, "onScrolled: " + dx + "/" + dy);
            }
        });
    }
}
