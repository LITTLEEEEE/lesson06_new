package cn.edu.bussiness.Experimental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * CREATE TABLE `stat_exam_score`  (
 *   `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
 *   `TODAY` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
 *   `EXAM_COUNT` int(11)  DEFAULT NULL COMMENT '实验数量',
 *   `EXAM_MANUAL`   FLOAT(5,2) DEFAULT NULL COMMENT '人工评分',
 *   `EXAM_INTELLIGENT`   FLOAT(5,2) DEFAULT NULL COMMENT '智能评分',
 *   `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`BUSINESS_ID`)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实验批阅情况' ROW_FORMAT = Dynamic;
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stat_exam_score")
public class experimental {
    @Id
    @GeneratedValue(generator = "JDBC")
    private int business_id;
    private Date today;
    private int exam_count;
    private float exam_manual;
    private float exam_intelligent;
    private String remarks;
}
