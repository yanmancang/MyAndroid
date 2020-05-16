package com.mryan.animator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ImageView imageView;
    int[] ids = {R.id.imageView_first, R.id.imageView_second, R.id.imageView_three, R.id.imageView_five, R.id.imageView_four, R.id.imageView_six, R.id.imageView_seven, R.id.imageView_ten};
    List<ImageView> imageViews = new ArrayList<>();
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = findViewById(ids[i]);
            imageViews.add(imageView);
        }
    }

    public void imageView(View view) {
        Toast.makeText(getApplicationContext(), "imageView", Toast.LENGTH_LONG).show();
    }

    public void button(View view) {
        switch (view.getId()) {
            case R.id.button:
                play();
                break;
            case R.id.button1:
                play2();
                break;
            case R.id.button2:
                play3();
                break;
            case R.id.button3:
                play4();
                break;
            case R.id.button4:
                play5();
                break;
            case R.id.button5:
                play6();
                break;
            case R.id.button6:
                play7();
                break;
            case R.id.button7:
                play8();
                break;
            default:
                Toast.makeText(getApplicationContext(), view.getId() + "", Toast.LENGTH_SHORT).show();
                //play9();
                randomTest();
        }
        // 使用原生的Animation动画效果
    }

    private void randomTest() {
        // 数值产生器
        final TextView textView = findViewById(R.id.textView);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        // 自定义数据类型
//        ValueAnimator.ofObject(new TypeEvaluator() {
//            @Override
//            public Object evaluate(float fraction, Object startValue, Object endValue) {
//                return null;
//            }
//        })
        valueAnimator.setDuration(5000);
        valueAnimator.start();
//        valueAnimator.pause();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer integer = (Integer) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: " + integer);
                if (flag){
                    textView.setText(integer+"");
                }
            }
        });
    }

    private void play() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(false);
        imageView.startAnimation(translateAnimation);
    }

    public void play2() {
        // 属性动画框架 translationX是偏移量，X是最终到达的位置
        ObjectAnimator.ofFloat(imageView, "translationX", 0F, 300F).setDuration(2000).start();

        ObjectAnimator.ofFloat(imageView, "rotation", 0, 360F).setDuration(1000).start();


    }

    private void play3() {
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0, 360);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0, 200F);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0, 200F);
        ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(2000).start();
    }

    public void play4() {
        // 另一种写法,动画效果共同执行
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(objectAnimator1, objectAnimator2, objectAnimator3);
        set.setDuration(1000);
        set.start();
    }


    private void play5() {
        // 顺序执行动画效果
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3);
        set.setDuration(1000);
        set.start();
    }

    private void play6() {
        // 混合执行动画效果

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2);
        set.play(objectAnimator3).after(objectAnimator1);
        set.setDuration(1000);
        set.start();
    }

    private void play7() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "alpha", 0F, 1F);
        objectAnimator1.setDuration(2000);
        objectAnimator1.start();
    }

    private void play8() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        // 全部监听事件
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e(TAG, "onAnimationStart: ");
                Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                Log.e(TAG, "onAnimationEnd: ");
                Toast.makeText(getApplicationContext(), "end", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e(TAG, "onAnimationCancel: ");
                Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e(TAG, "onAnimationRepeat: ");
                Toast.makeText(getApplicationContext(), "repeat", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void play9(View view) {
        if (flag) {
            for (int i = 1; i < imageViews.size(); i++) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageViews.get(i), "translationY", 0F, i * 100);
                objectAnimator.setDuration(200);
                objectAnimator.setStartDelay(200 * i);
                objectAnimator.setInterpolator(new AnticipateInterpolator());
                objectAnimator.start();
            }
            flag = false;
        } else {
            for (int i = 1; i < imageViews.size(); i++) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageViews.get(i), "translationY", i * 100, 0F);
                objectAnimator.setDuration(200);
                objectAnimator.setStartDelay(200 * i);
                objectAnimator.start();
            }
            flag = true;
        }
    }
}
