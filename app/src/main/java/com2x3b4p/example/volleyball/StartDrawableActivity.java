package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartDrawableActivity extends AppCompatActivity {
    private static final  long DISPLAY_DRAWABLE=1300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_drawable);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=Activity_Login.action_Activity_Login(StartDrawableActivity.this);
                startActivity(intent);
                StartDrawableActivity.this.finish();
            }
        }, DISPLAY_DRAWABLE);
    }
}
