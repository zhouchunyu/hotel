-- MySQL dump 10.13  Distrib 5.7.21, for osx10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin_z','ROLE_admin'),('ddd','ROLE_user'),('ddd2','user'),('ddd3','user'),('ddd4','user'),('javaboy','ROLE_manager'),('manager_z','ROLE_manager'),('zcy','ROLE_manager');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `businessDistrict` varchar(100) DEFAULT NULL,
  `introduction` longtext,
  `services_and_facilities` longtext,
  `starRating` varchar(10) DEFAULT NULL,
  `src` text,
  `address` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'弘阳广场199','你好','很多','3星','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ftuangou%2F295%2F575%2F390%2Ff43a28f685b5497dae13f4a0bcd4dbd2_720_480_s.jpg&refer=http%3A%2F%2Fimages4.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620051405&t=4169b0736025a2386b61485b5d3b6d65','南京市浦口区'),(2,'aasd','asd','asd','2星','https://colorlib.com/wp/wp-content/uploads/sites/2/rolax-free-template.jpg','das'),(3,'弘阳广场','你好','很多','3星','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ftuangou%2F295%2F575%2F390%2Ff43a28f685b5497dae13f4a0bcd4dbd2_720_480_s.jpg&refer=http%3A%2F%2Fimages4.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620051405&t=4169b0736025a2386b61485b5d3b6d65','南京市浦口区');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checkInTime` datetime DEFAULT NULL,
  `checkoutTime` datetime DEFAULT NULL,
  `roomTypeId` int(11) DEFAULT NULL,
  `roomsCount` int(11) DEFAULT NULL,
  `peopleCount` int(11) DEFAULT NULL,
  `withOrWithoutChildren` tinyint(4) DEFAULT NULL,
  `hotelId` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_hotel__fk` (`hotelId`),
  KEY `order_room_type__fk` (`roomTypeId`),
  KEY `orders_user__fk` (`username`),
  CONSTRAINT `order_hotel__fk` FOREIGN KEY (`hotelId`) REFERENCES `hotel` (`id`),
  CONSTRAINT `order_room_type__fk` FOREIGN KEY (`roomTypeId`) REFERENCES `room_type` (`id`),
  CONSTRAINT `orders_user__fk` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (5,NULL,NULL,1,1,1,1,1,'zcy'),(6,NULL,NULL,2,1,1,1,1,'zcy'),(7,NULL,NULL,1,1,2,1,1,'zcy'),(8,NULL,NULL,2,1,2,1,1,'zcy'),(9,'2021-04-05 13:05:00','2021-04-07 13:05:00',2,1,2,1,1,'zcy');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `src` text,
  PRIMARY KEY (`id`),
  KEY `room_type_hotel__fk` (`hotel_id`),
  CONSTRAINT `room_type_hotel__fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'大',10,100,1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ft1%2Ftuangou%2F156%2F050%2F706%2F25c912723d5a4791b9f5e421e39c1735_720_480.jpg&refer=http%3A%2F%2Fimages4.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619945721&t=888f2133d8fc2c18a8752d45e6913321'),(2,'中',5,50,1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ftuangou%2F982%2F256%2F011%2F2bafe58c96804524b87c0faca1927a76_720_480.jpg&refer=http%3A%2F%2Fimages4.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619945721&t=710b884157dc56d96ee6a76cff2cdce8'),(3,'小',1,10,1,'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ffd%2Ftuangou%2Fg1%2FM02%2FA5%2FF7%2FCghzfFUMV9SAMBLRAAaJwJRLwPY212_720_480_s.jpg&refer=http%3A%2F%2Fimages4.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619945721&t=5662e075fc0134dfb01b4e1ff0fd4d1b');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `nickname` varchar(40) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin_z','123456','123131231',1),(NULL,'ddd','123456',NULL,1),(NULL,'ddd2','123456',NULL,1),(NULL,'ddd3','123456',NULL,1),(NULL,'ddd4','123456',NULL,1),(NULL,'javaboy','123456',NULL,1),('manager_z','manager_z','654321','188888',1),(NULL,'zcy','123456','17777',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-04 22:17:48
