package com.mryan.myrecycleview.base;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mryan.myrecycleview.R;

import java.util.List;

public class BaseRecycleViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = "BaseRecycleViewAdapter";
    List<PersonData> personData;
    Context context;

    public BaseRecycleViewAdapter(List<PersonData> personData, Context context) {
        this.personData = personData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_recycle_item, null);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: ");
        Glide.with(context).asBitmap().load(personData.get(position).image).override(400,200).diskCacheStrategy(DiskCacheStrategy.NONE).into(((MyViewHolder) holder).imageView);
        ((MyViewHolder) holder).textView.setText(personData.get(position).name);
    }

    @Override
    public int getItemCount() {
        return personData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detail_imageView);
            textView = itemView.findViewById(R.id.detail_person);
        }
    }
}
