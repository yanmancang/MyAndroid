package com.mryan.mybasequickadapter.bean;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class PersonDataManager {
    private static final String TAG = "PersonDataManager";
    private static PersonDataManager instance = new PersonDataManager();

    private List<String> names = new ArrayList<String>() {{
        add(UUID.randomUUID().toString());
        add(UUID.randomUUID().toString());
        add(UUID.randomUUID().toString());
        add(UUID.randomUUID().toString());
        add(UUID.randomUUID().toString());
        add(UUID.randomUUID().toString());
    }};

    private List<String> imageUrls = new ArrayList<String>() {{
        add("http://www.jf258.com/uploads/2014-09-19/032801320.jpg");
        add("http://image.biaobaiju.com/uploads/20180508/11/1525749276-jSNaReDiHQ.jpg");
        add("http://img5.imgtn.bdimg.com/it/u=2897893588,1955083775&fm=26&gp=0.jpg");
        add("http://img2.imgtn.bdimg.com/it/u=1241207982,1526171216&fm=26&gp=0.jpg");
        add("http://img1.imgtn.bdimg.com/it/u=2504826296,1839652285&fm=214&gp=0.jpg");
        add("http://image.biaobaiju.com/uploads/20180226/12/1519617820-zlmPWgVjZC.jpg");
    }};

    private List<String> addrs = new ArrayList<String>() {{
        add("广东深圳" + System.currentTimeMillis());
        add("广东深圳" + System.currentTimeMillis());
        add("广东广州" + System.currentTimeMillis());
        add("广东广州" + System.currentTimeMillis());
        add("广东东莞" + System.currentTimeMillis());
        add("广东东莞" + System.currentTimeMillis());
    }};

    private List<Integer> ages = new ArrayList<Integer>() {{
        add(18);
        add(19);
        add(20);
        add(21);
        add(22);
        add(23);

    }};

    private List<PersonBean> personBeans = new ArrayList<>();

    public static PersonDataManager getInstance() {
        return instance;
    }

    public List<PersonBean> generatePersonData(int size, boolean adding) {
        if (!adding) {
            personBeans.clear();
        }
        for (int i = 0; i < size; i++) {
            PersonBean personBean = new PersonBean();
            personBean.setName(names.get(getPosition()));
            personBean.setAddr(addrs.get(getPosition()));
            personBean.setImageUrl(imageUrls.get(getPosition()));
            personBean.setAge(ages.get(getPosition()));
            personBeans.add(personBean);
        }
        Log.e(TAG, "generatePersonData: " + personBeans.toString());
        return personBeans;
    }

    private int getPosition() {
        return new Random().nextInt(names.size());
    }

}
