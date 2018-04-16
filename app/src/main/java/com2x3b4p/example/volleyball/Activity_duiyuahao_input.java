package com2x3b4p.example.volleyball;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import JavaBean.Member;

public class Activity_duiyuahao_input extends AppCompatActivity implements View.OnClickListener {

    private Button editText_duihao_1;
    private Button editText_duihao_2;
    private Button editText_duihao_3;
    private Button editText_duihao_4;
    private Button editText_duihao_5;
    private Button editText_duihao_6;
    private Button editText_duihao_7;
    private Button editText_duihao_8;
    private Button editText_duihao_9;
    private Button editText_duihao_10;
    private Button editText_duihao_11;
    private Button editText_duihao_12;

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;
    private TextView textView_4;
    private TextView textView_5;
    private TextView textView_6;
    private TextView textView_7;
    private TextView textView_8;
    private TextView textView_9;
    private TextView textView_10;
    private TextView textView_11;
    private TextView textView_12;

    private Button current_button;

    private EditText editText_shuru;

    private Button button_queren;
    private Button button_wancheng;

    private int button_position=1;

    private int [] numbers=new int[12];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duiyuahao_input);

        textView_1=(TextView)findViewById(R.id.text_xiahua_1);
        textView_2=(TextView)findViewById(R.id.text_xiahua_2);
        textView_3=(TextView)findViewById(R.id.text_xiahua_3);
        textView_4=(TextView)findViewById(R.id.text_xiahua_4);
        textView_5=(TextView)findViewById(R.id.text_xiahua_5);
        textView_6=(TextView)findViewById(R.id.text_xiahua_6);
        textView_7=(TextView)findViewById(R.id.text_xiahua_7);
        textView_8=(TextView)findViewById(R.id.text_xiahua_8);
        textView_9=(TextView)findViewById(R.id.text_xiahua_9);
        textView_10=(TextView)findViewById(R.id.text_xiahua_10);
        textView_11=(TextView)findViewById(R.id.text_xiahua_11);
        textView_12=(TextView)findViewById(R.id.text_xiahua_12);

        xiahua_free();
        textView_1.setVisibility(View.VISIBLE);


        editText_duihao_1=(Button)findViewById(R.id.edit_duihao_1);
        editText_duihao_2=(Button)findViewById(R.id.edit_duihao_2);
        editText_duihao_3=(Button)findViewById(R.id.edit_duihao_3);
        editText_duihao_4=(Button)findViewById(R.id.edit_duihao_4);
        editText_duihao_5=(Button)findViewById(R.id.edit_duihao_5);
        editText_duihao_6=(Button)findViewById(R.id.edit_duihao_6);
        editText_duihao_7=(Button)findViewById(R.id.edit_duihao_7);
        editText_duihao_8=(Button)findViewById(R.id.edit_duihao_8);
        editText_duihao_9=(Button)findViewById(R.id.edit_duihao_9);
        editText_duihao_10=(Button)findViewById(R.id.edit_duihao_10);
        editText_duihao_11=(Button)findViewById(R.id.edit_duihao_11);
        editText_duihao_12=(Button)findViewById(R.id.edit_duihao_12);

        editText_shuru=(EditText)findViewById(R.id.edit_duiyuanhao3_input);

        button_queren=(Button)findViewById(R.id.button_duiyuanhao3_queding);
        button_wancheng=(Button)findViewById(R.id.button_duiyuanhao3_wanchen);

        button_queren.setOnClickListener(this);
        button_wancheng.setOnClickListener(this);

        editText_duihao_1.setOnClickListener(this);
        editText_duihao_2.setOnClickListener(this);
        editText_duihao_3.setOnClickListener(this);
        editText_duihao_4.setOnClickListener(this);
        editText_duihao_5.setOnClickListener(this);
        editText_duihao_6.setOnClickListener(this);
        editText_duihao_7.setOnClickListener(this);
        editText_duihao_8.setOnClickListener(this);
        editText_duihao_9.setOnClickListener(this);
        editText_duihao_10.setOnClickListener(this);
        editText_duihao_11.setOnClickListener(this);
        editText_duihao_12.setOnClickListener(this);

        for(int i=0;i<12;i++){
            numbers[i]=-1;
        }

        current_button=(Button)findViewById(R.id.edit_duihao_1);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_duiyuanhao3_queding:
                if(editText_shuru.getText().toString().equals("")&&button_position<=12)
                {
                    Toast.makeText(Activity_duiyuahao_input.this,"不能输入空的队员号 !",Toast.LENGTH_SHORT).show();

                }else{
                    int num=Integer.valueOf(editText_shuru.getText().toString());
                    for(int i=0;i<12;i++){
                        if(numbers[i]==num){
                            Toast.makeText(Activity_duiyuahao_input.this,"队员号重复 !",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    xiahua_free();
                    switch (button_position){
                        case 1:
                            xiahua_free();
                            textView_2.setVisibility(View.VISIBLE);
                            numbers[0]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_1.setText(editText_shuru.getText().toString());
                            break;
                        case 2:
                            xiahua_free();
                            textView_3.setVisibility(View.VISIBLE);
                            numbers[1]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_2.setText(editText_shuru.getText().toString());
                            break;
                        case 3:
                            xiahua_free();
                            textView_4.setVisibility(View.VISIBLE);
                            numbers[2]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_3.setText(editText_shuru.getText().toString());
                            break;
                        case 4:
                            xiahua_free();
                            textView_5.setVisibility(View.VISIBLE);
                            numbers[3]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_4.setText(editText_shuru.getText().toString());
                            break;
                        case 5:
                            xiahua_free();
                            textView_6.setVisibility(View.VISIBLE);
                            numbers[4]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_5.setText(editText_shuru.getText().toString());
                            break;
                        case 6:
                            xiahua_free();
                            textView_7.setVisibility(View.VISIBLE);
                            numbers[5]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_6.setText(editText_shuru.getText().toString());
                            break;
                        case 7:
                            xiahua_free();
                            textView_8.setVisibility(View.VISIBLE);
                            numbers[6]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_7.setText(editText_shuru.getText().toString());
                            break;
                        case 8:
                            xiahua_free();
                            textView_9.setVisibility(View.VISIBLE);
                            numbers[7]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_8.setText(editText_shuru.getText().toString());
                            break;
                        case 9:
                            xiahua_free();
                            textView_10.setVisibility(View.VISIBLE);
                            numbers[8]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_9.setText(editText_shuru.getText().toString());
                            break;
                        case 10:
                            xiahua_free();
                            textView_11.setVisibility(View.VISIBLE);
                            numbers[9]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_10.setText(editText_shuru.getText().toString());
                            break;
                        case 11:
                            xiahua_free();
                            textView_12.setVisibility(View.VISIBLE);
                            numbers[10]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_11.setText(editText_shuru.getText().toString());
                            break;
                        case 12:
                            xiahua_free();
                            textView_12.setVisibility(View.INVISIBLE);
                            numbers[11]=Integer.valueOf(editText_shuru.getText().toString());
                            editText_duihao_12.setText(editText_shuru.getText().toString());
                            break;
                            default:
                                break;
                    }
                }
                button_position++;
                editText_shuru.getText().clear();
                break;
            case R.id.button_duiyuanhao3_wanchen:
                final AlertDialog.Builder builder=Alertdialog_h.alertDialog(Activity_duiyuahao_input.this,
                        "温馨提示：","请确认输入的队员信息是否正确\n开始记录后将不能修改",true);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(Activity_duiyuahao_input.this,Activity_JiLu_3.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("data",numbers);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("重新检查", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        builder.create().dismiss();
                    }
                });
                builder.show();
                break;
            case R.id.edit_duihao_1:
                button_position=1;
                xiahua_free();
                textView_1.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_1);
                break;
            case R.id.edit_duihao_2:
                button_position=2;
                xiahua_free();
                textView_2.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_2);
                break;
            case R.id.edit_duihao_3:
                button_position=3;
                xiahua_free();
                textView_3.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_3);
                break;
            case R.id.edit_duihao_4:
                button_position=4;
                xiahua_free();
                textView_4.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_4);
                break;
            case R.id.edit_duihao_5:
                button_position=5;
                xiahua_free();
                textView_5.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_5);
                break;
            case R.id.edit_duihao_6:
                button_position=6;
                xiahua_free();
                textView_6.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_6);
                break;
            case R.id.edit_duihao_7:
                button_position=7;
                xiahua_free();
                textView_7.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_7);
                break;
            case R.id.edit_duihao_8:
                button_position=8;
                xiahua_free();
                textView_8.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_8);
                break;
            case R.id.edit_duihao_9:
                button_position=9;
                xiahua_free();
                textView_8.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_9);
                break;
            case R.id.edit_duihao_10:
                button_position=10;
                xiahua_free();
                textView_10.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_10);
                break;
            case R.id.edit_duihao_11:
                button_position=11;
                xiahua_free();
                textView_11.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_11);
                break;
            case R.id.edit_duihao_12:
                button_position=12;
                xiahua_free();
                textView_12.setVisibility(View.VISIBLE);
                change_choose(R.id.edit_duihao_12);
                break;
                default:
                    break;
        }
    }

    private void change_choose(int  button_id){
        editText_shuru.getText().clear();
        current_button=(Button)findViewById(button_id);

        // 新建一个可以添加属性的文本对象
        SpannableString ss = new SpannableString(current_button.getText().toString());
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(20,true);
        // 附加属性到文本
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        editText_shuru.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失

    }


    private void xiahua_free(){
        textView_1.setVisibility(View.INVISIBLE);
        textView_2.setVisibility(View.INVISIBLE);
        textView_3.setVisibility(View.INVISIBLE);
        textView_4.setVisibility(View.INVISIBLE);
        textView_5.setVisibility(View.INVISIBLE);
        textView_6.setVisibility(View.INVISIBLE);
        textView_7.setVisibility(View.INVISIBLE);
        textView_8.setVisibility(View.INVISIBLE);
        textView_9.setVisibility(View.INVISIBLE);
        textView_10.setVisibility(View.INVISIBLE);
        textView_11.setVisibility(View.INVISIBLE);
        textView_12.setVisibility(View.INVISIBLE);
    }


}
