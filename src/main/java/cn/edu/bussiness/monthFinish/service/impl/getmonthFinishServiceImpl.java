package cn.edu.bussiness.monthFinish.service.impl;

import cn.edu.bussiness.monthFinish.dao.monthFinishRepository;
import cn.edu.bussiness.monthFinish.entity.monthFinish;
import cn.edu.bussiness.monthFinish.model.monthFinishModel;
import cn.edu.bussiness.monthFinish.service.getmonthFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
public class getmonthFinishServiceImpl implements getmonthFinishService {
    @Autowired
    private monthFinishRepository monthFinishRepository;
    @Override
    public monthFinishModel getmonthFinish() {
        List<monthFinish> monthFinishList= monthFinishRepository.getmonthFinish();
        List<monthFinishModel.row>rowList = new ArrayList<>();
        for(monthFinish mof :
            monthFinishList ){
            Date date = mof.getMonth();
            int month = date.getMonth();
            String mon = month+"月";
            monthFinishModel.row row = new monthFinishModel().new row(mon,mof.getCount_ending(),mof.getCount_ending_future());
            rowList.add(row);
        }
        monthFinishModel monthFinishModel = new monthFinishModel();
        monthFinishModel.initColumn(rowList);
        monthFinishModel.setChartSetting("暂无设置");
        return monthFinishModel;
    }
}
