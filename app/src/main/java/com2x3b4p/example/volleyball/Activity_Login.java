package com2x3b4p.example.volleyball;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import JavaBean.Chuan;
import JavaBean.Fa;
import JavaBean.Fang;
import JavaBean.Kou;
import JavaBean.Lan;
import JavaBean.Member;
import JavaBean.Team;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener{
    private Button button_login;
    private Button button_register;
    private Button button_wangji;
    private EditText editText_zhanghu;
    private EditText editText_mima;
    private ProgressBar progressBar;

    public static Intent action_Activity_Login(Context context){
        Intent intent=new Intent(context,Activity_Login.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ////////////////////////////////Bmob 的初始化////////////////////////////////

        BmobConfig config=new BmobConfig.Builder(this)
                .setApplicationId("e91d6c27d1a427e165846bc8e4a6c6fe")
                .setConnectTimeout(15)
                .setUploadBlockSize(1024*1024)
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);

        ////////////////////////////////Bmob 的初始化////////////////////////////////

        setContentView(R.layout.activity__login);
        progressBar=(ProgressBar)findViewById(R.id.main_progress);
        button_wangji=(Button)findViewById(R.id.button_wangji);

        button_login=(Button)findViewById(R.id.login_button);
        button_register=(Button)findViewById(R.id.register_button);
        editText_zhanghu=(EditText)findViewById(R.id.login_account_Edit_text);
        editText_mima=(EditText)findViewById(R.id.login_passWord_Edit_text);
        button_login.setOnClickListener(this);
        button_wangji.setOnClickListener(this);
        button_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                button_login.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                final String login_zhanghu=editText_zhanghu.getText().toString();
                final String login_mima=editText_mima.getText().toString();
                Member member=new Member();
                member.setUsername(login_zhanghu);
                member.setPassword(login_mima);
                member.login(new SaveListener<Member>() {
                    @Override
                    public void done(Member member, BmobException e) {
                        if(e==null){
                            Toast.makeText(Activity_Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                            Intent intent1=MainActivity.action_MainActivity(Activity_Login.this);
                            startActivity(intent1);
                        }else{
                            button_login.setEnabled(true);
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(Activity_Login.this,"账户或密码错误"+"\n错误代码:"+e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            case R.id.register_button:
                AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_Login.this);
                dialog.setTitle("请选择用户初测类型：")
                        .setMessage("A：教练\nB：队员")
                        .setCancelable(true);
                dialog.setPositiveButton("B", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1=Activity_register.newInstance(Activity_Login.this,"B");
                        startActivity(intent1);
                    }
                });
                dialog.setNegativeButton("A", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1=Activity_register.newInstance(Activity_Login.this,"A");
                        startActivity(intent1);
                    }
                });
                dialog.show();
                break;
            case R.id.button_wangji:

                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        button_login.setEnabled(true);
        progressBar.setVisibility(View.INVISIBLE);
        super.onStop();
    }
}
