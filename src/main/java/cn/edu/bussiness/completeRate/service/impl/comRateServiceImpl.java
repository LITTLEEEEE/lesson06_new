package cn.edu.bussiness.completeRate.service.impl;

import cn.edu.bussiness.completeRate.dao.ComRateRepository;
import cn.edu.bussiness.completeRate.entity.completeRate;
import cn.edu.bussiness.completeRate.model.comRateModel;
import cn.edu.bussiness.completeRate.service.comRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class comRateServiceImpl implements comRateService {
    @Autowired
    private ComRateRepository comRateRepository;
    @Override
    public comRateModel getComRate() {
        List<completeRate> completeRateList = comRateRepository.getComRate();
        return(getModel(completeRateList));
    }

    @Override
    public comRateModel getComRate_yesterday() {
        List<completeRate> completeRateList = comRateRepository.getComRate_yesterday();
        return(getModel(completeRateList));
    }
    //重复方法封装，用来实现comRateModel的生成
    private comRateModel getModel(List<completeRate> completeRateList){
        List<comRateModel.row> rowList = new ArrayList<>();
        for(completeRate crl :
                completeRateList){
            String course = crl.getCourse_name();
            float statu = crl.getStatus();
            comRateModel.row row = new comRateModel().new row(course,statu);
            rowList.add(row);
        }
        comRateModel comRateModel = new comRateModel();
        comRateModel.init(rowList);
        return comRateModel;
    }
}
