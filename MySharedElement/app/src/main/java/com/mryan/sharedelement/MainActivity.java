package com.mryan.sharedelement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        Pair<View, String> imagePair = new Pair<View, String>(findViewById(R.id.image_view), "image");
        Pair<View, String> textPair = new Pair<View, String>(findViewById(R.id.text_image), "text");
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imagePair, textPair);
        startActivity(intent, optionsCompat.toBundle());
    }
}
