package com2x3b4p.example.volleyball;

import android.graphics.drawable.Drawable;
        import android.media.Image;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;

public class Activity_ChaXun_11 extends AppCompatActivity {
    private ImageView image_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cha_xun_11);
        image_back=(ImageView)findViewById(R.id.serch1_imageView);
        image_back.setImageResource(R.drawable.find_back);

    }
}
