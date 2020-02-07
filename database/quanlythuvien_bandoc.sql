-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlythuvien
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bandoc`
--

DROP TABLE IF EXISTS `bandoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bandoc` (
  `MaSoBanDoc` char(15) NOT NULL,
  `HoTen` varchar(45) NOT NULL,
  `GioiTinh` varchar(15) DEFAULT NULL,
  `NamSinh` int(11) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `SoChungMinhThu` varchar(15) NOT NULL,
  `SoDienThoai` char(15) NOT NULL,
  `Email` char(45) DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaSoBanDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandoc`
--

LOCK TABLES `bandoc` WRITE;
/*!40000 ALTER TABLE `bandoc` DISABLE KEYS */;
INSERT INTO `bandoc` VALUES ('BD1001','Mesut Ozil','Nam',1988,'Germany','452367856','0123456789','oziltro@gmail.com',1),('BD1003','Aaron Ramseys','Nữ',1987,'Wales','454654351354','645468745','ramseyarsenal@gmail.com',1),('BD1006','Leonel Messi','Nữ',1921,'Argentina','45264258625','0167854268','messi21thangtreo@gmail.com',0),('BD1007','Petch Cech','Nữ',1982,'Séc','412452354845','01254867512','cechars@gmail.com',1),('BD1008','LinhPH','Nam',1996,'TB','1521252021222','01254864235','linhph@gmail.com',1),('BD11111','LPH','Nam',2000,'TB','354354354','3435435','adsasd',1),('bdasdasd','adasd','adasd',452,'dấd','45','445345','�dasd�d',0),('﻿BD1000','Phạm Hải Linh','Nam',1996,'Thái Bình','54543454','0121354132','linh@gmail.com',1);
/*!40000 ALTER TABLE `bandoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-03 16:16:24
