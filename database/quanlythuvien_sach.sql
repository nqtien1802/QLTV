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
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sach` (
  `MaSoSach` char(15) NOT NULL,
  `TenSach` varchar(45) DEFAULT NULL,
  `NhaXuatBan` varchar(45) DEFAULT NULL,
  `TacGia` varchar(45) DEFAULT NULL,
  `NamXuatBan` int(11) DEFAULT NULL,
  `TheLoai` varchar(45) DEFAULT NULL,
  `Gia` int(11) DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaSoSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('00001','Cấu trúc dữ liệu và thuật toán','Bách Khoa','Nguyễn Đức Nghĩa',2000,'Công nghệ thông tin',25000,0),('00003','Toán cao cấp','Bách Khoa','Nguyễn Quang Thảo',2000,'Toán học',150000,1),('00005','Lập trình hướng đối tượng','Bách Khoa','Trịnh Thành Trung',2000,'Công nghệ thông tin',55000,1),('22222','Toán 12','Giáo Dục','Phạm Hải Linh',1996,'Toán học',15000,1),('33333','Âm nhạc 9','Giáo Dục','Tùng Sơn',2005,'Nghệ thuật',10000,1),('asss','Cấu trúc dữ liệu và thuật toán','Bách Khoa','Nguyễn Đức Nghĩa',2000,'Công nghệ thông tin',25000,1),('ctd2','Cấu trúc dữ liệu và thuật toán','Bách Khoa','Nguyễn Đức Nghĩa',2000,'Công nghệ thông tin',25000,1),('ctdl2','Cấu trúc dữ liệu và thuật toán','Bách Khoa','Nguyễn Đức Nghĩa',2000,'Công nghệ thông tin',25000,1),('vh12','Văn học 12','Giáo Dục','Phạm Hải Linh',2000,'Xã hội',50000,1),('vh13','Văn học 12','Giáo Dục','Phạm Hải Linh',2000,'Xã hội',50000,1),('﻿11111','Văn học 12','Giáo Dục','Phạm Hải Linh',2000,'Xã hội',50000,1);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-03 16:16:25
