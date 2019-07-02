package cn.edu.bussiness.stuinfo.service.impl;


import cn.edu.bussiness.stuinfo.dao.StuInfoRepository;
import cn.edu.bussiness.stuinfo.entity.CompleteRate;
import cn.edu.bussiness.stuinfo.entity.StuInfo;
import cn.edu.bussiness.stuinfo.entity.TeacherInfo;
import cn.edu.bussiness.stuinfo.model.CompleteRateModel;
import cn.edu.bussiness.stuinfo.model.TopTenModel;
import cn.edu.bussiness.stuinfo.service.StuInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
@Slf4j
public class StuInfoServiceImpl implements StuInfoService {

    @Autowired
    private StuInfoRepository stuInfoRepository;

    @Override
    public TopTenModel query() {
        List<StuInfo> stuList = stuInfoRepository.getstudent();
        List<TeacherInfo> teaList = stuInfoRepository.getteacher();
        TopTenModel top = new TopTenModel();
        top.initColumn();

        List<TopTenModel.Info> stures = new ArrayList<>();
        List<TopTenModel.Info> teares = new ArrayList<>();
        for (StuInfo stu :
                stuList) {
            TopTenModel.Info info = new TopTenModel().new Info();
            info.setData(stu.getCode(),stu.getName(),stu.getCount_online() + "",stu.getCount_operate() + "");
            stures.add(info);
        }
        for (TeacherInfo tea :
                teaList) {
            TopTenModel.Info info = new TopTenModel().new Info();
            info.setData(tea.getCode(),tea.getName(),tea.getCount_online() + "",tea.getCount_operate() + "");
            teares.add(info);
        }
        top.setTeacher(teares);
        top.setStudent(stures);
        return top;
    }

    @Override
    public CompleteRateModel getCompleteRate() {
        CompleteRate completeRate = stuInfoRepository.getCompleteRate();
        int finish = completeRate.getCourse_sum()-completeRate.getUnfinish();
        double value = Double.valueOf(finish)/Double.valueOf(completeRate.getCourse_sum());
        CompleteRateModel crm = new CompleteRateModel();
        crm.setFinish(finish);
        crm.setUnfinished(completeRate.getUnfinish());
        crm.initchartData(value,completeRate.getUnfinish(),finish);
        crm.setChartSettings("暂无设置");
        return crm;

    }
}
