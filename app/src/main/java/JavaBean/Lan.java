package JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Lan extends BmobObject {
    private Integer score_lansi_lan;
    private Integer score_yiban_lan;
    private  Integer score_shiwu_lan;
    private  Integer score_zongshu_lan;
    public Lan(){
        this.score_lansi_lan=0;
        this.score_yiban_lan=0;
        this.score_shiwu_lan=0;
        this.score_zongshu_lan=0;
    }

    public Integer getScore_lansi_lan() {
        return score_lansi_lan;
    }

    public void setScore_lansi_lan(Integer score_lansi_lan) {
        this.score_lansi_lan = score_lansi_lan;
    }

    public Integer getScore_yiban_lan() {
        return score_yiban_lan;
    }

    public void setScore_yiban_lan(Integer score_yiban_lan) {
        this.score_yiban_lan = score_yiban_lan;
    }

    public Integer getScore_shiwu_lan() {
        return score_shiwu_lan;
    }

    public void setScore_shiwu_lan(Integer score_shiwu_lan) {
        this.score_shiwu_lan = score_shiwu_lan;
    }

    public Integer getScore_zongshu_lan() {
        return score_zongshu_lan;
    }

    public void setScore_zongshu_lan(Integer score_zongshu_lan) {
        this.score_zongshu_lan = score_zongshu_lan;
    }
}
