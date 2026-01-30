-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: digital_wallet_db
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `card_number` varchar(16) NOT NULL,
  `card_type` varchar(10) NOT NULL,
  `expiry_date` date DEFAULT NULL,
  `issued_at` datetime(6) NOT NULL,
  `status` varchar(20) NOT NULL,
  `wallet_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKby1nk98m2hq5onhl68bo09sc1` (`card_number`),
  KEY `FKimankogjrf9gnaj13v65xabqy` (`wallet_id`),
  CONSTRAINT `FKimankogjrf9gnaj13v65xabqy` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `active` tinyint(1) DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Food','EXPENSE',1,'2026-01-28 08:33:46'),(2,'Travel','EXPENSE',1,'2026-01-28 08:33:46'),(3,'Bills','EXPENSE',1,'2026-01-28 08:33:46'),(4,'Medical','EXPENSE',1,'2026-01-28 08:33:46'),(5,'Education','EXPENSE',1,'2026-01-28 08:33:46'),(6,'Investment','EXPENSE',1,'2026-01-28 08:33:46'),(7,'Salary','INCOME',1,'2026-01-28 08:33:46'),(8,'Refund','INCOME',1,'2026-01-28 08:33:46'),(9,'Interest','INCOME',1,'2026-01-28 08:33:46'),(10,'Gift','INCOME',1,'2026-01-28 08:33:46');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards_point`
--

DROP TABLE IF EXISTS `rewards_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards_point` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `points` int NOT NULL,
  `update_at` datetime(6) DEFAULT NULL,
  `wallet_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6r5kv8658xw162nydkloqse4t` (`wallet_id`),
  CONSTRAINT `FK6r5kv8658xw162nydkloqse4t` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards_point`
--

LOCK TABLES `rewards_point` WRITE;
/*!40000 ALTER TABLE `rewards_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `rewards_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'chirag','Chirag Tank','chirag@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(2,'admin','System Admin','admin@example.com','ADMIN','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(3,'amit','Amit Sharma','amit@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(4,'neha','Neha Verma','neha@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(5,'rahul','Rahul Mehta','rahul@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(6,'priya','Priya Singh','priya@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(7,'suresh','Suresh Iyer','suresh@example.com','USER','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(8,'xy','xyz','xyz@gmail.com','User','Active','2026-01-30 04:21:28','2026-01-30 04:21:28');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `balance` decimal(15,2) DEFAULT '0.00',
  `currency` varchar(10) DEFAULT 'INR',
  `status` varchar(20) DEFAULT 'ACTIVE',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_wallet_user` (`user_id`),
  UNIQUE KEY `UKhgee4p1hiwadqinr0avxlq4eb` (`user_id`),
  CONSTRAINT `fk_wallet_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,1,15000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(2,2,12000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(3,3,18000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(4,4,9000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(5,5,20000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(6,6,11000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46'),(7,7,14000.00,'INR','ACTIVE','2026-01-28 08:33:46','2026-01-28 08:33:46');
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet_transaction`
--

DROP TABLE IF EXISTS `wallet_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet_transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `wallet_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `amount` double DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `reference_id` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_tx_wallet` (`wallet_id`),
  KEY `fk_tx_category` (`category_id`),
  CONSTRAINT `fk_tx_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_tx_wallet` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `chk_tx_type` CHECK ((`transaction_type` in (_utf8mb4'CREDIT',_utf8mb4'DEBIT')))
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet_transaction`
--

