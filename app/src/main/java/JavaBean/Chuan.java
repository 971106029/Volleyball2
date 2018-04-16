package JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Chuan extends BmobObject {
    private Integer score_daowei_chuan;
    private  Integer score_yiban_chuan;
    private  Integer score_shiwu_chuan;
    private  Integer score_zongshu_chuan;
    public Chuan(){
        this.score_daowei_chuan=0;
        this.score_yiban_chuan=0;
        this.score_shiwu_chuan=0;
        this.score_zongshu_chuan=0;
    }

    public Integer getScore_daowei_chuan() {
        return score_daowei_chuan;
    }

    public void setScore_daowei_chuan(Integer score_daowei_chuan) {
        this.score_daowei_chuan = score_daowei_chuan;
    }

    public Integer getScore_yiban_chuan() {
        return score_yiban_chuan;
    }

    public void setScore_yiban_chuan(Integer score_yiban_chuan) {
        this.score_yiban_chuan = score_yiban_chuan;
    }

    public Integer getScore_shiwu_chuan() {
        return score_shiwu_chuan;
    }

    public void setScore_shiwu_chuan(Integer score_shiwu_chuan) {
        this.score_shiwu_chuan = score_shiwu_chuan;
    }

    public Integer getScore_zongshu_chuan() {
        return score_zongshu_chuan;
    }

    public void setScore_zongshu_chuan(Integer score_zongshu_chuan) {
        this.score_zongshu_chuan = score_zongshu_chuan;
    }
}
