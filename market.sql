/*
 Navicat Premium Data Transfer
 
 Source Server : root_connect
 Source Server Type : MySQL
 Source Server Version : 80022
 Source Host : localhost:3306
 Source Schema : nebulahomedb
 
 Target Server Type : MySQL
 Target Server Version : 80022
 File Encoding : 65001

 Date: 2021/03/22 12:03:00
*/
DROP DATABASE IF EXISTS demo2106db;
CREATE DATABASE IF NOT EXISTS demo2106db CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE demo2106db;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `user_id` bigint NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blink
-- ----------------------------
DROP TABLE IF EXISTS `blink`;
CREATE TABLE `blink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `text` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `author_id` bigint NOT NULL,
  `like` int NOT NULL DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `del` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'user',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `del` bit(1) NOT NULL DEFAULT b'0'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;