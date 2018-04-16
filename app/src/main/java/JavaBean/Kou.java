package JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Kou extends BmobObject {
    private Integer score_kousi_kou;
    private Integer score_yiban_kou;
    private  Integer score_shiwu_kou;
    private  Integer score_zongshu_kou;
    public Kou(){
        this.score_kousi_kou=0;
        this.score_yiban_kou=0;
        this.score_shiwu_kou=0;
        this.score_zongshu_kou=0;
    }

    public Integer getScore_kousi_kou() {
        return score_kousi_kou;
    }

    public void setScore_kousi_kou(Integer score_kousi_kou) {
        this.score_kousi_kou = score_kousi_kou;
    }

    public Integer getScore_yiban_kou() {
        return score_yiban_kou;
    }

    public void setScore_yiban_kou(Integer score_yiban_kou) {
        this.score_yiban_kou = score_yiban_kou;
    }

    public Integer getScore_shiwu_kou() {
        return score_shiwu_kou;
    }

    public void setScore_shiwu_kou(Integer score_shiwu_kou) {
        this.score_shiwu_kou = score_shiwu_kou;
    }

    public Integer getScore_zongshu_kou() {
        return score_zongshu_kou;
    }

    public void setScore_zongshu_kou(Integer score_zongshu_kou) {
        this.score_zongshu_kou = score_zongshu_kou;
    }
}
