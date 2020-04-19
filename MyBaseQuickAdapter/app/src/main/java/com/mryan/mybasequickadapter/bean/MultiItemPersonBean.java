package com.mryan.mybasequickadapter.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultiItemPersonBean extends PersonBean implements MultiItemEntity {
    @Override
    public int getItemType() {
        return type;
    }

    @Override
    public String toString() {
        return "MultiItemPersonBean{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
