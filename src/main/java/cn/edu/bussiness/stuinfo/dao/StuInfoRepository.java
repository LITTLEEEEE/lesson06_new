package cn.edu.bussiness.stuinfo.dao;

import cn.edu.bussiness.stuinfo.entity.StuInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StuInfoRepository extends Mapper<StuInfo> {

    @Select("select * from stat_student_info")
    public StuInfo query();
}
