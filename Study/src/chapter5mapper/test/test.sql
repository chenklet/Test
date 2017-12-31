-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssmstudy
-- ------------------------------------------------------
-- Server version	5.7.18-enterprise-commercial-advanced-log

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
-- Table structure for table `t_employee`
--

DROP TABLE IF EXISTS `t_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employee` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(60) NOT NULL,
  `sex` int(2) NOT NULL COMMENT '1 - 男 0 - 女',
  `birthday` date NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `position` varchar(20) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=457 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee`
--

LOCK TABLES `t_employee` WRITE;
/*!40000 ALTER TABLE `t_employee` DISABLE KEYS */;
INSERT INTO `t_employee` VALUES (123,'wqh',1,'1993-01-09','12345678565','123@qq.com','GZ','owner'),(456,'test',2,'1995-12-02','123456666666','456@qq.com','GZ','testppl');
/*!40000 ALTER TABLE `t_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_employee_task`
--

DROP TABLE IF EXISTS `t_employee_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employee_task` (
  `id` int(12) NOT NULL,
  `emp_id` int(12) NOT NULL,
  `task_id` int(12) NOT NULL,
  `task_name` varchar(60) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4_idx` (`emp_id`),
  KEY `FK_Reference_5_idx` (`task_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`task_id`) REFERENCES `t_task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee_task`
--

LOCK TABLES `t_employee_task` WRITE;
/*!40000 ALTER TABLE `t_employee_task` DISABLE KEYS */;
INSERT INTO `t_employee_task` VALUES (2,123,23,'testing','emp_task');
/*!40000 ALTER TABLE `t_employee_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_female_health_form`
--

DROP TABLE IF EXISTS `t_female_health_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_female_health_form` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `heart` varchar(64) NOT NULL,
  `liver` varchar(64) NOT NULL,
  `spleen` varchar(64) NOT NULL,
  `lung` varchar(64) NOT NULL,
  `kidney` varchar(64) NOT NULL,
  `uterus` varchar(64) NOT NULL,
  `note` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_6_idx` (`emp_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_female_health_form`
--

LOCK TABLES `t_female_health_form` WRITE;
/*!40000 ALTER TABLE `t_female_health_form` DISABLE KEYS */;
INSERT INTO `t_female_health_form` VALUES (2,456,'normal','good','normal','not bad','great','normal','female');
/*!40000 ALTER TABLE `t_female_health_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_male_health_form`
--

DROP TABLE IF EXISTS `t_male_health_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_male_health_form` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `heart` varchar(64) NOT NULL,
  `liver` varchar(64) NOT NULL,
  `spleen` varchar(64) NOT NULL,
  `lung` varchar(64) NOT NULL,
  `kidney` varchar(64) NOT NULL,
  `prostate` varchar(64) NOT NULL,
  `note` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7_idx` (`emp_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_male_health_form`
--

LOCK TABLES `t_male_health_form` WRITE;
/*!40000 ALTER TABLE `t_male_health_form` DISABLE KEYS */;
INSERT INTO `t_male_health_form` VALUES (3,123,'normal','good','normal','not bad','great','great','health');
/*!40000 ALTER TABLE `t_male_health_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_task`
--

DROP TABLE IF EXISTS `t_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_task` (
  `id` int(12) NOT NULL,
  `title` varchar(60) NOT NULL,
  `context` varchar(256) NOT NULL,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_task`
--

LOCK TABLES `t_task` WRITE;
/*!40000 ALTER TABLE `t_task` DISABLE KEYS */;
INSERT INTO `t_task` VALUES (23,'developer','study and test','task');
/*!40000 ALTER TABLE `t_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_work_card`
--

DROP TABLE IF EXISTS `t_work_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_work_card` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `emp_id` int(12) NOT NULL,
  `real_name` varchar(60) NOT NULL,
  `department` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `position` varchar(30) NOT NULL,
  `note` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_8_idx` (`emp_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_work_card`
--

LOCK TABLES `t_work_card` WRITE;
/*!40000 ALTER TABLE `t_work_card` DISABLE KEYS */;
INSERT INTO `t_work_card` VALUES (1,123,'wqh','payment service','12343245555','TKH','work_card');
/*!40000 ALTER TABLE `t_work_card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31 15:31:17
