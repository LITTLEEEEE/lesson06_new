package cn.edu.bussiness.monthFinish.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * DROP TABLE IF EXISTS `stat_course_ending`;
 * CREATE TABLE `stat_course_ending`  (
 *   `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
 *   `MONTH` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
 *   `COUNT_ENDING` int(11)  DEFAULT NULL COMMENT '结束的课程数量',
 *   `COUNT_ENDING_FUTURE`  int(11)  DEFAULT NULL COMMENT '要结束的课程数量',
 *   `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`BUSINESS_ID`)
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程完结情况表' ROW_FORMAT = Dynamic;
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stat_course_ending")
public class monthFinish {
    @Id
    @GeneratedValue(generator = "JDBC")
    private int business_id;
    private Date month;
    private int count_ending,count_ending_future;
    private String remarks;
}
