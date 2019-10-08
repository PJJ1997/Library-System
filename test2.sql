/*
Navicat MySQL Data Transfer

Source Server         : firstConn
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-07-06 20:30:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_num` varchar(255) DEFAULT NULL,
  `book_image` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pubcompany` varchar(255) DEFAULT NULL,
  `buydate` varchar(255) DEFAULT NULL,
  `pubdate` varchar(255) DEFAULT NULL,
  `giveback` varchar(255) DEFAULT NULL,
  `category_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `UK_4dtr663bd4oubw24rteo1wyow` (`book_num`),
  KEY `FKt6gugnbenstymryiqg7sg8kah` (`category_num`),
  CONSTRAINT `FKt6gugnbenstymryiqg7sg8kah` FOREIGN KEY (`category_num`) REFERENCES `category` (`category_num`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('7', '1', 'img1.png', 'C++PrimerPlus', '张海龙,袁国忠', '87', '人民邮电出版社', '2019-5-1', '2017-3-2', '可借', '2');
INSERT INTO `book` VALUES ('9', '3', 'img3.png', '人间失格', '太宰治', '32', '民主与建设出版社', '2019-5-1', '2017-3-5', '可借', '6');
INSERT INTO `book` VALUES ('10', '4', 'img4.png', 'JavaWeb', '李兴华,王月清', '69.8', '清华大学出版社', '2019-9-1', '2017-3-4', '可借', '2');
INSERT INTO `book` VALUES ('11', '5', 'img5.png', '活着', '余华', '35', '北京出版集团北京十月文艺出版社', '2019-9-1', '2017-3-2', '可借', '6');
INSERT INTO `book` VALUES ('12', '6', 'img6.png', '别让直性子毁了你', '冠诚', '38', '吉林出版集团股份有限公司', '2019-9-2', '2017-3-2', '可借', '6');
INSERT INTO `book` VALUES ('13', '7', 'img7.png', '第七天', '余华', '39.8', '新星', '2019-9-1', '2017-3-2', '可借', '6');
INSERT INTO `book` VALUES ('14', '8', 'img8.png', 'ThinkPHP', '夏磊', '49', '清华大学出版社', '2019-9-1', '2017-3-2', '可借', '2');
INSERT INTO `book` VALUES ('15', '9', 'img9.png', 'Python数据科学手册', '杰克·万托布拉斯', '109', '人民邮电出版社', '2019-9-1', '2017-3-2', '可借', '2');
INSERT INTO `book` VALUES ('16', '10', 'img10.png', '生物学八年级下册', '无', '14.5', '人民教育出版社', '2019-9-1', '2017-3-2', '可借', '3');
INSERT INTO `book` VALUES ('17', '11', 'img11.png', '生物学七年级上册', '无', '8.9', '人民教育出版社', '2019-9-1', '2017-3-2', '可借', '3');
INSERT INTO `book` VALUES ('20', '14', 'img14.png', '物理八年级下册', '无', '6.15', '人民教育出版社', '2019-9-1', '2017-3-2', '可借', '4');
INSERT INTO `book` VALUES ('21', '15', 'img15.png', '你不可不知的50个物理知识', '贝克', '29', '人民邮电出版社', '2019-9-1', '2017-3-2', '可借', '4');
INSERT INTO `book` VALUES ('22', '16', 'img16.png', '细说大清', '无', '296', '中国华侨出版社', '2019-9-1', '2017-3-2', '可借', '5');
INSERT INTO `book` VALUES ('23', '17', 'img17.png', '中国简史', '勒内.格鲁塞', '38', '九州出版社', '2019-9-1', '2017-3-2', '可借', '5');
INSERT INTO `book` VALUES ('24', '18', 'img18.png', '中国通史', '《中国通史》编委会', '1560', '中国书店', '2019-9-1', '2017-3-2', '可借', '5');
INSERT INTO `book` VALUES ('25', '19', 'img19.png', '地理五诀', '赵玉材', '38', '世界知识出版社', '2019-9-1', '2017-3-2', '可借', '7');
INSERT INTO `book` VALUES ('26', '20', 'img20.png', '世界地理全知道', '金涛', '29.8', '百花洲文艺出版社', '2019-9-1', '2017-3-2', '可借', '7');
INSERT INTO `book` VALUES ('28', '2', 'img2.png', 'c  primerplus', '天工在线', '87', '啊是打算打算大所大所多', '2019-9-2', '2019-9-22', '可借', '2');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrow_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `borrow_time` varchar(255) DEFAULT NULL,
  `return_time` varchar(255) DEFAULT NULL,
  `ticket` double DEFAULT NULL,
  `exprie` bigint(20) DEFAULT NULL,
  `stu_num` varchar(255) DEFAULT NULL,
  `book_num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`borrow_id`),
  KEY `FK7jlh1eaoillorjhe0evivkbhw` (`book_num`),
  KEY `FK9wakjhcyttr28uqdwtm1ul1o2` (`stu_num`),
  CONSTRAINT `FK7jlh1eaoillorjhe0evivkbhw` FOREIGN KEY (`book_num`) REFERENCES `book` (`book_num`),
  CONSTRAINT `FK9wakjhcyttr28uqdwtm1ul1o2` FOREIGN KEY (`stu_num`) REFERENCES `student` (`stu_num`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of borrow
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_num` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `UK_jhmmu0mdhcfwa8vox9lxxb83p` (`category_num`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('2', '2', '计算机类');
INSERT INTO `category` VALUES ('3', '3', '生物类');
INSERT INTO `category` VALUES ('4', '4', '物理类');
INSERT INTO `category` VALUES ('5', '5', '历史类');
INSERT INTO `category` VALUES ('6', '6', '生活类');
INSERT INTO `category` VALUES ('7', '7', '地理类');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manager_num` varchar(255) DEFAULT NULL,
  `manager_name` varchar(255) DEFAULT NULL,
  `enter_time` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `UK_6ruo71dbmbeagqwewt6t7wd6t` (`manager_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '12345', '彭俊杰', '2019-5-12', '462016021@qq.com', '男', '12345671231');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `credit_id` varchar(255) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enter_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `UK_hlgvdxpwhw2kqpffmmav8vdv8` (`stu_num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '彭彭彭', '383839383833938339', '外国语学院', '英语', '英语1', '男', '777777', '462016021@qq.com', '2016-9-11');
INSERT INTO `student` VALUES ('3', '3', '配', '383839383833938339', '外国语学院', '英语', '英语1', '女', '4564567567', '462016021@qq.com', '2016-9-11');
