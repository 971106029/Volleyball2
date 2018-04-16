package com2x3b4p.example.volleyball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_find_team extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layout_find_yes;
    private TextView layout_find_no;
    private Button button_find;
    private Button button_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_team);
        layout_find_yes=(LinearLayout)findViewById(R.id.find_my_team_view_yes);
        layout_find_no=(TextView)findViewById(R.id.find_my_team_view_no);
        button_find=(Button)findViewById(R.id.find_my_team_button);
        button_join=(Button)findViewById(R.id.button_join_my_team);
        button_find.setOnClickListener(this);
        button_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.find_my_team_button:
                layout_find_yes.setVisibility(View.VISIBLE);
                break;
            case R.id.button_join_my_team:
                break;
            default:
                break;
        }
    }
}
