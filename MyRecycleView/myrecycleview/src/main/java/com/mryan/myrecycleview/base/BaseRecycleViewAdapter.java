package com.mryan.myrecycleview.base;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        /**
         * 加载Item布局
         */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_recycle_item, null);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: ");
        Glide.with(context).asBitmap().load(personData.get(position).image).override(400, 200).diskCacheStrategy(DiskCacheStrategy.NONE).into(((MyViewHolder) holder).imageView);
        ((MyViewHolder) holder).name.setText(personData.get(position).name);
        ((MyViewHolder) holder).sex.setText(personData.get(position).sex);
        ((MyViewHolder) holder).number.setText(personData.get(position).number);

    }

    @Override
    public int getItemCount() {
        return personData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView name, sex, number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detail_imageView);
            name = itemView.findViewById(R.id.detail_person_name);
            sex = itemView.findViewById(R.id.detail_person_sex);
            number = itemView.findViewById(R.id.detail_person_number);
            imageView.setOnClickListener(this);
            name.setOnClickListener(this);
            sex.setOnClickListener(this);
            number.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v instanceof ImageView) {
                Toast.makeText(context, "image is over!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
