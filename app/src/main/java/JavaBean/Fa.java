package JavaBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 贺贺贺 on 2018/1/25.
 */

public class Fa extends BmobObject {
    private Integer score_defen_fa;
    private  Integer score_yiban_fa;
    private  Integer score_shiwu_fa;
    private   Integer score_zongshu_fa;
    public Fa(){
        this.score_defen_fa=0;
        this.score_yiban_fa=0;
        this.score_shiwu_fa=0;
        this.score_zongshu_fa=0;
    }

    public Integer getScore_defen_fa() {
        return score_defen_fa;
    }

    public void setScore_defen_fa(Integer score_defen_fa) {
        this.score_defen_fa = score_defen_fa;
    }

    public Integer getScore_yiban_fa() {
        return score_yiban_fa;
    }

    public void setScore_yiban_fa(Integer score_yiban_fa) {
        this.score_yiban_fa = score_yiban_fa;
    }

    public Integer getScore_shiwu_fa() {
        return score_shiwu_fa;
    }

    public void setScore_shiwu_fa(Integer score_shiwu_fa) {
        this.score_shiwu_fa = score_shiwu_fa;
    }

    public Integer getScore_zongshu_fa() {
        return score_zongshu_fa;
    }

    public void setScore_zongshu_fa(Integer score_zongshu_fa) {
        this.score_zongshu_fa = score_zongshu_fa;
    }
}
