package cn.edu.bussiness.monthFinish.service.impl;

import cn.edu.bussiness.monthFinish.entity.monthFinish;
import cn.edu.bussiness.monthFinish.model.monthFinishModel;
import cn.edu.bussiness.monthFinish.service.getmonthFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class getmonthFinishServiceImpl implements getmonthFinishService {
    @Autowired
    private cn.edu.bussiness.monthFinish.dao.monthFinishRepository monthFinishRepository;
    @Override
    public monthFinishModel getmonthFinish() {
        List<monthFinish> monthFinishList= monthFinishRepository.getmonthFinish();
        List<monthFinishModel.row>rowList = new ArrayList<>();
        for(monthFinish mof :
            monthFinishList ){
            Date date = mof.getMonth();
            SimpleDateFormat sformat = new SimpleDateFormat();
            sformat.applyPattern("M");
            String month = sformat.format(date)+"月";
            DecimalFormat df = new DecimalFormat("######0.00");
            double rate = (double)mof.getCount_ending()/(double)mof.getCount_ending_future();
            monthFinishModel.row row = new monthFinishModel().new row(month,mof.getCount_ending(),mof.getCount_ending_future(),df.format(rate));
            rowList.add(row);
        }
        monthFinishModel monthFinishModel = new monthFinishModel();
        monthFinishModel.initColumn(rowList);
        monthFinishModel.setChartSetting("暂无设置");
        return monthFinishModel;
    }
}
