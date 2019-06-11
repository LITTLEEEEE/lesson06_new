package cn.edu.bussiness.stuinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * CREATE TABLE `stat_student_info`  (
 *   `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
 *   `TODAY` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
 *   `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '姓名',
 *   `CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '学号',
 *   `COUNT_OPERATE`  int(11)  DEFAULT NULL COMMENT '活跃值',
 *   `COUNT_ONLINE`  int(11)  DEFAULT NULL COMMENT '在线时长',
 *   `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`BUSINESS_ID`)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程完结情况表' ROW_FORMAT = Dynamic;
 */
@Data
@Table(name = "stat_student_info")
@NoArgsConstructor
@AllArgsConstructor
public class StuInfo {

    @Id
    @GeneratedValue(generator = "JDBC")
    private int businessId;
    private Date today;
    private String name,code,remarks;
    private int countOperate,countOnline;

}
