package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import JavaBean.BiSai;

public class Activity_JiLu_1 extends AppCompatActivity implements View.OnClickListener{
    private Button button_next;
    private EditText editText_zhuduiming;
    private EditText editText_keduiming;
    private EditText editText_shijian;
    private EditText editText_didian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ji_lu_1);
        button_next=(Button)findViewById(R.id.button_ji_lu_next);
        button_next.setOnClickListener(this);
        editText_zhuduiming=(EditText)findViewById(R.id.edit_input_zhuduiming);
        editText_keduiming=(EditText)findViewById(R.id.edit_input_keduiming);
        editText_shijian=(EditText)findViewById(R.id.edit_input_shijian);
        editText_didian=(EditText)findViewById(R.id.edit_input_didian);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_ji_lu_next:
                final String string_zhuduiming=editText_zhuduiming.getText().toString();
                final String string_keduiming=editText_keduiming.getText().toString();
                final String string_shijian=editText_shijian.getText().toString();
                final String string_didian=editText_didian.getText().toString();
                if(string_zhuduiming.equals("")||string_keduiming.equals("")||string_shijian.equals("")||string_didian.equals("")){
                    Toast.makeText(Activity_JiLu_1.this,"请完善比赛信息",Toast.LENGTH_LONG).show();
                }else{
                    BiSai bisai=new BiSai();
                    bisai.setCompetition_time(string_shijian);
                    bisai.setCompetition_place(string_didian);
                    bisai.setTeam_name_A(string_zhuduiming);
                    bisai.setTeam_name_B(string_keduiming);
                    Intent intent=new Intent(Activity_JiLu_1.this,Activity_JiLu_2.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
