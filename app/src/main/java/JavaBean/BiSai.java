package JavaBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.b.This;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class BiSai extends BmobObject{
    private String competition_time;
    private String competition_place;
    private String winner_name;
    private String team_name_A;
    private String team_name_B;
    private Integer score_A;
    private Integer score_B;

    public BiSai(){
        this.competition_time="暂无数据";
        this.competition_place="暂无数据";
        this.winner_name="暂无数据";
        this.team_name_A="暂无数据";
        this.team_name_B="暂无数据";
        this.score_A=0;
        this.score_B=0;
    }

    public String getCompetition_time() {
        return competition_time;
    }

    public void setCompetition_time(String competition_time) {
        this.competition_time = competition_time;
    }

    public String getCompetition_place() {
        return competition_place;
    }

    public void setCompetition_place(String competition_place) {
        this.competition_place = competition_place;
    }

    public String getWinner_name() {
        return winner_name;
    }

    public void setWinner_name(String winner_name) {
        this.winner_name = winner_name;
    }

    public String getTeam_name_A() {
        return team_name_A;
    }

    public void setTeam_name_A(String team_name_A) {
        this.team_name_A = team_name_A;
    }

    public String getTeam_name_B() {
        return team_name_B;
    }

    public void setTeam_name_B(String team_name_B) {
        this.team_name_B = team_name_B;
    }

    public Integer getScore_A() {
        return score_A;
    }

    public void setScore_A(Integer score_A) {
        this.score_A = score_A;
    }

    public Integer getScore_B() {
        return score_B;
    }

    public void setScore_B(Integer score_B) {
        this.score_B = score_B;
    }

}
