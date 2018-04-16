package com2x3b4p.example.volleyball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import java.util.List;

import JavaBean.Member;

public class Activity_JiLu_2 extends AppCompatActivity implements View.OnClickListener{
    private Button button_next;
    private RecyclerView recyclerView_cansaiduiyuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ji_lu_2);
        button_next=(Button)findViewById(R.id.button_kaishijilu);
        button_next.setOnClickListener(this);
        recyclerView_cansaiduiyuan=(RecyclerView)findViewById(R.id.cansaiduiyuan_recycler_view);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_kaishijilu:
                Intent intent=new Intent(Activity_JiLu_2.this,Activity_JiLu_3.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public class CansaiHolder extends RecyclerView.ViewHolder{
        public CansaiHolder(View view){
            super(view);
        }

        public void bindView(Member member){

        }
    }

    public class CansaiAdapter extends RecyclerView.Adapter<CansaiHolder>{
        private List<Member> members;
        public CansaiAdapter(List<Member> members11){
            this.members=members11;
        }

        @Override
        public CansaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(Activity_JiLu_2.this).inflate(R.layout.cansai_item,parent,false);
            return new CansaiHolder(view);
        }

        @Override
        public void onBindViewHolder(CansaiHolder holder, int position) {
            Member  member = members.get(position);
            holder.bindView(member);
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
