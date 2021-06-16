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
DROP DATABASE IF EXISTS `demo2106db`;
CREATE DATABASE `demo2106db`;
USE `demo2106db`;

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
  `hiredate` bigint NOT NULL COMMENT'受雇日期',
  `sal` float NOT NULL COMMENT'薪金',
  `comm` float NULL DEFAULT 0 COMMENT'佣金',
  `deptno` int(10) NOT NULL COMMENT'部门编号',
  PRIMARY KEY (`empno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (1,   '张伟',   '技术' ,8 , 946656000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (2,   '李伟',   '技术' ,9 , 946658500000, 1000, 100, 6);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (3,   '王伟',   '技术' ,10, 946666000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (4,   '赵伟',   '技术' ,11, 946658000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (5,   '张伟',   '技术' ,8,  946657600000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (6,   '李伟',   '技术' ,9,  946641000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (7,   '王伟',   '技术' ,10, 946650000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (8,   '赵经理', '经理' ,12, 946650000000, 2000, 100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (9,   '张经理', '经理' ,12, 946656000000, 2000, 250, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (10,  '李经理', '经理' ,12, 946656140000, 2000, 100, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (11,  '王经理', '经理' ,12, 866656040000, 2000, 100, 2);
insert into emp (`empno`,`ename`,`job`,`hiredate`,`sal`,`comm`,`deptno`)       values (12,  '总经理', '经理',     806650000000, 5000, 1500,2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (13,  '王伟',   '技术' ,10, 946666000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (14,  '赵伟',   '技术' ,11, 946657000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (15,  '张伟',   '技术' ,8,  946659000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (16,  '李伟',   '技术' ,9,  946680000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (17,  '王伟',   '技术' ,10, 946655000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (18,  '芦苇',   '扫地' ,8,  946656000000, 0,    100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (19,  '张经理', '经理' ,12, 946656000000, 2000, 250, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (20,  '张伟',   '技术' ,8 , 946656000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (21,  '王伟',   '市场' ,8 , 946656000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (22,  '李伟',   '市场' ,9 , 946656500000, 1000, 100, 6);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (23,  '赵伟',   '市场' ,10, 946656500000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (24,  '赵伟',   '市场' ,11, 946656600000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (25,  '张伟',   '市场' ,8,  946656600000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (26,  '李伟',   '市场' ,9,  886656700000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (27,  '王伟',   '技术' ,10, 886656700000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (28,  '张伟',   '技术' ,12, 946656800000, 2000, 100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (29,  '李伟',   '技术' ,12, 946656900000, 2000, 250, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (30,  '张伟',   '财务' ,8 , 890651000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (31,  '王伟',   '财务' ,8 , 896652000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (32,  '李伟',   '人员' ,9 , 946653000000, 1000, 100, 6);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (33,  '赵伟',   '人员' ,10, 946654000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (34,  '赵伟',   '人员' ,11, 906655000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (35,  '张伟',   '人员' ,8,  946656000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (36,  '李伟',   '人员' ,9,  946657000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (37,  '王伟',   '人员' ,10, 946658000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (38,  '张伟',   '人员' ,12, 946659000000, 2000, 100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (39,  '王伟',   '人员' ,12, 906616000000, 2000, 250, 2);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (40,  '张伟',   '技术' ,8 , 946626000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (41,  '王伟',   '技术' ,8 , 946636000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (42,  '李伟',   '技术' ,9 , 946646000000, 1000, 100, 6);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (43,  '赵伟',   '技术' ,10, 946656000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (44,  '赵伟',   '技术' ,11, 946666000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (45,  '张伟',   '技术' ,8,  946676000000, 1000, 100, 1);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (46,  '李伟',   '技术' ,9,  946686000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (47,  '王伟',   '技术' ,10, 946696000000, 1000, 100, 3);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (48,  '张伟',   '技术' ,12, 946606000000, 2000, 100, 8);
insert into emp (`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`) values (49,  '王伟',   '技术' ,12, 946600000000, 2000, 250, 2);

SET FOREIGN_KEY_CHECKS = 1;
