package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_ChaXun_1 extends AppCompatActivity implements View.OnClickListener{
    private TextView button_choose_find_1;
    private TextView button_choose_find_2;
    private TextView button_choose_find_3;
    private TextView button_choose_find_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chaxun_1);
        button_choose_find_1=(TextView)findViewById(R.id.button_choose_find_1);
        button_choose_find_2=(TextView)findViewById(R.id.button_choose_find_2);
        button_choose_find_3=(TextView)findViewById(R.id.button_choose_find_3);
        button_choose_find_4=(TextView)findViewById(R.id.button_choose_find_4);
        button_choose_find_1.setOnClickListener(this);
        button_choose_find_2.setOnClickListener(this);
        button_choose_find_3.setOnClickListener(this);
        button_choose_find_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_choose_find_1:
                Intent intent1=new Intent(Activity_ChaXun_1.this,Activity_ChaXun_11.class);
                startActivity(intent1);
                break;
            case R.id.button_choose_find_2:
                Intent intent2=new Intent(Activity_ChaXun_1.this,Activity_ChaXun_22.class);
                startActivity(intent2);
                break;
            case R.id.button_choose_find_3:
                Intent intent3=new Intent(Activity_ChaXun_1.this,Activity_ChaXun_33.class);
                startActivity(intent3);
                break;
            case R.id.button_choose_find_4:
                Intent intent4=new Intent(Activity_ChaXun_1.this,Activity_ChaXun_44.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
