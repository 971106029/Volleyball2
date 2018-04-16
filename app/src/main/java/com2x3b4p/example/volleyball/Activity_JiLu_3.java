package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import JavaBean.BiSai;
import JavaBean.HuiHe;
import JavaBean.Member;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class Activity_JiLu_3 extends AppCompatActivity implements View.OnClickListener {
    private Button button_choose_1;
    private Button button_choose_2;
    private Button button_choose_3;
    private Button button_choose_4;
    private Button button_choose_5;
    private Button button_choose_6;
    private Button button_data_all;
    private Button button_faqiu;
    private Button button_yichuan;
    private Button button_kouqiu;
    private Button button_lanwang;
    private Button button_fangshou;
    private Button button_shangyiju;
    private Button button_xiayiju;
    private Button button_tijiao;
    private Button button_defen_jia;
    private Button button_defen_jian;
    private Button button_yiban_jia;
    private Button button_yiban_jian;
    private Button button_shiwu_jia;
    private Button button_shiwu_jian;
    private Button button_zongshu_jia;
    private Button button_zongshu_jian;
    private Button button_chehui;
    private TextView textView_changxu;
    private Integer changxv_now;

    private TextView duiyuanhao_1;
    private TextView duiyuanhao_2;
    private TextView duiyuanhao_3;
    private TextView duiyuanhao_4;
    private TextView duiyuanhao_5;
    private TextView duiyuanhao_6;

    private TextView jilu_defen;
    private TextView jilu_yiban;
    private TextView jilu_shiwu;
    private TextView jilu_zongshu;

    private EditText editText_xiaojubifen_2;
    private EditText editText_xiaojubifen_1;

    private boolean fa_isForcuse = false;
    private boolean chuan_isForcuse = false;
    private boolean kou_isForcuse = false;
    private boolean lan_isForcuse = false;
    private boolean fang_isForcuse = false;

    private int[] numbers;

    private Member current_member;
    private List<HuiHe> huiHes = new ArrayList<HuiHe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ji_lu_3);

        Intent intent = getIntent();
        numbers = intent.getIntArrayExtra("data");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.cardview_dark_background));
        }

        for (int i = 0; i < 5; i++) {         //新建回合
            HuiHe huiHe = new HuiHe();
            huiHe.setMembers_current00(new ArrayList<Member>());
            huiHe.setMembers00(new ArrayList<Member>());
            huiHe.setHuihe_number(i + 1);
            huiHes.add(huiHe);
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 12; j++) {
                Member mem = new Member(numbers[j], 20, false);
                huiHes.get(i).getMembers00().add(mem);
                if (j < 6) {
                    huiHes.get(i).getMembers_current00().add(mem);
                }
            }
        }
        ////////////////////////////////////////////////


        duiyuanhao_1 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_1);
        duiyuanhao_2 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_2);
        duiyuanhao_3 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_3);
        duiyuanhao_4 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_4);
        duiyuanhao_5 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_5);
        duiyuanhao_6 = (TextView) findViewById(R.id.text_duiyuanhao_jilu_6);


        jilu_defen = (TextView) findViewById(R.id.jilu3_defen);
        jilu_yiban = (TextView) findViewById(R.id.jilu3_yiban);
        jilu_shiwu = (TextView) findViewById(R.id.jilu3_shiwu);
        jilu_zongshu = (TextView) findViewById(R.id.jilu3_zongshu);


        editText_xiaojubifen_1 = (EditText) findViewById(R.id.textView_xiaojubifen_1);
        editText_xiaojubifen_2 = (EditText) findViewById(R.id.textView_xiaojubifen_2);
        editText_xiaojubifen_1.setText("0");
        editText_xiaojubifen_2.setText("0");

        button_choose_1 = (Button) findViewById(R.id.button_choose_1);
        button_choose_2 = (Button) findViewById(R.id.button_choose_2);
        button_choose_3 = (Button) findViewById(R.id.button_choose_3);
        button_choose_4 = (Button) findViewById(R.id.button_choose_4);
        button_choose_5 = (Button) findViewById(R.id.button_choose_5);
        button_choose_6 = (Button) findViewById(R.id.button_choose_6);
        button_data_all = (Button) findViewById(R.id.button_data_all);
        button_faqiu = (Button) findViewById(R.id.button_faqiu);
        button_yichuan = (Button) findViewById(R.id.button_yichuan);
        button_kouqiu = (Button) findViewById(R.id.button_kouqiu);
        button_lanwang = (Button) findViewById(R.id.button_lanwang);
        button_fangshou = (Button) findViewById(R.id.button_fangshou);
        button_shangyiju = (Button) findViewById(R.id.button_shangyiju);
        button_xiayiju = (Button) findViewById(R.id.button_xiayiju);
        button_tijiao = (Button) findViewById(R.id.button_tijiao);
        button_defen_jia = (Button) findViewById(R.id.button_defen_jia);
        button_defen_jian = (Button) findViewById(R.id.button_defen_jian);
        button_yiban_jia = (Button) findViewById(R.id.button_yiban_jia);
        button_yiban_jian = (Button) findViewById(R.id.button_yiban_jian);
        button_shiwu_jia = (Button) findViewById(R.id.button_shiwu_jia);
        button_shiwu_jian = (Button) findViewById(R.id.button_shiwu_jian);
        button_zongshu_jia = (Button) findViewById(R.id.button_zongshu_jia);
        button_zongshu_jian = (Button) findViewById(R.id.button_zongshu_jian);
        button_chehui = (Button) findViewById(R.id.button_chehui);
        textView_changxu = (TextView) findViewById(R.id.text_view_changxu);
        button_choose_1.setOnClickListener(this);
        button_choose_2.setOnClickListener(this);
        button_choose_3.setOnClickListener(this);
        button_choose_4.setOnClickListener(this);
        button_choose_5.setOnClickListener(this);
        button_choose_6.setOnClickListener(this);
        button_data_all.setOnClickListener(this);
        button_faqiu.setOnClickListener(this);
        button_yichuan.setOnClickListener(this);
        button_kouqiu.setOnClickListener(this);
        button_lanwang.setOnClickListener(this);
        button_fangshou.setOnClickListener(this);
        button_shangyiju.setOnClickListener(this);
        button_xiayiju.setOnClickListener(this);
        button_tijiao.setOnClickListener(this);
        button_defen_jia.setOnClickListener(this);
        button_defen_jian.setOnClickListener(this);
        button_yiban_jia.setOnClickListener(this);
        button_yiban_jian.setOnClickListener(this);
        button_shiwu_jia.setOnClickListener(this);
        button_shiwu_jian.setOnClickListener(this);
        button_zongshu_jia.setOnClickListener(this);
        button_zongshu_jian.setOnClickListener(this);
        button_chehui.setOnClickListener(this);
        bind_chushi_view(1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_choose_1:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(0);
                bindView_person_fa_data(current_member);
                button_choose_1.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_choose_2:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(1);
                bindView_person_fa_data(current_member);
                button_choose_2.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_choose_3:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(2);
                bindView_person_fa_data(current_member);
                button_choose_3.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_choose_4:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(3);
                bindView_person_fa_data(current_member);
                button_choose_4.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_choose_5:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(4);
                bindView_person_fa_data(current_member);
                button_choose_5.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_choose_6:
                jia_jian_back();
                change_state();
                forcuse_free();
                change_color_to_yuan();
                fa_isForcuse = true;
                current_member = huiHes.get(changxv_now - 1).getMembers_current00().get(5);
                bindView_person_fa_data(current_member);
                button_choose_6.setBackgroundResource(R.drawable.tubiao_wode_press);
                break;
            case R.id.button_data_all:
                data_all();
                break;
            case R.id.button_faqiu:
                jia_jian_back();
                change_state();
                forcuse_free();
                fa_isForcuse = true;
                jilu_defen.setText(current_member.getScore_fa().getScore_defen_fa().toString());
                jilu_yiban.setText(current_member.getScore_fa().getScore_yiban_fa().toString());
                jilu_shiwu.setText(current_member.getScore_fa().getScore_shiwu_fa().toString());
                jilu_zongshu.setText(current_member.getScore_fa().getScore_zongshu_fa().toString());
                button_faqiu.setEnabled(false);
                break;
            case R.id.button_yichuan:
                jia_jian_back();
                change_state();
                forcuse_free();
                chuan_isForcuse = true;
                jilu_defen.setText(current_member.getScore_chuan().getScore_daowei_chuan().toString());
                jilu_yiban.setText(current_member.getScore_chuan().getScore_yiban_chuan().toString());
                jilu_shiwu.setText(current_member.getScore_chuan().getScore_shiwu_chuan().toString());
                jilu_zongshu.setText(current_member.getScore_chuan().getScore_zongshu_chuan().toString());
                button_yichuan.setEnabled(false);
                break;
            case R.id.button_kouqiu:
                jia_jian_back();
                change_state();
                forcuse_free();
                kou_isForcuse = true;
                jilu_defen.setText(current_member.getScore_kou().getScore_kousi_kou().toString());
                jilu_yiban.setText(current_member.getScore_kou().getScore_yiban_kou().toString());
                jilu_shiwu.setText(current_member.getScore_kou().getScore_shiwu_kou().toString());
                jilu_zongshu.setText(current_member.getScore_kou().getScore_zongshu_kou().toString());
                button_kouqiu.setEnabled(false);
                break;
            case R.id.button_lanwang:
                jia_jian_back();
                change_state();
                forcuse_free();
                lan_isForcuse = true;
                jilu_defen.setText(current_member.getScore_lan().getScore_lansi_lan().toString());
                jilu_yiban.setText(current_member.getScore_lan().getScore_yiban_lan().toString());
                jilu_shiwu.setText(current_member.getScore_lan().getScore_shiwu_lan().toString());
                jilu_zongshu.setText(current_member.getScore_lan().getScore_zongshu_lan().toString());
                button_lanwang.setEnabled(false);
                break;
            case R.id.button_fangshou:
                jia_jian_back();
                change_state();
                forcuse_free();
                fang_isForcuse = true;
                jilu_defen.setText(current_member.getScore_fang().getScore_haoqiu_fang().toString());
                jilu_yiban.setText(current_member.getScore_fang().getScore_yiban_fang().toString());
                jilu_shiwu.setText(current_member.getScore_fang().getScore_shiwu_fang().toString());
                jilu_zongshu.setText(current_member.getScore_fang().getScore_zongshu_fang().toString());
                button_fangshou.setEnabled(false);
                break;
            case R.id.button_shangyiju:
                data_edit_sava();
                jia_jian_back();
                if (changxv_now == 1) {
                    Toast.makeText(Activity_JiLu_3.this, "已经到第一局啦 !", Toast.LENGTH_SHORT).show();
                } else {
                    check_is_tijiao1(changxv_now-1);
                    changxv_now -= 1;
                    textView_changxu.setText(changxv_now.toString());
                    bind_chushi_view(changxv_now);
                }
                break;
            case R.id.button_xiayiju:
                data_edit_sava();
                jia_jian_back();
                if (changxv_now == 5) {
                    Toast.makeText(Activity_JiLu_3.this, "已经到第五局啦 !", Toast.LENGTH_SHORT).show();
                } else {
                    check_is_tijiao1(changxv_now+1);
                    changxv_now += 1;
                    textView_changxu.setText(changxv_now.toString());
                    bind_chushi_view(changxv_now);
                }
                break;
            case R.id.button_tijiao:
                jia_jian_back();
                if (huiHes.get(changxv_now - 1).getisXiugai()) {
                    check_is_tijiao();
                    huiHes.get(changxv_now - 1).setisXiugai(false);
                } else {
                    check_is_tijiao();
                    //Toast.makeText(Activity_JiLu_3.this,""+huiHes.get(changxv_now - 1).getisXiugai(),Toast.LENGTH_SHORT).show();
                    huiHes.get(changxv_now - 1).setisXiugai(true);
                    Toast.makeText(Activity_JiLu_3.this,""+huiHes.get(changxv_now - 1).getisXiugai(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_defen_jia:
                button_defen_jia.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_defen_fa(current_member.getScore_fa().getScore_defen_fa() + 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_fa().getScore_defen_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_haoqiu_fang(current_member.getScore_fang().getScore_haoqiu_fang() + 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_fang().getScore_haoqiu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_daowei_chuan(current_member.getScore_chuan().getScore_daowei_chuan() + 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_chuan().getScore_daowei_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_kousi_kou(current_member.getScore_kou().getScore_kousi_kou() + 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_kou().getScore_kousi_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_lansi_lan(current_member.getScore_lan().getScore_lansi_lan() + 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_lan().getScore_lansi_lan())) + "");
                }
                break;
            case R.id.button_defen_jian:
                if (check_fu(R.id.jilu3_defen)) {
                    return;
                }
                button_defen_jian.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_defen_fa(current_member.getScore_fa().getScore_defen_fa() - 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_fa().getScore_defen_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_haoqiu_fang(current_member.getScore_fang().getScore_haoqiu_fang() - 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_fang().getScore_haoqiu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_daowei_chuan(current_member.getScore_chuan().getScore_daowei_chuan() - 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_chuan().getScore_daowei_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_kousi_kou(current_member.getScore_kou().getScore_kousi_kou() - 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_kou().getScore_kousi_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_lansi_lan(current_member.getScore_lan().getScore_lansi_lan() - 1);
                    jilu_defen.setText((Integer.valueOf(current_member.getScore_lan().getScore_lansi_lan())) + "");
                }
                break;
            case R.id.button_yiban_jia:
                button_yiban_jia.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_yiban_fa(current_member.getScore_fa().getScore_yiban_fa() + 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_fa().getScore_yiban_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_yiban_fang(current_member.getScore_fang().getScore_yiban_fang() + 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_fang().getScore_yiban_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_yiban_chuan(current_member.getScore_chuan().getScore_yiban_chuan() + 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_chuan().getScore_yiban_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_yiban_kou(current_member.getScore_kou().getScore_yiban_kou() + 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_kou().getScore_yiban_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_yiban_lan(current_member.getScore_lan().getScore_yiban_lan() + 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_lan().getScore_yiban_lan())) + "");
                }
                break;
            case R.id.button_yiban_jian:
                if (check_fu(R.id.jilu3_yiban)) {
                    return;
                }
                button_yiban_jian.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_yiban_fa(current_member.getScore_fa().getScore_yiban_fa() - 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_fa().getScore_yiban_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_yiban_fang(current_member.getScore_fang().getScore_yiban_fang() - 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_fang().getScore_yiban_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_yiban_chuan(current_member.getScore_chuan().getScore_yiban_chuan() - 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_chuan().getScore_yiban_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_yiban_kou(current_member.getScore_kou().getScore_yiban_kou() - 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_kou().getScore_yiban_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_yiban_lan(current_member.getScore_lan().getScore_yiban_lan() - 1);
                    jilu_yiban.setText((Integer.valueOf(current_member.getScore_lan().getScore_yiban_lan())) + "");
                }
                break;
            case R.id.button_shiwu_jia:
                button_shiwu_jia.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_shiwu_fa(current_member.getScore_fa().getScore_shiwu_fa() + 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_fa().getScore_shiwu_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_shiwu_fang(current_member.getScore_fang().getScore_shiwu_fang() + 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_fang().getScore_shiwu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_shiwu_chuan(current_member.getScore_chuan().getScore_shiwu_chuan() + 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_chuan().getScore_shiwu_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_shiwu_kou(current_member.getScore_kou().getScore_shiwu_kou() + 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_kou().getScore_shiwu_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_shiwu_lan(current_member.getScore_lan().getScore_shiwu_lan() + 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_lan().getScore_shiwu_lan())) + "");
                }
                break;
            case R.id.button_shiwu_jian:
                if (check_fu(R.id.jilu3_shiwu)) {
                    return;
                }
                button_shiwu_jian.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_shiwu_fa(current_member.getScore_fa().getScore_shiwu_fa() - 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_fa().getScore_shiwu_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_shiwu_fang(current_member.getScore_fang().getScore_shiwu_fang() - 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_fang().getScore_shiwu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_shiwu_chuan(current_member.getScore_chuan().getScore_shiwu_chuan() - 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_chuan().getScore_shiwu_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_shiwu_kou(current_member.getScore_kou().getScore_shiwu_kou() - 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_kou().getScore_shiwu_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_shiwu_lan(current_member.getScore_lan().getScore_shiwu_lan() - 1);
                    jilu_shiwu.setText((Integer.valueOf(current_member.getScore_lan().getScore_shiwu_lan())) + "");
                }
                break;
            case R.id.button_zongshu_jia:
                button_zongshu_jia.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_zongshu_fa(current_member.getScore_fa().getScore_zongshu_fa() + 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_fa().getScore_zongshu_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_zongshu_fang(current_member.getScore_fang().getScore_zongshu_fang() + 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_fang().getScore_zongshu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_zongshu_chuan(current_member.getScore_chuan().getScore_zongshu_chuan() + 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_chuan().getScore_zongshu_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_zongshu_kou(current_member.getScore_kou().getScore_zongshu_kou() + 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_kou().getScore_zongshu_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_zongshu_lan(current_member.getScore_lan().getScore_zongshu_lan() + 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_lan().getScore_zongshu_lan())) + "");
                }
                break;
            case R.id.button_zongshu_jian:
                if (check_fu(R.id.jilu3_zongshu)) {
                    return;
                }
                button_zongshu_jian.setEnabled(false);
                if (fa_isForcuse) {
                    current_member.getScore_fa().setScore_zongshu_fa(current_member.getScore_fa().getScore_zongshu_fa() - 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_fa().getScore_zongshu_fa())) + "");
                } else if (fang_isForcuse) {
                    current_member.getScore_fang().setScore_zongshu_fang(current_member.getScore_fang().getScore_zongshu_fang() - 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_fang().getScore_zongshu_fang())) + "");
                } else if (chuan_isForcuse) {
                    current_member.getScore_chuan().setScore_zongshu_chuan(current_member.getScore_chuan().getScore_zongshu_chuan() - 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_chuan().getScore_zongshu_chuan())) + "");
                } else if (kou_isForcuse) {
                    current_member.getScore_kou().setScore_zongshu_kou(current_member.getScore_kou().getScore_zongshu_kou() - 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_kou().getScore_zongshu_kou())) + "");
                } else if (lan_isForcuse) {
                    current_member.getScore_lan().setScore_zongshu_lan(current_member.getScore_lan().getScore_zongshu_lan() - 1);
                    jilu_zongshu.setText((Integer.valueOf(current_member.getScore_lan().getScore_zongshu_lan())) + "");
                }
                break;
            case R.id.button_chehui:
                break;
            default:
                break;
        }
    }

    private void change_color_to_yuan() {
        button_choose_1.setBackgroundResource(R.drawable.tubiao_wode);
        button_choose_2.setBackgroundResource(R.drawable.tubiao_wode);
        button_choose_3.setBackgroundResource(R.drawable.tubiao_wode);
        button_choose_4.setBackgroundResource(R.drawable.tubiao_wode);
        button_choose_5.setBackgroundResource(R.drawable.tubiao_wode);
        button_choose_6.setBackgroundResource(R.drawable.tubiao_wode);
    }

    private void change_state() {
        button_faqiu.setEnabled(true);
        button_yichuan.setEnabled(true);
        button_kouqiu.setEnabled(true);
        button_lanwang.setEnabled(true);
        button_fangshou.setEnabled(true);

    }

    private void bindView_person_fa_data(Member member) {
        button_faqiu.setEnabled(false);
        jilu_defen.setText(member.getScore_fa().getScore_defen_fa().toString());
        jilu_yiban.setText(member.getScore_fa().getScore_yiban_fa().toString());
        jilu_shiwu.setText(member.getScore_fa().getScore_shiwu_fa().toString());
        jilu_zongshu.setText(member.getScore_fa().getScore_zongshu_fa().toString());
    }


    private void forcuse_free() {
        fa_isForcuse = false;
        chuan_isForcuse = false;
        lan_isForcuse = false;
        fang_isForcuse = false;
        kou_isForcuse = false;
    }


    private void bind_chushi_view(int changxv) {

        editText_xiaojubifen_1.setText(huiHes.get(changxv - 1).getScore_a().toString());
        editText_xiaojubifen_2.setText(huiHes.get(changxv - 1).getScore_b().toString());
        change_state();
        change_color_to_yuan();
        button_choose_1.setBackgroundResource(R.drawable.tubiao_wode_press);
        textView_changxu.setText(changxv + "");
        changxv_now = Integer.parseInt(textView_changxu.getText().toString());
        current_member = huiHes.get(changxv - 1).getMembers_current00().get(0);
        bindView_person_fa_data(current_member);
        fa_isForcuse = true;
        duiyuanhao_1.setText(huiHes.get(changxv - 1).getMembers_current00().get(0).getNumber().toString());
        duiyuanhao_2.setText(huiHes.get(changxv - 1).getMembers_current00().get(1).getNumber().toString());
        duiyuanhao_3.setText(huiHes.get(changxv - 1).getMembers_current00().get(2).getNumber().toString());
        duiyuanhao_4.setText(huiHes.get(changxv - 1).getMembers_current00().get(3).getNumber().toString());
        duiyuanhao_5.setText(huiHes.get(changxv - 1).getMembers_current00().get(4).getNumber().toString());
        duiyuanhao_6.setText(huiHes.get(changxv - 1).getMembers_current00().get(5).getNumber().toString());
    }


    private void data_all() {
        data_edit_sava();
        jia_jian_back();
        Intent intent = new Intent(Activity_JiLu_3.this, Activity_data_all.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data0", (Serializable) huiHes);
        intent.putExtras(bundle);
        intent.putExtra("changxu", changxv_now);
        intent.putExtra("xiaojubufen_1", editText_xiaojubifen_1.getText().toString());
        intent.putExtra("xiaojubufen_2", editText_xiaojubifen_2.getText().toString());
        startActivity(intent);
    }

    private void data_edit_sava() {
        if (editText_xiaojubifen_1.getText().toString().equals("")) {
            huiHes.get(changxv_now - 1).setScore_a(0);
        } else {
            huiHes.get(changxv_now - 1).setScore_a(Integer.parseInt(editText_xiaojubifen_1.getText().toString()));
            if (editText_xiaojubifen_2.getText().toString().equals("")) {
                huiHes.get(changxv_now - 1).setScore_b(0);
            } else {
                huiHes.get(changxv_now - 1).setScore_b(Integer.parseInt(editText_xiaojubifen_2.getText().toString()));
            }
        }
    }

    private void jia_jian_back() {
        button_defen_jia.setEnabled(true);
        button_defen_jian.setEnabled(true);
        button_yiban_jia.setEnabled(true);
        button_yiban_jian.setEnabled(true);
        button_shiwu_jia.setEnabled(true);
        button_shiwu_jian.setEnabled(true);
        button_zongshu_jia.setEnabled(true);
        button_zongshu_jian.setEnabled(true);
    }


    private boolean check_fu(int text_view_id) {             //检测减分的负分情况
        TextView textView = (TextView) findViewById(text_view_id);
        int a = Integer.parseInt(textView.getText().toString());
        if (a == 0) {
            Toast.makeText(Activity_JiLu_3.this, "得分不可以为负2", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }

    private void check_is_tijiao() {
        if (huiHes.get(changxv_now - 1).getisXiugai()) {
            button_tijiao.setText("提交");
            button_chehui.setEnabled(true);
            button_defen_jia.setVisibility(View.VISIBLE);
            button_defen_jian.setVisibility(View.VISIBLE);
            button_shiwu_jia.setVisibility(View.VISIBLE);
            button_shiwu_jian.setVisibility(View.VISIBLE);
            button_yiban_jia.setVisibility(View.VISIBLE);
            button_yiban_jian.setVisibility(View.VISIBLE);
            button_zongshu_jia.setVisibility(View.VISIBLE);
            button_zongshu_jian.setVisibility(View.VISIBLE);
        } else {
            button_tijiao.setText("修改");
            button_chehui.setEnabled(true);
            button_defen_jia.setVisibility(View.GONE);
            button_defen_jian.setVisibility(View.GONE);
            button_shiwu_jia.setVisibility(View.GONE);
            button_shiwu_jian.setVisibility(View.GONE);
            button_yiban_jia.setVisibility(View.GONE);
            button_yiban_jian.setVisibility(View.GONE);
            button_zongshu_jia.setVisibility(View.GONE);
            button_zongshu_jian.setVisibility(View.GONE);
        }
    }

    private void check_is_tijiao1(int changxu) {
        if (huiHes.get(changxu - 1).getisXiugai()) {
            button_tijiao.setText("修改");
            button_chehui.setEnabled(true);
            button_defen_jia.setVisibility(View.GONE);
            button_defen_jian.setVisibility(View.GONE);
            button_shiwu_jia.setVisibility(View.GONE);
            button_shiwu_jian.setVisibility(View.GONE);
            button_yiban_jia.setVisibility(View.GONE);
            button_yiban_jian.setVisibility(View.GONE);
            button_zongshu_jia.setVisibility(View.GONE);
            button_zongshu_jian.setVisibility(View.GONE);
        } else {
            button_tijiao.setText("提交");
            button_chehui.setEnabled(true);
            button_defen_jia.setVisibility(View.VISIBLE);
            button_defen_jian.setVisibility(View.VISIBLE);
            button_shiwu_jia.setVisibility(View.VISIBLE);
            button_shiwu_jian.setVisibility(View.VISIBLE);
            button_yiban_jia.setVisibility(View.VISIBLE);
            button_yiban_jian.setVisibility(View.VISIBLE);
            button_zongshu_jia.setVisibility(View.VISIBLE);
            button_zongshu_jian.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onRestart() {
        editText_xiaojubifen_1.setText(huiHes.get(changxv_now - 1).getScore_a().toString());
        editText_xiaojubifen_2.setText(huiHes.get(changxv_now - 1).getScore_b().toString());
        super.onRestart();
    }


    @Override
    protected void onStop() {
        Toast.makeText(Activity_JiLu_3.this, huiHes.get(changxv_now - 1).getScore_a() + "    " + huiHes.get(changxv_now - 1).getScore_b() + "     " + changxv_now, Toast.LENGTH_SHORT).show();
        super.onStop();
    }
}
