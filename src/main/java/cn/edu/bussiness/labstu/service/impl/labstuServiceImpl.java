package cn.edu.bussiness.labstu.service.impl;

import cn.edu.bussiness.labstu.dao.labstuRepository;
import cn.edu.bussiness.labstu.entity.labstu;
import cn.edu.bussiness.labstu.model.labstuModel;
import cn.edu.bussiness.labstu.service.labstuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class labstuServiceImpl implements labstuService {
    @Autowired
    labstuRepository labstuRepository;

    @Override
    public labstuModel getlabstuModel() {
        List<Integer> CourseId = labstuRepository.getCourseId();
        Map<String,List<labstuModel.course>> maps = new HashMap<>();
        for(Integer i : CourseId){
            List<labstu> labstus = labstuRepository.getCourse(i);
            List<labstuModel.course> courses = new ArrayList<>();
            String coursename=null;
            //-----private Map<String,List<course>> maps;---for循环获取List<course>---------------

            for(labstu labstu : labstus){
                SimpleDateFormat sformat = new SimpleDateFormat();
                Date cdate = labstu.getToday();
                sformat.applyPattern("MM");
                String date = sformat.format(cdate)+"/";
                sformat.applyPattern("dd");
                date+=sformat.format(cdate);
                labstuModel.course course = new labstuModel().new course(date,labstu.getStu_count(),labstu.getScore());
                courses.add(course);
                coursename = labstu.getCourse_name();
            }
            maps.put(coursename,courses);

        }
        labstuModel labstuModel = new labstuModel();
        labstuModel.init(maps);
        return labstuModel;

    }
}
