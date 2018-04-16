package com2x3b4p.example.volleyball;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;

import JavaBean.Chuan;
import JavaBean.Fa;
import JavaBean.Fang;
import JavaBean.Kou;
import JavaBean.Lan;
import JavaBean.Member;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Activity_register extends AppCompatActivity implements View.OnClickListener{
    private String choose_zhuce;
    private EditText editText_xingming;
    private EditText editText_nianling;
    private EditText editText_youxiang;
    private EditText editText_shoujihao;
    private EditText editText_mima;
    private EditText editText_duiyuanhao;
    private Button button_register;
    private LinearLayout layout_duiyuanhao;
    private boolean isJiaolian=false;

    private Fa fa=new Fa();
    private Chuan chuan=new Chuan();
    private Kou kou=new Kou();
    private Lan lan=new Lan();
    private Fang fang=new Fang();

    public static Intent newInstance(Context context,String choose){
        Intent intent=new Intent(context,Activity_register.class);
        intent.putExtra("choose_zhuce",choose);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        choose_zhuce=getIntent().getStringExtra("choose_zhuce");
        fa.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
        kou.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
        chuan.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
        lan.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
        fang.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

            }
        });
        layout_duiyuanhao=(LinearLayout)findViewById(R.id.duiyuanhao_layout);
        if(choose_zhuce.equals("A")){
            layout_duiyuanhao.setVisibility(View.GONE);
        }

        editText_xingming=(EditText)findViewById(R.id.edit_zhuce_xingming);
        editText_nianling=(EditText)findViewById(R.id.edit_zhuce_nianling);
        editText_youxiang=(EditText)findViewById(R.id.edit_zhuce_youxiang);
        editText_shoujihao=(EditText)findViewById(R.id.edit_zhuce_shoujihao);
        editText_duiyuanhao=(EditText)findViewById(R.id.edit_zhuce_duiyuanhao);
        editText_mima=(EditText)findViewById(R.id.edit_zhuce_mima);
        button_register=(Button)findViewById(R.id.button_login_zhuce);
        button_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_login_zhuce:
                final AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_register.this);
                dialog.setTitle("温馨提示：")
                        .setMessage("是否确认注册？")
                        .setCancelable(true);
                dialog.setPositiveButton("修改注册信息", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog dialog1=dialog.create();
                        dialog1.dismiss();        //百度的Dialog的关闭方法
                    }
                });
                dialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(editText_xingming.getText().toString().equals("")||editText_nianling.getText().toString().equals("")||
                                editText_mima.getText().toString().equals("")||
                                editText_youxiang.getText().toString().equals("")||
                                editText_shoujihao.getText().toString().equals("")){
                            if(choose_zhuce.equals("B"))
                            {
                                if(editText_duiyuanhao.getText().toString().equals("")){
                                    Toast.makeText(Activity_register.this,"请完善注册信息",Toast.LENGTH_SHORT).show();
                                    AlertDialog dialog1=dialog.create();
                                    dialog1.dismiss();        //百度的Dialog的关闭方法
                                }
                            }
                            Toast.makeText(Activity_register.this,"请完善注册信息",Toast.LENGTH_SHORT).show();
                            AlertDialog dialog1=dialog.create();
                            dialog1.dismiss();        //百度的Dialog的关闭方法
                        }else{
                            if(choose_zhuce.equals("B")){
                                //////////////////////////////个人比赛得分数据初始化 /////////////////////////////////////////
                                Member member=new Member();
                                member.setScore_fa(fa);
                                member.setScore_lan(lan);
                                member.setScore_kou(kou);
                                member.setScore_chuan(chuan);
                                member.setScore_fang(fang);
                                member.setAge(Integer.parseInt(editText_nianling.getText().toString()));
                                member.setNumber(Integer.parseInt(editText_duiyuanhao.getText().toString()));
                                member.setUsername(editText_xingming.getText().toString());
                                member.setEmail(editText_youxiang.getText().toString());
                                member.setMobilePhoneNumber(editText_shoujihao.getText().toString());
                                member.setPassword(editText_mima.getText().toString());
                                member.signUp(new SaveListener<Member>() {
                                    @Override
                                    public void done(Member member1, BmobException e) {
                                        if (e==null){
                                            Toast.makeText(Activity_register.this,member1.getScore_fa().getScore_shiwu_fa().toString(),Toast.LENGTH_LONG).show();
                                            final AlertDialog.Builder dialog=Alertdialog_h.alertDialog(Activity_register
                                                    .this,"温馨提醒","注册成功！\n是否已经拥有比赛队伍？",false);
                                            dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    Intent intent1=new Intent(Activity_register.this,Activity_find_team.class);
                                                    startActivity(intent1);
                                                    Activity_register.this.finish();
                                                }
                                            });
                                            dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    Toast.makeText(Activity_register.this,"注册成功",Toast.LENGTH_LONG).show();
                                                    dialog.create().dismiss();
                                                    Activity_register.this.finish();
                                                }
                                            });
                                            dialog.show();
                                        }else{
                                            Toast.makeText(Activity_register.this,"注册失败"+e.getMessage()+"Error code:"+e.getErrorCode(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                                //////////////////////////////个人比赛得分数据初始化 /////////////////////////////////////////
                            }else{
                                //////////////////////////////个人比赛得分数据初始化 /////////////////////////////////////////
                                Member member=new Member();
                                member.setAge(Integer.parseInt(editText_nianling.getText().toString()));
                                member.setUsername(editText_xingming.getText().toString());
                                member.setEmail(editText_youxiang.getText().toString());
                                member.setMobilePhoneNumber(editText_shoujihao.getText().toString());
                                member.setPassword(editText_mima.getText().toString());
                                member.setJiaolian(true);
                                member.signUp(new SaveListener<Member>() {
                                    @Override
                                    public void done(Member member1, BmobException e) {
                                        if (e==null){
                                            Toast.makeText(Activity_register.this,"注册成功",Toast.LENGTH_LONG).show();
                                            finish();
                                        }else{
                                            Toast.makeText(Activity_register.this,"注册失败"+e.getMessage()+"Error code:"+e.getErrorCode(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
                dialog.show();
        }
    }
}


