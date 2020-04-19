package com.mryan.mybasequickadapter.bean;

import java.util.Random;

public class PersonBean {
    String name;
    String imageUrl;
    String addr;
    int age;
    int type = new Random().nextInt(2);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}
