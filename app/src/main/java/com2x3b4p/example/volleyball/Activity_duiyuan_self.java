package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;

import JavaBean.Member;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class Activity_duiyuan_self extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView_self_back;
    private TextView textView_xiugai;
    private TextView textView_zhuti;
    private TextView textView_shuju;
    private TextView textView_kefu;

    private String download_image_path="";

    private ImageView imageView_menu_Touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duiyuan_self);

        downloadFile(BmobUser.getCurrentUser(Member.class).getTouxiang_member());

        imageView_self_back=(ImageView)findViewById(R.id.image_back_person);

        imageView_menu_Touxiang=(ImageView)findViewById(R.id.image_duiyuan_touxiang);
        textView_xiugai=(TextView)findViewById(R.id.textView_xiugai);
        textView_zhuti=(TextView)findViewById(R.id.textView_zhuti);
        textView_shuju=(TextView)findViewById(R.id.textView_shuju);
        textView_kefu=(TextView)findViewById(R.id.textView_kefu);
        textView_xiugai.setOnClickListener(this);
        textView_zhuti.setOnClickListener(this);
        textView_shuju.setOnClickListener(this);
        textView_kefu.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView_xiugai:
                Intent intent1=Activity_edit.actionBianjiActivity(Activity_duiyuan_self.this,download_image_path);
                startActivity(intent1);
                break;
            case R.id.textView_zhuti:
                break;
            case R.id.textView_shuju:
                break;
            case R.id.textView_kefu:
                break;
                default:
                    break;
        }
    }

    private void downloadFile(BmobFile file){
        File saveFile=new File(Environment.getExternalStorageDirectory(),file.getFilename());
        file.download(saveFile, new DownloadFileListener() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    if(s!=null){
                        download_image_path=s;
                        final Bitmap bitmap= BitmapFactory.decodeFile(download_image_path);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView_menu_Touxiang.setImageBitmap(bitmap);
                                Glide.with(Activity_duiyuan_self.this)
                                        .load(download_image_path)
                                        .bitmapTransform(new BlurTransformation(Activity_duiyuan_self.this, 14, 3))
                                        .into(imageView_self_back);
                            }
                        });
                    }else {
                        Toast.makeText(Activity_duiyuan_self.this,"下载失败"+e.getMessage()+e.getErrorCode(),Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onProgress(Integer integer, long l) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
