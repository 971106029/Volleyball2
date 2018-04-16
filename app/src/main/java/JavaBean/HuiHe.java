package JavaBean;

import java.io.Serializable;
import java.util.ArrayList;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class HuiHe extends BmobObject implements Serializable{
    private BiSai bisai;
    private BmobRelation team;
    private String name_win;
    private Integer huihe_number;
    private Integer score_a;
    private Integer score_b;
    private ArrayList<Member> members00;
    private ArrayList<Member> members_current00;
    private boolean isXiugai;




    public HuiHe(){
        this.name_win="暂无参数";
        this.huihe_number=0;
        this.score_a=0;
        this.score_b=0;
        this.isXiugai=false;
    }

    public ArrayList<Member> getMembers_current00() {
        return members_current00;
    }

    public void setMembers_current00(ArrayList<Member> members_current00) {
        this.members_current00 = members_current00;
    }

    public boolean getisXiugai() {
        return isXiugai;
    }

    public void setisXiugai(boolean isXiugai1) {
        isXiugai = isXiugai1;
    }

    public ArrayList<Member> getMembers00() {
        return members00;
    }

    public void setMembers00(ArrayList<Member> members00) {
        this.members00 = members00;
    }

    public BiSai getBisai() {
        return bisai;
    }

    public void setBisai(BiSai bisai) {
        this.bisai = bisai;
    }

    public BmobRelation getTeam() {
        return team;
    }

    public void setTeam(BmobRelation team) {
        this.team = team;
    }

    public String getName_win() {
        return name_win;
    }

    public void setName_win(String name_win) {
        this.name_win = name_win;
    }

    public Integer getHuihe_number() {
        return huihe_number;
    }

    public void setHuihe_number(Integer huihe_number) {
        this.huihe_number = huihe_number;
    }

    public Integer getScore_a() {
        return score_a;
    }

    public void setScore_a(Integer score_a) {
        this.score_a = score_a;
    }

    public Integer getScore_b() {
        return score_b;
    }

    public void setScore_b(Integer score_b) {
        this.score_b = score_b;
    }

}
