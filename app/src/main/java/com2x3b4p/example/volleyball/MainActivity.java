package com2x3b4p.example.volleyball;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;

import JavaBean.Member;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_jifen;
    private Button button_chaxun;
    private Button button_wode;
    private Button button_shangchuan;
    private Member administor;
    private String download_image_path;

    private LinearLayout choose_jifen_view;
    private LinearLayout choose_shangchuan_view;


    public static Intent action_MainActivity(Context context){
        Intent intent=new Intent(context,MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choose_jifen_view=(LinearLayout)findViewById(R.id.choose_jifen_view);
        choose_shangchuan_view=(LinearLayout)findViewById(R.id.choose_shangchuan_view);
        administor=BmobUser.getCurrentUser(Member.class);
        if(administor.getJiaolian()){
            choose_shangchuan_view.setVisibility(View.VISIBLE);
        }else {
            choose_jifen_view.setVisibility(View.VISIBLE);
        }

        button_jifen=(Button)findViewById(R.id.button_choose_jifen);
        button_chaxun=(Button)findViewById(R.id.button_choose_chaxun);
        button_wode=(Button)findViewById(R.id.button_choose_wode);
        button_shangchuan=(Button)findViewById(R.id.button_choose_shangchuan);
        button_jifen.setOnClickListener(this);
        button_chaxun.setOnClickListener(this);
        button_wode.setOnClickListener(this);
        button_shangchuan.setOnClickListener(this);
    }

    /////////////////////////////// 监听控件点击事件//////////////////////////////
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_choose_jifen:
                Intent intent1=new Intent(MainActivity.this,Activity_duiyuahao_input.class);
                startActivity(intent1);
                break;
            case R.id.button_choose_chaxun:
                Intent intent2=new Intent(MainActivity.this,Activity_ChaXun_1.class);
                startActivity(intent2);
                break;
            case R.id.button_choose_wode:
                if(administor.getJiaolian()){
                    Intent intent3=new Intent(MainActivity.this,Activity_self_jiaolian.class);
                    startActivity(intent3);
                }else {
                    Intent intent3=new Intent(MainActivity.this,Activity_duiyuan_self.class);
                    startActivity(intent3);
                }
                break;
            case R.id.button_choose_shangchuan:
                Intent intent4=new Intent(MainActivity.this,Activity_JiLu_1.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
    /////////////////////////////// 监听控件点击事件//////////////////////////////



}
