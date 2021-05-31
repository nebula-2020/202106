/*
 Navicat Premium Data Transfer

 Source Server         : root_connect
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : demo2106db

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 24/05/2021 15:24:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `empno` int(10) NOT NULL COMMENT'员工号',
  `ename` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT'员工姓名',
  `job` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT'工作',
  `mgr` int(10) NULL DEFAULT NULL COMMENT'上级编号',
  `hiredate` int(10) NOT NULL COMMENT'受雇日期',
  `sal` float NOT NULL COMMENT'薪金',
  `comm` float NULL DEFAULT 0 COMMENT'佣金',
  `deptno` int(10) NOT NULL COMMENT'部门编号',
  PRIMARY KEY (`empno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (1,  '张伟',   '技术' ,8 , 19960109, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (2,  '李伟',   '技术' ,9 , 19960101, 1000, 100, 6);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (3,  '王伟',   '技术' ,10, 19980808, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (4,  '赵伟',   '技术' ,11, 19960612, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (5,  '张伟',   '技术' ,8,  19990323, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (6,  '李伟',   '技术' ,9,  19971010, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (7,  '王伟',   '技术' ,10, 19961204, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (8,  '赵经理', '经理' ,12, 20020603, 2000, 100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (9,  '张经理', '经理' ,12, 19960130, 2000, 250, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (10, '李经理', '经理' ,12, 19951229, 2000, 100, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (11, '王经理', '经理' ,12, 19960215, 2000, 100, 2);

SET FOREIGN_KEY_CHECKS = 1;
