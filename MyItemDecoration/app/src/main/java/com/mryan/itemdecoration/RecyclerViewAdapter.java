package com.mryan.itemdecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RecyclerViewAdapter";
    List<String> list = null;

    public RecyclerViewAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i + "");
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        Log.e(TAG, "onBindViewHolder: ");
//        ((MyViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "postion=" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name;
        TextView textView_age;
        TextView textView_addr;
        View view;

        public MyViewHolder(View view) {
            super(view);
            this.view = view;
            textView_name = view.findViewById(R.id.text_view_name);
            textView_age = view.findViewById(R.id.text_view_age);
            textView_addr = view.findViewById(R.id.text_view_addr);
        }
    }
}
