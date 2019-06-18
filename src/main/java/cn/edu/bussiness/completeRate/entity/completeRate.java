package cn.edu.bussiness.completeRate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * DROP TABLE IF EXISTS `stat_course_exam`;
 * CREATE TABLE `stat_course_exam`  (
 *   `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
 *   `TODAY` datetime(0)  DEFAULT NULL COMMENT '月 1号0点',
 *   `COURSE` int(11)  DEFAULT NULL COMMENT '课程id',
 *   `COURSE_NAME`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
 *   `STATUS` FLOAT(5,2) DEFAULT NULL COMMENT '完成率',
 *   `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`BUSINESS_ID`)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实现完成率' ROW_FORMAT = Dynamic;
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stat_course_exam")
public class completeRate {
    @Id
    @GeneratedValue(generator = "JDBC")
    private int business_id;
    private Date today;
    private int course;
    private String course_name;
    private float status;
    private String remarks;
}
