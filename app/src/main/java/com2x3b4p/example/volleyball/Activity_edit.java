package com2x3b4p.example.volleyball;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import JavaBean.Member;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import gongju.PictureUtil;


public class Activity_edit extends AppCompatActivity {
    private ImageView imageView_touxiang;
    private EditText editText_xingming;
    private EditText editText_shoujihao;
    private EditText editText_xuexiao;
    private EditText editText_youxiang;
    private Button button_baocun;
    private Button button_take_photo;
    private Button button_choose_from_album;
    private Member administrator= BmobUser.getCurrentUser(Member.class);
    private Uri imageUri;
    private String imagePath = null;
    private ProgressBar progressBar;


    private String chulihou_imagePath="";

    private static final int TAKE_PHOTO=1;
    private static final int CHOOSE_PHOTO=2;
    public  static Intent actionBianjiActivity(Context context, String touxiang_path){
        Intent intent=new Intent(context,Activity_edit.class);
        intent.putExtra("touxiang_path",touxiang_path);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_edit);
        String touxiang_path=getIntent().getStringExtra("touxiang_path");
        Bitmap bitmap= BitmapFactory.decodeFile(touxiang_path);
        imageView_touxiang=(ImageView)findViewById(R.id.bianji_photo_persion_imageView);
        editText_xingming=(EditText)findViewById(R.id.bianji_xing_ming_information_card_text_view);
        editText_shoujihao=(EditText)findViewById(R.id.bianji_shou_ji_hao_information_card_text_view);
        editText_xuexiao=(EditText)findViewById(R.id.bianji_xue_xiao_information_card_text_view);
        editText_youxiang=(EditText)findViewById(R.id.bianji_you_xiang_information_card_text_view);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar_information);
        button_take_photo=(Button)findViewById(R.id.take_photo_button);
        button_choose_from_album=(Button)findViewById(R.id.choose_photo_button);
        button_baocun=(Button)findViewById(R.id.bianji_baocun);
        editText_xuexiao.setText(administrator.getSchool());
        editText_youxiang.setText(administrator.getEmail());
        editText_shoujihao.setText(administrator.getMobilePhoneNumber());
        editText_xingming.setText(administrator.getUsername());
        imageView_touxiang.setImageBitmap(bitmap);
        button_baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_edit.this);
                dialog.setTitle("提示信息 ：")
                        .setMessage("是否确定修改个人账户信息 ？")
                        .setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        progressBar.setVisibility(View.VISIBLE);
                        if(imagePath!=null){

                            BmobFile yuan_FILE=administrator.getTouxiang_member();
                            if(yuan_FILE!=null){
                                yuan_FILE.setUrl(yuan_FILE.getUrl());
                                yuan_FILE.delete(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {

                                    }
                                });
                            }
                            long t = System.currentTimeMillis();//获得当前时间的毫秒数
                            Random rd = new Random(t);//作为种子数传入到Random的构造器中
                            String targetPath = getExternalCacheDir()+"compressPic"+rd+".jpg";
                            chulihou_imagePath= PictureUtil.compressImage(imagePath,targetPath,30);
                            File file=new File(chulihou_imagePath);
                            final BmobFile bmobFile=new BmobFile(file);
                            bmobFile.uploadblock(new UploadFileListener() {
                                @Override
                                public void done(BmobException e) {
                                    if(e==null){
                                        Toast.makeText(Activity_edit.this,"上传成功",Toast.LENGTH_SHORT).show();
                                        Member user=new Member();
                                        user.setUsername(editText_xingming.getText().toString());
                                        user.setMobilePhoneNumber(editText_shoujihao.getText().toString());
                                        user.setSchool(editText_xuexiao.getText().toString());
                                        user.setEmail(editText_youxiang.getText().toString());
                                        user.setTouxiang_member(bmobFile);
                                        user.update(BmobUser.getCurrentUser(Member.class).getObjectId(), new UpdateListener() {
                                            @Override
                                            public void done(BmobException e) {
                                                if(e==null){
                                                    Toast.makeText(Activity_edit.this,"修改成功",Toast.LENGTH_LONG).show();
                                                    progressBar.setVisibility(View.GONE);
                                                    finish();
                                                }else{
                                                    Toast.makeText(Activity_edit.this,"修改失败"+e.getMessage()+e.getErrorCode(),Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });

                                    }else{
                                        Toast.makeText(Activity_edit.this,"上传失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else{
                            Member user=new Member();
                            user.setUsername(editText_xingming.getText().toString());
                            user.setMobilePhoneNumber(editText_shoujihao.getText().toString());
                            user.setSchool(editText_xuexiao.getText().toString());
                            user.setEmail(editText_youxiang.getText().toString());
                            user.update(BmobUser.getCurrentUser(Member.class).getObjectId(), new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if(e==null){
                                        Toast.makeText(Activity_edit.this,"修改成功",Toast.LENGTH_LONG).show();
                                        finish();
                                    }else{
                                        Toast.makeText(Activity_edit.this,"修改失败"+e.getMessage()+e.getErrorCode(),Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                    }
                });
                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.show();
            }
        });

        button_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                imagePath=outputImage.getAbsolutePath();
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24){
                    imageUri= FileProvider.getUriForFile(Activity_edit.this,"com.example.deamon",outputImage);
                }else {
                    imageUri=Uri.fromFile(outputImage);
                }

                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });

        button_choose_from_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Activity_edit.this, Manifest
                        .permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(Activity_edit.this,new String[]{Manifest.permission.
                            WRITE_EXTERNAL_STORAGE},1);
                }else{
                    openAlbum();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode==RESULT_OK){
                    try{
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        imageView_touxiang.setImageBitmap(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if(resultCode==RESULT_OK){
                    if(Build.VERSION.SDK_INT>=19){
                        handleImageOnKitKat(data);
                    }else{
                        handleImageBeforeKitKat(data);
                    }
                }
            default:
                break;
        }
    }

    private void openAlbum(){
        Intent intent=new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else{
                    Toast.makeText(Activity_edit.this,"Sorry,you denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void handleImageBeforeKitKat(Intent data){
        Uri uri=data.getData();
        String imagePath=getImagePath(uri,null);
        if(imagePath!=null){
            displayImage(imagePath);
        }
        else{
        }

    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        Uri uri;
        uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)){
            String docId=DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id=docId.split(":")[1];
                String selection=MediaStore.Images.Media._ID+"="+id;
                imagePath=getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }
            else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri= ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath=getImagePath(contentUri,null);
            }
        }else if("content".equalsIgnoreCase(uri.getScheme())){
            imagePath=getImagePath(uri,null);
        }
        else if("file".equalsIgnoreCase(uri.getScheme())){
            imagePath=uri.getPath();
        }
        displayImage(imagePath);
    }
    private String getImagePath(Uri uri,String selection){
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,selection,null,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                Log.d("test", "getImagePath: "+path);
            }
            cursor.close();
        }
        return path;

    }
    private void displayImage(String imagePath){
        if(imagePath!=null){
            Toast.makeText(Activity_edit.this,""+imagePath,Toast.LENGTH_LONG).show();
            Bitmap bitmap=BitmapFactory.decodeFile(imagePath);
            imageView_touxiang.setImageBitmap(bitmap);
        }
        else {
            Toast.makeText(this,"Filed to get image .",Toast.LENGTH_SHORT).show();
        }

    }


}
