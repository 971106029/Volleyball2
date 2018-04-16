package JavaBean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Member extends BmobUser implements Serializable{
    private Integer Number;
    private Integer age;
    private Fa score_fa;
    private Kou score_kou;
    private Chuan score_chuan;
    private Fang score_fang;
    private Lan score_lan;
    private BmobFile touxiang_member;
    private Boolean isJiaolian;
    private Integer num_bisai_win;
    private Integer num_bisai_all;
    private String school;

    public Member (){
        this.Number=0;
        this.age=0;
        this.isJiaolian=false;
    }
    public Member (Integer number,Integer age,boolean isJiaolian){
        this.Number=number;
        this.age=age;
        this.isJiaolian=isJiaolian;
        this.setScore_fa(new Fa());
        this.setScore_chuan(new Chuan());
        this.setScore_lan(new Lan());
        this.setScore_kou(new Kou());
        this.setScore_fang(new Fang());
        num_bisai_win=0;
        num_bisai_all=0;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getNum_bisai_win() {
        return num_bisai_win;
    }

    public void setNum_bisai_win(Integer num_bisai_win) {
        this.num_bisai_win = num_bisai_win;
    }

    public Integer getNum_bisai_all() {
        return num_bisai_all;
    }

    public void setNum_bisai_all(Integer num_bisai_all) {
        this.num_bisai_all = num_bisai_all;
    }

    public Boolean getJiaolian() {
        return isJiaolian;
    }

    public void setJiaolian(Boolean jiaolian) {
        isJiaolian = jiaolian;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Fa getScore_fa() {
        return score_fa;
    }

    public void setScore_fa(Fa score_fa) {
        this.score_fa = score_fa;
    }

    public Kou getScore_kou() {
        return score_kou;
    }

    public void setScore_kou(Kou score_kou) {
        this.score_kou = score_kou;
    }

    public Chuan getScore_chuan() {
        return score_chuan;
    }

    public void setScore_chuan(Chuan score_chuan) {
        this.score_chuan = score_chuan;
    }

    public Fang getScore_fang() {
        return score_fang;
    }

    public void setScore_fang(Fang score_fang) {
        this.score_fang = score_fang;
    }

    public Lan getScore_lan() {
        return score_lan;
    }

    public void setScore_lan(Lan score_lan) {
        this.score_lan = score_lan;
    }

    public BmobFile getTouxiang_member() {
        return touxiang_member;
    }

    public void setTouxiang_member(BmobFile touxiang_member) {
        this.touxiang_member = touxiang_member;
    }
}
