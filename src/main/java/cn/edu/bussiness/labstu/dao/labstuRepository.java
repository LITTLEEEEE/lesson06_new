package cn.edu.bussiness.labstu.dao;

import cn.edu.bussiness.labstu.entity.labstu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface labstuRepository {
    @Select("select COURSE from stat_exam_stu_score group by course")
    List<Integer> getCourseId();

    @Select("select * from stat_exam_stu_score where course = #{courseId} order by TODAY limit 10")
    List<labstu> getCourse(@Param("courseId") int id);
}
