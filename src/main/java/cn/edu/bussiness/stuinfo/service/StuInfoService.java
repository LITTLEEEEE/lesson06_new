package cn.edu.bussiness.stuinfo.service;


import cn.edu.bussiness.stuinfo.model.CompleteRateModel;
import cn.edu.bussiness.stuinfo.model.TopTenModel;

public interface StuInfoService {

    /**
     * 查询 top10
     * @return
     */
    TopTenModel query();

    /**
     * 查询课程完成率
     * @return
     */
    CompleteRateModel getCompleteRate();
}
