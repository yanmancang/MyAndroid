package com.mryan.mybasequickadapter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mryan.mybasequickadapter.bean.PersonBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<PersonBean, BaseViewHolder> implements AdapterView.OnItemClickListener {
    private static final String TAG = "MyAdapter";

    public MyAdapter(int layoutResId, @Nullable List<PersonBean> data) {
        super(layoutResId, data);
    }

    @Override
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + position);
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PersonBean personBean) {
        ((TextView) baseViewHolder.getView(R.id.name_id)).setText(personBean.getName());
        Glide.with(getContext()).load(personBean.getImageUrl()).into((ImageView) baseViewHolder.getView(R.id.image_id));
        ((TextView) baseViewHolder.getView(R.id.age_id)).setText(personBean.getAge() + "");
        ((TextView) baseViewHolder.getView(R.id.addr_id)).setText(personBean.getAddr());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
