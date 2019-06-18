package cn.edu.bussiness.completeRate.service;

import cn.edu.bussiness.completeRate.model.comRateModel;

public interface comRateService {

    /**
     * 获取当前的完成率
     */
    comRateModel getComRate();
    /**
     * 获取昨天完成率
     */
    comRateModel getComRate_yesterday();
}