LOCK TABLES `wallet_transaction` WRITE;
/*!40000 ALTER TABLE `wallet_transaction` DISABLE KEYS */;
INSERT INTO `wallet_transaction` VALUES (1,1,7,50000,'CREDIT','Monthly Salary','SAL-001','2026-01-28 08:33:46'),(2,1,1,800,'DEBIT','Grocery Shopping','TXN-002','2026-01-28 08:33:46'),(3,1,2,1200,'DEBIT','Cab Charges','TXN-003','2026-01-28 08:33:46'),(4,1,9,1100,'CREDIT','Savings Interest','INT-004','2026-01-28 08:33:46'),(5,1,6,8000,'DEBIT','Mutual Fund SIP','TXN-005','2026-01-28 08:33:46'),(6,1,8,2000,'CREDIT','Refund Received','REF-006','2026-01-28 08:33:46'),(7,1,4,2500,'DEBIT','Medical Bill','TXN-007','2026-01-28 08:33:46'),(8,2,7,42000,'CREDIT','Monthly Salary','SAL-008','2026-01-28 08:33:46'),(9,2,1,900,'DEBIT','Daily Groceries','TXN-009','2026-01-28 08:33:46'),(10,2,3,3000,'DEBIT','Electricity Bill','TXN-010','2026-01-28 08:33:46'),(11,2,9,950,'CREDIT','Interest Credit','INT-011','2026-01-28 08:33:46'),(12,2,2,1800,'DEBIT','Train Travel','TXN-012','2026-01-28 08:33:46'),(13,2,8,1500,'CREDIT','Refund Credit','REF-013','2026-01-28 08:33:46'),(14,2,6,7000,'DEBIT','Stock Investment','TXN-014','2026-01-28 08:33:46'),(15,3,7,55000,'CREDIT','Monthly Salary','SAL-015','2026-01-28 08:33:46'),(16,3,1,1200,'DEBIT','Food Expense','TXN-016','2026-01-28 08:33:46'),(17,3,5,9000,'DEBIT','Course Fees','TXN-017','2026-01-28 08:33:46'),(18,3,9,1300,'CREDIT','Interest Earned','INT-018','2026-01-28 08:33:46'),(19,3,2,2200,'DEBIT','Flight Ticket','TXN-019','2026-01-28 08:33:46'),(20,3,8,1800,'CREDIT','Refund Received','REF-020','2026-01-28 08:33:46'),(21,3,6,10000,'DEBIT','Equity Investment','TXN-021','2026-01-28 08:33:46'),(22,4,7,38000,'CREDIT','Monthly Salary','SAL-022','2026-01-28 08:33:46'),(23,4,1,700,'DEBIT','Vegetable Purchase','TXN-023','2026-01-28 08:33:46'),(24,4,3,2600,'DEBIT','Water Bill','TXN-024','2026-01-28 08:33:46'),(25,4,9,850,'CREDIT','Interest Credit','INT-025','2026-01-28 08:33:46'),(26,4,2,1600,'DEBIT','Bus Travel','TXN-026','2026-01-28 08:33:46'),(27,4,8,1200,'CREDIT','Refund Credit','REF-027','2026-01-28 08:33:46'),(28,4,4,2800,'DEBIT','Doctor Visit','TXN-028','2026-01-28 08:33:46'),(29,5,7,60000,'CREDIT','Monthly Salary','SAL-029','2026-01-28 08:33:46'),(30,5,1,1500,'DEBIT','Supermarket Shopping','TXN-030','2026-01-28 08:33:46'),(31,5,2,2400,'DEBIT','Cab Booking','TXN-031','2026-01-28 08:33:46'),(32,5,9,1400,'CREDIT','Interest Earned','INT-032','2026-01-28 08:33:46'),(33,5,6,12000,'DEBIT','Mutual Fund Investment','TXN-033','2026-01-28 08:33:46'),(34,5,8,2200,'CREDIT','Refund Received','REF-034','2026-01-28 08:33:46'),(35,5,10,3000,'CREDIT','Gift Received','GFT-035','2026-01-28 08:33:46'),(36,6,7,45000,'CREDIT','Monthly Salary','SAL-036','2026-01-28 08:33:46'),(37,6,1,950,'DEBIT','Groceries','TXN-037','2026-01-28 08:33:46'),(38,6,3,2800,'DEBIT','Internet Bill','TXN-038','2026-01-28 08:33:46'),(39,6,9,1000,'CREDIT','Interest Credit','INT-039','2026-01-28 08:33:46'),(40,6,2,1900,'DEBIT','Office Commute','TXN-040','2026-01-28 08:33:46'),(41,6,8,1700,'CREDIT','Refund Credit','REF-041','2026-01-28 08:33:46'),(42,6,5,8000,'DEBIT','Exam Fees','TXN-042','2026-01-28 08:33:46'),(43,7,7,50000,'CREDIT','Monthly Salary','SAL-043','2026-01-28 08:33:46'),(44,7,1,1100,'DEBIT','Daily Food','TXN-044','2026-01-28 08:33:46'),(45,7,2,2100,'DEBIT','Taxi Charges','TXN-045','2026-01-28 08:33:46'),(46,7,9,1200,'CREDIT','Interest Earned','INT-046','2026-01-28 08:33:46'),(47,7,6,9000,'DEBIT','Investment Payment','TXN-047','2026-01-28 08:33:46'),(48,7,8,1600,'CREDIT','Refund Received','REF-048','2026-01-28 08:33:46'),(49,7,4,2600,'DEBIT','Medical Expense','TXN-049','2026-01-28 08:33:46'),(50,7,10,3500,'CREDIT','Gift Credit','GFT-050','2026-01-28 08:33:46');
/*!40000 ALTER TABLE `wallet_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'digital_wallet_db'
--

--
-- Dumping routines for database 'digital_wallet_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-30  7:59:59
