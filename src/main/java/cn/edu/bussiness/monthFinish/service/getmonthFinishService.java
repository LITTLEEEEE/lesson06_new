package cn.edu.bussiness.monthFinish.service;

import cn.edu.bussiness.monthFinish.dao.monthFinishRepository;
import cn.edu.bussiness.monthFinish.entity.monthFinish;
import cn.edu.bussiness.monthFinish.model.monthFinishModel;

import java.util.List;

public interface getmonthFinishService {
    /**
     * 获取月份的已完结预计完结
     */
    monthFinishModel getmonthFinish();
}
