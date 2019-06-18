package cn.edu.bussiness.completeRate.dao;

import cn.edu.bussiness.completeRate.entity.completeRate;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComRateRepository {

    @Select("select * from stat_course_exam where to_days(today) = to_days(now())")
    List<completeRate> getComRate();

    @Select("select * from stat_course_exam where DATEDIFF(today,NOW())=-1")
    List<completeRate> getComRate_yesterday();
}
