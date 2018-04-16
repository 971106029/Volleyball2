package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import JavaBean.HuiHe;
import JavaBean.Member;

public class Activity_data_all extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView person_data_recycler;
    private PersonDataAdapter person_adapter;
    private TextView textView_huiheshu;
    private Button button_shangyiju;
    private Button button_xiayiju;

    private String xiaojubifen_1;
    private String xiaojubifen_2;

    private TextView Text_xiaojubifen_1;
    private TextView Text_xiaojubifen_2;


    //////////模拟初始化.\///////////////
    private List<HuiHe> huiHes=new ArrayList<HuiHe>();
    private int changxu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_all);

        Intent intent=getIntent();
        huiHes=(List<HuiHe>) intent.getSerializableExtra("data0");
        changxu=intent.getIntExtra("changxu",1);
        xiaojubifen_1=intent.getStringExtra("xiaojubufen_1");
        xiaojubifen_2=intent.getStringExtra("xiaojubufen_2");

        Text_xiaojubifen_1=(TextView)findViewById(R.id.textView_dataall_xiaojubifen_1);
        Text_xiaojubifen_2=(TextView)findViewById(R.id.textView_dataall_xiaojubifen_2);
        textView_huiheshu=(TextView)findViewById(R.id.data_all_huiheshu);
        button_shangyiju=(Button)findViewById(R.id.data_all_shangyiju);
        button_xiayiju=(Button)findViewById(R.id.data_all_xiayiju);
        button_shangyiju.setOnClickListener(this);
        button_xiayiju.setOnClickListener(this);



        textView_huiheshu.setText(changxu_text_set());
        person_adapter=new PersonDataAdapter(huiHes.get(changxu-1).getMembers00());
        person_data_recycler=(RecyclerView)findViewById(R.id.person_data_recyclerView);
        person_data_recycler.setLayoutManager(new LinearLayoutManager(Activity_data_all.this));
        person_data_recycler.setAdapter(person_adapter);

        String a=huiHes.get(changxu-1).getScore_a().toString();
        String b=huiHes.get(changxu-1).getScore_b().toString();
        Text_xiaojubifen_1.setText(huiHes.get(changxu-1).getScore_a().toString());
        Text_xiaojubifen_2.setText(huiHes.get(changxu-1).getScore_b().toString());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.data_all_shangyiju:
                if(changxu==1){
                    Toast.makeText(Activity_data_all.this,"已经到第一局啦 !",Toast.LENGTH_SHORT).show();
                }else{
                    changxu-=1;
                    Text_xiaojubifen_1.setText(huiHes.get(changxu-1).getScore_a().toString());
                    Text_xiaojubifen_2.setText(huiHes.get(changxu-1).getScore_b().toString());
                    textView_huiheshu.setText(changxu_text_set());
                    person_adapter.setMembers1(huiHes.get(changxu-1).getMembers00());
                    person_adapter.notifyDataSetChanged();
                }
                break;
            case R.id.data_all_xiayiju:
                if(changxu==5){
                    Toast.makeText(Activity_data_all.this,"已经到第五局啦 !",Toast.LENGTH_SHORT).show();
                }else{
                    changxu+=1;
                    Text_xiaojubifen_1.setText(huiHes.get(changxu-1).getScore_a().toString());
                    Text_xiaojubifen_2.setText(huiHes.get(changxu-1).getScore_b().toString());
                    textView_huiheshu.setText(changxu_text_set());
                    person_adapter.setMembers1(huiHes.get(changxu-1).getMembers00());
                    person_adapter.notifyDataSetChanged();
                }
                break;
                default:
                    break;
        }
    }

    public class PersonDataHolder extends RecyclerView.ViewHolder{
        private TextView textView_num;

        private TextView textView_fa_daowei;
        private TextView textView_fa_yiban;
        private TextView textView_fa_shiwu;

        private TextView textView_kou_daowei;
        private TextView textView_kou_yiban;
        private TextView textView_kou_shiwu;

        private TextView textView_chuan_daowei;
        private TextView textView_chuan_yiban;
        private TextView textView_chuan_shiwu;

        private TextView textView_lan_daowei;
        private TextView textView_lan_yiban;
        private TextView textView_lan_shiwu;

        private TextView textView_fang_daowei;
        private TextView textView_fang_yiban;
        private TextView textView_fang_shiwu;
        public PersonDataHolder(View view){
            super(view);
            textView_num=(TextView)view.findViewById(R.id.textdata_num);

            textView_fa_daowei=(TextView)view.findViewById(R.id.textdata_fa_daowei) ;
            textView_fa_yiban=(TextView)view.findViewById(R.id.textdata_fa_yiban) ;
            textView_fa_shiwu=(TextView)view.findViewById(R.id.textdata_fa_shiwu) ;

            textView_kou_daowei=(TextView)view.findViewById(R.id.textdata_kou_daowei) ;
            textView_kou_yiban=(TextView)view.findViewById(R.id.textdata_kou_yiban) ;
            textView_kou_shiwu=(TextView)view.findViewById(R.id.textdata_kou_shiwu) ;

            textView_chuan_daowei=(TextView)view.findViewById(R.id.textdata_chuan_daowei) ;
            textView_chuan_yiban=(TextView)view.findViewById(R.id.textdata_chuan_yiban) ;
            textView_chuan_shiwu=(TextView)view.findViewById(R.id.textdata_chuan_shiwu) ;

            textView_lan_daowei=(TextView)view.findViewById(R.id.textdata_lan_daowei) ;
            textView_lan_yiban=(TextView)view.findViewById(R.id.textdata_lan_yiban) ;
            textView_lan_shiwu=(TextView)view.findViewById(R.id.textdata_lan_shiwu) ;

            textView_fang_daowei=(TextView)view.findViewById(R.id.textdata_fang_daowei) ;
            textView_fang_yiban=(TextView)view.findViewById(R.id.textdata_fang_yiban) ;
            textView_fang_shiwu=(TextView)view.findViewById(R.id.textdata_fang_shiwu) ;
        }


        public void bindView(Member member){
            textView_num.setText(member.getNumber().toString());

            textView_fa_daowei.setText(member.getScore_fa().getScore_defen_fa().toString());
            textView_fa_yiban.setText(member.getScore_fa().getScore_yiban_fa().toString());
            textView_fa_shiwu.setText(member.getScore_fa().getScore_shiwu_fa().toString());

            textView_kou_daowei.setText(member.getScore_kou().getScore_kousi_kou().toString());
            textView_kou_yiban.setText(member.getScore_kou().getScore_yiban_kou().toString());
            textView_kou_shiwu.setText(member.getScore_kou().getScore_shiwu_kou().toString());

            textView_chuan_daowei.setText(member.getScore_chuan().getScore_daowei_chuan().toString());
            textView_chuan_yiban.setText(member.getScore_chuan().getScore_yiban_chuan().toString());
            textView_chuan_shiwu.setText(member.getScore_chuan().getScore_shiwu_chuan().toString());

            textView_lan_daowei.setText(member.getScore_lan().getScore_lansi_lan().toString());
            textView_lan_yiban.setText(member.getScore_lan().getScore_yiban_lan().toString());
            textView_lan_shiwu.setText(member.getScore_lan().getScore_shiwu_lan().toString());

            textView_fang_daowei.setText(member.getScore_fang().getScore_haoqiu_fang().toString());
            textView_fang_yiban.setText(member.getScore_fang().getScore_yiban_fang().toString());
            textView_fang_shiwu.setText(member.getScore_fang().getScore_shiwu_fang().toString());

        }
    }

    public class PersonDataAdapter extends RecyclerView.Adapter<PersonDataHolder>{
        private List<Member> members1;

        public List<Member> getMembers1() {
            return members1;
        }

        public void setMembers1(List<Member> members1) {
            this.members1 = members1;
        }

        public PersonDataAdapter(List<Member> members){
            this.members1=members;
        }

        @Override
        public PersonDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(Activity_data_all.this).inflate(R.layout.data_item,parent,false);
            return new PersonDataHolder(view);
        }


        @Override
        public void onBindViewHolder(PersonDataHolder holder, int position) {
            Member member=members1.get(position);
            holder.bindView(member);
        }

        @Override
        public int getItemCount() {
            return members1.size();
        }
    }

    public String changxu_text_set(){
        return "第"+changxu+"局";
    }


}
