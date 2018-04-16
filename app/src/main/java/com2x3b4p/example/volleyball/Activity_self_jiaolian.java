package com2x3b4p.example.volleyball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class Activity_self_jiaolian extends AppCompatActivity {
    private ImageView imageView_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_jiaolian);
        imageView_back=(ImageView)findViewById(R.id.image_back_jiaolian);

        int resource=R.drawable.home_background;
        Glide.with(Activity_self_jiaolian.this)
                .load(resource)
                .bitmapTransform(new BlurTransformation(this, 14, 3))
                .into(imageView_back);
    }
}
