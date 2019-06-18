package cn.edu.bussiness.monthFinish.dao;

import cn.edu.bussiness.monthFinish.entity.monthFinish;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface monthFinishRepository {

    @Select("select * from stat_course_ending")
    List<monthFinish> getmonthFinish();

}
