package cn.edu.bussiness.labstu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * DROP TABLE IF EXISTS `stat_exam_stu_score`;
 * CREATE TABLE `stat_exam_stu_score`  (
 *   `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
 *   `TODAY` datetime(0)    DEFAULT NULL COMMENT '月 1号0点',
 *   `COURSE` int(11)  DEFAULT NULL COMMENT '课程id',
 *   `COURSE_NAME`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
 *   `STU_COUNT` int(11)  DEFAULT NULL COMMENT '人数',
 *   `SCORE`   FLOAT(5,2) DEFAULT NULL COMMENT '分数',
 *   `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`BUSINESS_ID`)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实验学生分数' ROW_FORMAT = Dynamic;
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="stat_exam_stu_score")
public class labstu {
    @Id
    @GeneratedValue(generator = "JDBC")
    private int business_id;
    private Date today;
    private int course;
    private String course_name;
    private int stu_count;
    private float score;
    private String remarks;
}
