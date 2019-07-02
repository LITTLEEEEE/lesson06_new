package cn.edu.bussiness.Experimental.dao;

import cn.edu.bussiness.Experimental.entity.experimental;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperimentalRepository {

    @Select("select * from stat_exam_score order by TODAY ")
    List<experimental> getexper();


}
