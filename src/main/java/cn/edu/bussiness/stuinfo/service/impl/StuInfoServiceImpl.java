package cn.edu.bussiness.stuinfo.service.impl;


import cn.edu.bussiness.stuinfo.dao.StuInfoRepository;
import cn.edu.bussiness.stuinfo.entity.StuInfo;
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
        List<StuInfo> stuList = stuInfoRepository.selectAll();
        TopTenModel top = new TopTenModel();
        top.initColumn();
        top.setTeacher(new ArrayList<>());
        List<TopTenModel.Info> res = new ArrayList<>();
        log.info("stu size is"  + stuList.size());
        for (StuInfo stu :
                stuList) {
            TopTenModel.Info info = new TopTenModel().new Info();
            info.setData(stu.getCode(),stu.getName(),stu.getCountOnline() + "",stu.getCountOperate() + "");
            res.add(info);
        }
        top.setStudent(res);
        return top;
    }
}
