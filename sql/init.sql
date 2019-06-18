SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_term
-- ----------------------------
DROP TABLE IF EXISTS `b_term`;
CREATE TABLE `b_term`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期名称',
  `FLAG` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '启用标记（0：停用；1：启用）',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学期表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stat_course_status
-- ----------------------------
DROP TABLE IF EXISTS `stat_course_status`;
CREATE TABLE `stat_course_status`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `TERM` int(11) DEFAULT NULL COMMENT '学期id',
  `COURSE` int(11)  DEFAULT NULL COMMENT '课程id',
  `COURSE_NAME`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '启用标记（0：结束；1：开启）',
  `UPDATE_DATE` datetime(0) DEFAULT NULL COMMENT '统计日期',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程情况表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for stat_course_ending
-- ----------------------------
DROP TABLE IF EXISTS `stat_course_ending`;
CREATE TABLE `stat_course_ending`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `MONTH` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
  `COUNT_ENDING` int(11)  DEFAULT NULL COMMENT '结束的课程数量',
  `COUNT_ENDING_FUTURE`  int(11)  DEFAULT NULL COMMENT '要结束的课程数量',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程完结情况表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stat_student_info
-- ----------------------------
DROP TABLE IF EXISTS `stat_student_info`;
CREATE TABLE `stat_student_info`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `TODAY` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '姓名',
  `CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL COMMENT '学号',
  `COUNT_OPERATE`  int(11)  DEFAULT NULL COMMENT '活跃值',
  `COUNT_ONLINE`  int(11)  DEFAULT NULL COMMENT '在线时长',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程完结情况表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stat_course_exam
-- ----------------------------
DROP TABLE IF EXISTS `stat_course_exam`;
CREATE TABLE `stat_course_exam`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `TODAY` datetime(0)  DEFAULT NULL COMMENT '月 1号0点',
  `COURSE` int(11)  DEFAULT NULL COMMENT '课程id',
  `COURSE_NAME`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `STATUS` FLOAT(5,2) DEFAULT NULL COMMENT '完成率',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实现完成率' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stat_course_exam
-- ----------------------------
DROP TABLE IF EXISTS `stat_exam_score`;
CREATE TABLE `stat_exam_score`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `TODAY` datetime(0)   DEFAULT NULL COMMENT '月 1号0点',
  `EXAM_COUNT` int(11)  DEFAULT NULL COMMENT '实验数量',
  `EXAM_MANUAL`   FLOAT(5,2) DEFAULT NULL COMMENT '人工评分',
  `EXAM_INTELLIGENT`   FLOAT(5,2) DEFAULT NULL COMMENT '智能评分',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实验批阅情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stat_exam_stu_score
-- ----------------------------
DROP TABLE IF EXISTS `stat_exam_stu_score`;
CREATE TABLE `stat_exam_stu_score`  (
  `BUSINESS_ID` int(11) AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `TODAY` datetime(0)    DEFAULT NULL COMMENT '月 1号0点',
  `COURSE` int(11)  DEFAULT NULL COMMENT '课程id',
  `COURSE_NAME`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `STU_COUNT` int(11)  DEFAULT NULL COMMENT '人数',
  `SCORE`   FLOAT(5,2) DEFAULT NULL COMMENT '分数',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`BUSINESS_ID`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实验学生分数' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;