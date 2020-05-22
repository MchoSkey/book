/*
Navicat MySQL Data Transfer

Source Server         : pyy
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : lineclass

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-05-22 21:55:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'Java大法', '高司令', '33.90', 'Java之源');
INSERT INTO `book` VALUES ('2', 'PHP', '高老师', '20.50', '世界上最好的语言');
INSERT INTO `book` VALUES ('3', 'Java编程', '老高', '11.00', '编程之美');
INSERT INTO `book` VALUES ('4', '数据结构', '高晓松', '55.00', '于洋也是');
INSERT INTO `book` VALUES ('5', '学Java', '马三', '33.00', '入门到放弃');
INSERT INTO `book` VALUES ('6', 'c', '马六', '90.30', '指针+内存');
INSERT INTO `book` VALUES ('7', 'c++', '大马猴', '9.90', '包邮');
INSERT INTO `book` VALUES ('8', 'object-c', '沈富', '11.00', '浮生六记');
INSERT INTO `book` VALUES ('9', 'js高级', '马不多', '19.90', '前端交互，动态效果');
INSERT INTO `book` VALUES ('11', 'vue', '不多先生', '19.90', '前端框架最好用的，没有之一');
INSERT INTO `book` VALUES ('17', 'Java大法', '不多帅哥', '213.00', 'ssh框架需要好好研究');
INSERT INTO `book` VALUES ('18', 'Java高级', '帅哥不多', '34.00', 'spring 全家桶');
INSERT INTO `book` VALUES ('19', 'Java初级', '马哥', '232.00', 'Java基础很关键');
INSERT INTO `book` VALUES ('20', 'Javaweb', '不多讲故事', '24.00', 'Javaweb可以多练手');
INSERT INTO `book` VALUES ('21', '前端', '不多', '243.00', '前端很简单的');
INSERT INTO `book` VALUES ('22', '前端工作之妹子陪玩', '不多讲段子', '22.00', '学后端的看不起学前端的，前端的不服气');
INSERT INTO `book` VALUES ('23', 'JavaSE.ME,EE', '12', '213.00', '版本区别');
INSERT INTO `book` VALUES ('24', 'get/post', 'dsfa', '12.00', '老生常谈的区别');
INSERT INTO `book` VALUES ('25', 'spring', '不多先生', '19.90', 'IOC和DI');
INSERT INTO `book` VALUES ('26', '集中式和分布式', '微软', '23.00', '对比');
INSERT INTO `book` VALUES ('27', 'p2p', '马不多', '19.90', '点对点');
INSERT INTO `book` VALUES ('28', 'webService', '不多先生', '19.90', '特点');
INSERT INTO `book` VALUES ('29', 'PRAM', '不多先生', '19.90', '解释');

-- ----------------------------
-- Table structure for stringiduser
-- ----------------------------
DROP TABLE IF EXISTS `stringiduser`;
CREATE TABLE `stringiduser` (
  `id` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stringiduser
-- ----------------------------
INSERT INTO `stringiduser` VALUES ('8eed9445-9400-11ea-bb0b-c46516b9c540', '人马', '233');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123', '18');
INSERT INTO `user` VALUES ('2', '李四', '345', '20');
INSERT INTO `user` VALUES ('3', '宁宁', '123', '18');
INSERT INTO `user` VALUES ('4', '乐乐', '123', '16');
INSERT INTO `user` VALUES ('5', '贤贤', '999', '22');
INSERT INTO `user` VALUES ('6', '贝贝', '99', '28');
INSERT INTO `user` VALUES ('7', '婷婷', '123', '20');
INSERT INTO `user` VALUES ('8', '金陵', '123', '19');
INSERT INTO `user` VALUES ('9', '小宁宁', '123', '12');
INSERT INTO `user` VALUES ('11', '锤石', '123', '19');
INSERT INTO `user` VALUES ('12', '7级锤石', '456123', '19');
INSERT INTO `user` VALUES ('13', '8级锤石', '46', '19');
INSERT INTO `user` VALUES ('14', '卢锡安', '234', '99');
INSERT INTO `user` VALUES ('16', '灵魂收割者', '666', '99');
INSERT INTO `user` VALUES ('17', '8级锤石', '46', '19');
INSERT INTO `user` VALUES ('18', '8级锤石', '46', '19');
INSERT INTO `user` VALUES ('19', '上单女警', '22', '19');
INSERT INTO `user` VALUES ('20', '上单女警', '22', '19');
