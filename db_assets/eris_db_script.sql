CREATE DATABASE  IF NOT EXISTS `eris` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eris`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: eris
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `advice`
--

DROP TABLE IF EXISTS `advice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_id` int(11) NOT NULL,
  `state_event_id` int(11) NOT NULL,
  `message` varchar(500) NOT NULL,
  `is_taken` tinyint(1) NOT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_advice_state1_idx` (`state_id`,`state_event_id`),
  CONSTRAINT `fk_advice_state1` FOREIGN KEY (`state_id`, `state_event_id`) REFERENCES `state` (`id`, `event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advice`
--

LOCK TABLES `advice` WRITE;
/*!40000 ALTER TABLE `advice` DISABLE KEYS */;
/*!40000 ALTER TABLE `advice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appliance`
--

DROP TABLE IF EXISTS `appliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appliance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `appliance_type_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `date_of_purchase` datetime DEFAULT NULL,
  `expected_consumption` double NOT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_appliance_user_idx` (`user_id`),
  KEY `fk_appliance_appliance_type1_idx` (`appliance_type_id`),
  CONSTRAINT `fk_appliance_appliance_type1` FOREIGN KEY (`appliance_type_id`) REFERENCES `appliance_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_appliance_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appliance`
--

LOCK TABLES `appliance` WRITE;
/*!40000 ALTER TABLE `appliance` DISABLE KEYS */;
INSERT INTO `appliance` VALUES (1,1,1,'Washing machine','2011-11-11 00:00:00',0.5,1),(2,1,2,'Dryer','2011-11-11 00:00:00',0.5,1),(3,1,3,'Dishwasher','2011-11-11 00:00:00',0.5,1),(4,1,4,'Hairdryer','2011-11-11 00:00:00',0.5,1),(5,1,5,'Heating','2011-11-11 00:00:00',0.5,1),(6,1,6,'Iron','2011-11-11 00:00:00',0.5,1),(7,1,7,'Lighting','2011-11-11 00:00:00',0.5,1),(8,1,8,'Laptop','2011-11-11 00:00:00',0.5,1),(9,1,9,'TV','2011-11-11 00:00:00',0.5,1),(10,1,10,'Refrigerator ','2011-11-11 00:00:00',0.5,1);
/*!40000 ALTER TABLE `appliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appliance_type`
--

DROP TABLE IF EXISTS `appliance_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appliance_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `average_consumption` double NOT NULL,
  `average_usage` double NOT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appliance_type`
--

LOCK TABLES `appliance_type` WRITE;
/*!40000 ALTER TABLE `appliance_type` DISABLE KEYS */;
INSERT INTO `appliance_type` VALUES (1,'Washing machine',400,4,1),(2,'Dryer',3000,3,1),(3,'Dishwasher',1800,5,1),(4,'Hairdryer',1800,1,1),(5,'Heating',1500,168,1),(6,'Iron',1000,1,1),(7,'Lighting',30,60,1),(8,'Laptop',50,30,1),(9,'TV',200,20,1),(10,'Refrigerator',50,168,1);
/*!40000 ALTER TABLE `appliance_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `appliance_id` int(11) NOT NULL,
  `running_time` double NOT NULL,
  `energy_consumption` double NOT NULL,
  `time` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `activity_level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_event_user1_idx` (`user_id`),
  KEY `fk_event_appliance1_idx` (`appliance_id`),
  CONSTRAINT `fk_event_appliance1` FOREIGN KEY (`appliance_id`) REFERENCES `appliance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,1,1,2,900,'2013-10-02 10:00:00',1,1),(2,1,8,7,400,'2013-10-02 12:00:00',1,1),(3,1,3,2,3300,'2013-10-02 14:00:00',1,1),(4,1,1,2,900,'2013-10-02 16:00:00',1,1),(5,1,10,24,2000,'2013-10-02 21:00:00',1,1),(6,1,3,2,3300,'2013-10-02 23:00:00',1,1);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `activity_level` double NOT NULL,
  `energy_cost` double NOT NULL,
  `satisfaction` double NOT NULL,
  `attitude` double NOT NULL,
  `intention` double NOT NULL,
  `engagement` double NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`event_id`),
  KEY `fk_state_event1_idx` (`event_id`),
  CONSTRAINT `fk_state_event1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `dateCreated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tom Unaware','tom@unaware.com','123456',34,'m','2011-11-10 23:00:00','2011-11-10 23:00:00',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-16 16:52:20
