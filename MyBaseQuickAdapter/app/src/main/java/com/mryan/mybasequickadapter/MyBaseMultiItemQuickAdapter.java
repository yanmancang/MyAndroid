package com.mryan.mybasequickadapter;

import android.animation.Animator;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mryan.mybasequickadapter.bean.MultiItemPersonBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class MyBaseMultiItemQuickAdapter extends BaseMultiItemQuickAdapter<MultiItemPersonBean, BaseViewHolder> implements LoadMoreModule {
    private static final String TAG = "MyBaseMultiItemQuickAda";

    public MyBaseMultiItemQuickAdapter(List<MultiItemPersonBean> data) {
        /**
         * 设置对应不同ItemType所采用的布局文件
         */
        super(data);
        addItemType(0, R.layout.multi_item_0);
        addItemType(1, R.layout.multi_item_1);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MultiItemPersonBean multiItemPersonBean) {
        Log.e(TAG, "convert: ");
        /**
         * 如果两个layout布局文件中的控件id设置的相同，将会复用控件
         */
        switch (multiItemPersonBean.getItemType()) {
            case 0:
                ((TextView) baseViewHolder.getView(R.id.name_id)).setText(multiItemPersonBean.getName());
                Glide.with(getContext()).load(multiItemPersonBean.getImageUrl()).into((ImageView) baseViewHolder.getView(R.id.image_id));
                ((TextView) baseViewHolder.getView(R.id.age_id)).setText(multiItemPersonBean.getAge() + "");
                ((TextView) baseViewHolder.getView(R.id.addr_id)).setText(multiItemPersonBean.getAddr());
                break;
            case 1:
                ((TextView) baseViewHolder.getView(R.id.name_id1)).setText(multiItemPersonBean.getName());
                Glide.with(getContext()).load(multiItemPersonBean.getImageUrl()).into((ImageView) baseViewHolder.getView(R.id.image_id1));
                ((TextView) baseViewHolder.getView(R.id.age_id1)).setText(multiItemPersonBean.getAge() + "");
                ((TextView) baseViewHolder.getView(R.id.addr_id1)).setText(multiItemPersonBean.getAddr());

        }
    }


    @Override
    protected void startAnim(@NotNull Animator anim, int index) {
        Log.e(TAG, "startAnim: " + index);
        /**
         * 3.x中由于去掉了前多少条Item不显示动画效果；可以通过这种形式来达到同样的结果
         */
        if (index < 5) {
            return;
        } else {
            super.startAnim(anim, index);
        }


    }

}
