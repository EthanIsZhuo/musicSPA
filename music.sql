/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.25-log : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `music`;

/*Table structure for table `musicinfo` */

DROP TABLE IF EXISTS `musicinfo`;

CREATE TABLE `musicinfo` (
  `musicId` int(10) NOT NULL AUTO_INCREMENT,
  `musicName` varchar(50) DEFAULT NULL,
  `singer` varchar(50) DEFAULT NULL,
  `musicUrl` varchar(50) DEFAULT NULL,
  `uploadTime` varchar(30) DEFAULT NULL,
  `typeId` int(10) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`musicId`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

/*Data for the table `musicinfo` */

insert  into `musicinfo`(`musicId`,`musicName`,`singer`,`musicUrl`,`uploadTime`,`typeId`,`userId`) values 
(11,'奇妙能力歌','陈粒 ','1640519969905.mp3','2021-12-26 19:59:29',1,7),
(12,'走马','陈粒 ','1640519984787.mp3','2021-12-26 19:59:44',1,7),
(13,'狗日的青春','贰佰 ','1640520007048.mp3','2021-12-26 20:00:07',1,7),
(14,'傲寒','马頔 ','1640520023807.mp3','2021-12-26 20:00:23',1,7),
(15,'南山南','马頔 ','1640520038114.mp3','2021-12-26 20:00:38',1,7),
(16,'安和桥','宋冬野 ','1640520050451.mp3','2021-12-26 20:00:50',1,7),
(17,'斑马，斑马','宋冬野 ','1640520062832.mp3','2021-12-26 20:01:02',1,7),
(18,'探清水河','晓月老板 ','1640520075910.mp3','2021-12-26 20:01:15',1,7),
(19,'成都','赵雷 ','1640520090938.mp3','2021-12-26 20:01:30',1,7),
(20,'你就是我最想要的丫头','赵照 ','1640520106874.mp3','2021-12-26 20:01:46',1,7),
(21,'声律启蒙','赵照 ','1640520118274.mp3','2021-12-26 20:01:58',1,7),
(22,'晚睡的姑娘','周新诚 ','1640520131029.mp3','2021-12-26 20:02:11',1,7),
(23,'涩','纣王老胡 ','1640520141796.mp3','2021-12-26 20:02:21',1,7),
(24,'嘉宾 (粤语版)','常颖杰 ','1640520158727.mp3','2021-12-26 20:02:38',2,7),
(25,'谁来剪月光','陈奕迅 ','1640520168416.mp3','2021-12-26 20:02:48',2,7),
(26,'是但求其爱','陈奕迅 ','1640520181198.mp3','2021-12-26 20:03:01',2,7),
(27,'陀飞轮','陈奕迅 ','1640520193771.mp3','2021-12-26 20:03:13',2,7),
(28,'月球上的人','陈奕迅 ','1640520205563.mp3','2021-12-26 20:03:25',2,7),
(29,'爱的代价','李宗盛 ','1640520223605.mp3','2021-12-26 20:03:43',2,7),
(30,'给自己的歌','李宗盛 ','1640520242517.mp3','2021-12-26 20:04:02',2,7),
(31,'这世界那么多人','莫文蔚 ','1640520279290.mp3','2021-12-26 20:04:39',2,7),
(32,'最冷一天','张国荣 ','1640520305319.mp3','2021-12-26 20:05:05',2,7),
(33,'Clarence','Isato Nakagawa ','1640520356893.mp3','2021-12-26 20:05:56',4,7),
(34,'莫扎特：D大调四手联弹钢琴奏鸣曲 II','Various Artists ','1640520367346.mp3','2021-12-26 20:06:07',4,7),
(35,'枫桥夜泊','陈亮 ','1640520403711.mp3','2021-12-26 20:06:43',4,7),
(36,'无题','陈亮 ','1640520412585.mp3','2021-12-26 20:06:52',4,7),
(37,'家路','押尾光太郎 (押尾コータロー) ','1640520420556.mp3','2021-12-26 20:07:00',4,7),
(38,'One Of Us','郑成河 (정성하) ','1640520428825.mp3','2021-12-26 20:07:08',4,7),
(39,'花房姑娘','崔健 ','1640520627990.mp3','2021-12-26 20:10:27',3,7),
(40,'嘴上功夫','大波浪 ','1640520642095.mp3','2021-12-26 20:10:42',3,7),
(41,'高级动物','窦唯 ','1640520651352.mp3','2021-12-26 20:10:51',3,7),
(42,'无地自容','黑豹乐队 ','1640520661816.mp3','2021-12-26 20:11:01',3,7),
(43,'霓虹甜心','马赛克乐队 ','1640520670619.mp3','2021-12-26 20:11:10',3,7),
(44,'梦回唐朝','唐朝 ','1640520681339.mp3','2021-12-26 20:11:21',3,7),
(45,'再见杰克','痛仰乐队 ','1640520694558.mp3','2021-12-26 20:11:34',3,7),
(46,'不会改变','谢天笑 ','1640520702022.mp3','2021-12-26 20:11:42',3,7),
(55,'晚睡的姑娘','周新诚 ','1640535239615.mp3','2021-12-27 00:13:59',1,7),
(56,' Flower','岸部真明 (Masaaki Kishibe) ','1640588540847.mp3','2021-12-27 15:02:20',4,1),
(57,' 流れ行く雲 (流行的云)','岸部真明 (Masaaki Kishibe) ','1640588560094.mp3','2021-12-27 15:02:40',4,1),
(58,' 奇迹の山 (奇迹的山)','岸部真明 (Masaaki Kishibe) ','1640588570374.mp3','2021-12-27 15:02:50',4,1),
(59,' 枫桥夜泊','陈亮 ','1640590038310.mp3','2021-12-27 15:27:18',4,1),
(60,' 海阔天空','BEYOND ','1640786798956.mp3','2021-12-29 22:06:39',2,7),
(61,' 假行僧 (Live)','崔健 ','1640786900343.mp3','2021-12-29 22:08:20',3,7),
(62,' 春天的故事','二手玫瑰乐队 ','1640786915032.mp3','2021-12-29 22:08:35',3,7),
(63,' 夜空中最亮的星','逃跑计划 ','1640786942097.mp3','2021-12-29 22:09:02',3,7);

/*Table structure for table `musictype` */

DROP TABLE IF EXISTS `musictype`;

CREATE TABLE `musictype` (
  `typeId` int(10) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `musictype` */

insert  into `musictype`(`typeId`,`typeName`) values 
(1,'民谣'),
(2,'流行'),
(3,'摇滚'),
(4,'纯音乐');

/*Table structure for table `mymusic` */

DROP TABLE IF EXISTS `mymusic`;

CREATE TABLE `mymusic` (
  `musicId` int(10) DEFAULT NULL,
  `accountId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mymusic` */

insert  into `mymusic`(`musicId`,`accountId`) values 
(19,1),
(26,7),
(23,1),
(21,1),
(22,1),
(24,1),
(11,1),
(12,1),
(11,7),
(14,7),
(16,7),
(15,7),
(39,7),
(13,7),
(13,0),
(15,0),
(38,8),
(11,4),
(16,4),
(14,4),
(11,8),
(12,8),
(16,8),
(33,8),
(34,8),
(24,8),
(27,8),
(26,8),
(35,8),
(37,8),
(17,8),
(18,8),
(25,8),
(21,8),
(29,8),
(14,8),
(15,8),
(17,4),
(42,8),
(19,7),
(30,7),
(37,7),
(33,7),
(34,7),
(56,7);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(25) DEFAULT NULL,
  `userPwd` varchar(25) DEFAULT NULL,
  `playNum` int(20) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userId`,`userName`,`userPwd`,`playNum`) values 
(1,'111','111',1),
(3,'222','222',0),
(4,'888','888',4),
(5,'999','9999',0),
(6,'156','156',0),
(7,'ethan','123',2),
(8,'123','123',43),
(9,'666','666',0),
(10,'music666','123456',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
