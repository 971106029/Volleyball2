package JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Fang extends BmobObject {
    private Integer score_haoqiu_fang;
    private Integer score_yiban_fang;
    private  Integer score_shiwu_fang;
    private  Integer score_zongshu_fang;
    public Fang(){
        this.score_haoqiu_fang=0;
        this.score_yiban_fang=0;
        this.score_shiwu_fang=0;
        this.score_zongshu_fang=0;
    }

    public Integer getScore_haoqiu_fang() {
        return score_haoqiu_fang;
    }

    public void setScore_haoqiu_fang(Integer score_haoqiu_fang) {
        this.score_haoqiu_fang = score_haoqiu_fang;
    }

    public Integer getScore_yiban_fang() {
        return score_yiban_fang;
    }

    public void setScore_yiban_fang(Integer score_yiban_fang) {
        this.score_yiban_fang = score_yiban_fang;
    }

    public Integer getScore_shiwu_fang() {
        return score_shiwu_fang;
    }

    public void setScore_shiwu_fang(Integer score_shiwu_fang) {
        this.score_shiwu_fang = score_shiwu_fang;
    }

    public Integer getScore_zongshu_fang() {
        return score_zongshu_fang;
    }

    public void setScore_zongshu_fang(Integer score_zongshu_fang) {
        this.score_zongshu_fang = score_zongshu_fang;
    }
}
