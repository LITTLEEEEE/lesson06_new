package cn.edu.bussiness.stuinfo.service;


import cn.edu.bussiness.stuinfo.model.TopTenModel;

public interface StuInfoService {

    /**
     * 查询 top10
     * @return
     */
    TopTenModel query();
}
