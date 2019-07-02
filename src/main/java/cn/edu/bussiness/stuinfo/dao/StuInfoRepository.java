package cn.edu.bussiness.stuinfo.dao;

import cn.edu.bussiness.stuinfo.entity.CompleteRate;
import cn.edu.bussiness.stuinfo.entity.StuInfo;
import cn.edu.bussiness.stuinfo.entity.TeacherInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StuInfoRepository extends Mapper<StuInfo> {

    @Select("SELECT\n" +
            "\tcount(1) AS 'unfinish',\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tcount(1)\n" +
            "\t\tFROM\n" +
            "\t\t\tstat_course_status s\n" +
            "\t\tLEFT JOIN b_term b ON s.TERM = b.BUSINESS_ID\n" +
            "\t\tWHERE\n" +
            "\t\t\tb.FLAG = '1'\n" +
            "\t) AS 'course_sum'\n" +
            "FROM\n" +
            "\tstat_course_status s\n" +
            "LEFT JOIN b_term b ON s.TERM = b.BUSINESS_ID\n" +
            "WHERE\n" +
            "\tb.FLAG = '1'\n" +
            "AND s.`STATUS` = '0'")
    public CompleteRate getCompleteRate();

    @Select("select * from stat_teacher_info where to_days(TODAY) = to_days(now())ORDER BY COUNT_OPERATE desc LIMIT 10 ")
    public List<TeacherInfo> getteacher();

    @Select("select * from stat_student_info where to_days(TODAY) = to_days(now())ORDER BY COUNT_OPERATE desc LIMIT 10 ")
    public List<StuInfo> getstudent();

}
