package JavaBean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Team extends BmobObject {
    private BmobRelation members;
    private String team_name;
    private Integer people_number;
    private Integer win_all;
    private Integer lose_all;
    private Integer bisai_all;
    private BmobFile touxiang_team;

    public Team(){
        this.team_name="小猪队";
        this.people_number=0;
        this.win_all=0;
        this.lose_all=0;
        this.bisai_all=0;
    }

    public BmobRelation getMembers() {
        return members;
    }

    public void setMembers(BmobRelation members) {
        this.members = members;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getPeople_number() {
        return people_number;
    }

    public void setPeople_number(Integer people_number) {
        this.people_number = people_number;
    }

    public Integer getWin_all() {
        return win_all;
    }

    public void setWin_all(Integer win_all) {
        this.win_all = win_all;
    }

    public Integer getLose_all() {
        return lose_all;
    }

    public void setLose_all(Integer lose_all) {
        this.lose_all = lose_all;
    }

    public Integer getBisai_all() {
        return bisai_all;
    }

    public void setBisai_all(Integer bisai_all) {
        this.bisai_all = bisai_all;
    }

    public BmobFile getTouxiang_team() {
        return touxiang_team;
    }

    public void setTouxiang_team(BmobFile touxiang_team) {
        this.touxiang_team = touxiang_team;
    }
}
