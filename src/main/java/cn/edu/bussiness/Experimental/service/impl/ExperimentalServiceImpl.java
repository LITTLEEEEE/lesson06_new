package cn.edu.bussiness.Experimental.service.impl;

import cn.edu.bussiness.Experimental.dao.ExperimentalRepository;
import cn.edu.bussiness.Experimental.entity.experimental;
import cn.edu.bussiness.Experimental.model.experimentModel;
import cn.edu.bussiness.Experimental.service.ExperimentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentalServiceImpl implements ExperimentalService {
    @Autowired
    private ExperimentalRepository experimentalRepository;

    @Override
    public experimentModel getexper() {
        List<experimental> experimentalList = experimentalRepository.getexper();
        List<experimentModel.row> rowList = new ArrayList<>();
        for(experimental exp :
                experimentalList){
            Date date = exp.getToday();
            String time = date.getDay()+"/"+date.getMonth();
            float intel = exp.getExam_intelligent();
            float manual = exp.getExam_manual();
            int count = exp.getExam_count();
            experimentModel.row row = new experimentModel().new row(time,intel,manual,count);
            rowList.add(row);
        }
        experimentModel experimentModel = new experimentModel();
        experimentModel.init(rowList);
        return experimentModel;
    }
}
