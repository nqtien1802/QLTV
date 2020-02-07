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
-- Table structure for table `chitietmuon`
--

DROP TABLE IF EXISTS `chitietmuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietmuon` (
  `MaSoMuon` char(30) NOT NULL,
  `MaSoSach` char(15) NOT NULL,
  `TrangThai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaSoMuon`,`MaSoSach`),
  KEY `key2_chitietmuon_idx` (`MaSoSach`),
  CONSTRAINT `key2_chitietmuon` FOREIGN KEY (`MaSoSach`) REFERENCES `sach` (`MaSoSach`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `key3_chitietmuon` FOREIGN KEY (`MaSoMuon`) REFERENCES `muontra` (`MaSoMuon`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietmuon`
--

LOCK TABLES `chitietmuon` WRITE;
/*!40000 ALTER TABLE `chitietmuon` DISABLE KEYS */;
INSERT INTO `chitietmuon` VALUES ('MT1477834894','00005','Đã trả'),('MT1477834894','33333','Đã trả'),('MT1477834894','asss','Đã trả'),('MT1477834894','﻿11111','Đã trả'),('MT1477836419','00001','Đang mượn'),('MT1477836419','00003','Đang mượn'),('MT1477836419','00005','Đang mượn'),('MT1477836435','ctd2','Đang mượn'),('MT1477836435','ctdl2','Đang mượn'),('MT1477836435','vh12','Đang mượn'),('MT1477837738','vh13','Đang mượn'),('MT1477861807','ctdl2','Đã trả'),('MT1477861807','vh12','Đã trả'),('MT1477907859','asss','Mất'),('MT1477907859','ctd2','Đã trả'),('MT1477907859','vh12','Đã trả'),('MT1478148337','00003','Đang mượn'),('MT1478148337','22222','Đang mượn'),('MT1478148337','33333','Đang mượn'),('MT1478148616','22222','Đang mượn'),('MT1478148616','asss','Đang mượn');
/*!40000 ALTER TABLE `chitietmuon` ENABLE KEYS */;
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
