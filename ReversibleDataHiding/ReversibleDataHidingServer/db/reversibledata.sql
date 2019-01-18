/*
SQLyog Ultimate v8.55 
MySQL - 5.0.15-nt : Database - reversibledata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reversibledata` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `reversibledata`;

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `imageid` bigint(20) NOT NULL auto_increment,
  `loginid` bigint(20) default NULL,
  `imagefile` varchar(256) default NULL,
  `imagetype` varchar(256) default NULL,
  PRIMARY KEY  (`imageid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `images` */

insert  into `images`(`imageid`,`loginid`,`imagefile`,`imagetype`) values (1,1,'screenshot1.png','image1'),(2,1,'screenshot2.png','image2');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `loginid` bigint(20) NOT NULL auto_increment,
  `username` varchar(256) default NULL,
  `password` varchar(256) default NULL,
  `emailid` varchar(256) default NULL,
  PRIMARY KEY  (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`loginid`,`username`,`password`,`emailid`) values (1,'Santhosh','redhat123','santhosh1982.r@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
