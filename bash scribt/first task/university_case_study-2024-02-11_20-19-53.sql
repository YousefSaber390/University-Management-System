-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: university_case_study
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  `course_description` varchar(150) DEFAULT NULL,
  `credit_hours` varchar(45) DEFAULT NULL,
  `instractor_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `instractor_id_idx` (`instractor_id`),
  CONSTRAINT `instractor_id` FOREIGN KEY (`instractor_id`) REFERENCES `instractor` (`instractor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Introduction to Programming','This course introduces basic programming concepts using a high-level language like Python or Java.','3',1),(2,'Electrical Circuits','Fundamental concepts of electrical circuits, including Ohm\'s law and circuit analysis techniques.','4',2),(3,'Mechanical Design','Introduction to mechanical design principles, including statics, dynamics, and material properties.','4',3),(4,'Biology 101','Introduction to biology covering cellular biology, genetics, and evolutionary biology.','3',4),(5,'General Chemistry','Basic principles of chemistry including atomic structure, chemical bonding, and stoichiometry.','4',5),(6,'Classical Mechanics','Study of classical mechanics, including Newtonian mechanics and conservation laws.','3',6),(7,'Principles of Marketing','Introduction to marketing principles, including market analysis, consumer behavior, and marketing strategies.','3',7),(8,'Introduction to Psychology','Basic concepts in psychology including cognition, learning, and behavior.','3',8),(9,'World History','Survey of world history from ancient civilizations to the present day.','4',9),(10,'English Literature: Shakespeare','Study of selected works by William Shakespeare including plays and sonnets.','3',10);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `departments_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) DEFAULT NULL,
  `department_desc` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`departments_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Computer Science','Department focused on computer programming, algorithms, and software development.'),(2,'Electrical Engineering','Department specializing in electrical systems, circuits, and electronics.'),(3,'Mechanical Engineering','Department focusing on mechanics, materials, and machine design.'),(4,'Biology','Department studying living organisms and their interactions.'),(5,'Chemistry','Department specializing in the study of chemical compounds and reactions.'),(6,'Physics','Department focused on the study of matter, energy, and the fundamental forces of nature.'),(7,'Business Administration','Department covering various aspects of business management and strategy.'),(8,'Psychology','Department studying human behavior and mental processes.'),(9,'History','Department focused on the study of past events, societies, and cultures.'),(10,'English Literature','Department specializing in the study of written works in the English language.');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enroll`
--

DROP TABLE IF EXISTS `enroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enroll` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `course_id_idx` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enroll`
--

LOCK TABLES `enroll` WRITE;
/*!40000 ALTER TABLE `enroll` DISABLE KEYS */;
INSERT INTO `enroll` VALUES (1,1),(4,1),(5,1),(9,1),(10,1),(15,1),(1,2),(5,2),(6,2),(10,2),(11,2),(1,3),(2,3),(6,3),(7,3),(11,3),(12,3),(2,4),(3,4),(7,4),(8,4),(12,4),(13,4),(3,5),(4,5),(8,5),(9,5),(13,5),(14,5),(4,6),(5,6),(9,6),(10,6),(14,6),(15,6),(1,7),(5,7),(6,7),(10,7),(11,7),(15,7),(1,8),(2,8),(6,8),(7,8),(12,8),(1,9),(2,9),(3,9),(7,9),(8,9),(13,9),(3,10),(4,10),(8,10),(9,10),(14,10);
/*!40000 ALTER TABLE `enroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `grade_code` varchar(10) NOT NULL,
  `grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`grade_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES ('A','3.9'),('A-','3.7'),('A+','4'),('B','3'),('B-','2.7'),('B+','3.3'),('C','2'),('C-','1.7'),('C+','2.3'),('D','1'),('D-','0.7'),('D+','1.3'),('F','0');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instractor`
--

DROP TABLE IF EXISTS `instractor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instractor` (
  `instractor_id` int NOT NULL AUTO_INCREMENT,
  `instractor_name` varchar(45) NOT NULL,
  `departments_id` int NOT NULL,
  PRIMARY KEY (`instractor_id`),
  KEY `departments_id_idx` (`departments_id`),
  CONSTRAINT `departments_id` FOREIGN KEY (`departments_id`) REFERENCES `departments` (`departments_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instractor`
--

LOCK TABLES `instractor` WRITE;
/*!40000 ALTER TABLE `instractor` DISABLE KEYS */;
INSERT INTO `instractor` VALUES (1,'John Smith',1),(2,'Emily Johnson',2),(3,'Michael Brown',3),(4,'Sarah Davis',4),(5,'David Wilson',5),(6,'Jennifer Lee',6),(7,'Andrew Miller',7),(8,'Rachel Thompson',8),(9,'Robert Garcia',9),(10,'Laura Martinez',10);
/*!40000 ALTER TABLE `instractor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(45) NOT NULL,
  `l_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `DOB` varchar(30) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `GPA` double DEFAULT NULL,
  `department_id` int NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `ohone_number_UNIQUE` (`phone_number`),
  KEY `department_id_idx` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`departments_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Alice','Johnson','alice.johnson@example.com','2000-05-15','New York','123 Main St','USA',2.92,1,'+1234567890'),(2,'Bob','Smith','bob.smith@example.com','2001-02-20','Los Angeles','456 Elm St','USA',3.21,2,'+1987654321'),(3,'Charlie','Brown','charlie.brown@example.com','1999-11-10','Chicago','789 Oak St','USA',3.39,3,'+1765432109'),(4,'David','Lee','david.lee@example.com','2000-08-25','Houston','234 Pine St','USA',3.54,4,'+1654321098'),(5,'Emma','Garcia','emma.garcia@example.com','2001-04-30','Miami','567 Maple St','USA',1.92,5,'+1543210987'),(6,'Olivia','Martinez','olivia.martinez@example.com','2000-07-12','San Francisco','890 Walnut St','USA',3.42,1,'+1789054321'),(7,'James','Taylor','james.taylor@example.com','2000-09-18','Seattle','901 Cedar St','USA',3.7,2,'+1876543210'),(8,'Sophia','Lopez','sophia.lopez@example.com','2001-01-22','Boston','234 Elm St','USA',2.96,3,'+1765432108'),(9,'Jackson','Hernandez','jackson.hernandez@example.com','2000-03-05','Denver','345 Oak St','USA',2.63,4,'+1664321098'),(10,'Ava','Gonzalez','ava.gonzalez@example.com','2001-06-08','Atlanta','456 Pine St','USA',3.42,5,'+1543210927'),(11,'Liam','Rodriguez','liam.rodriguez@example.com','2000-10-11','Dallas','567 Maple St','USA',3.35,1,'+1237509876'),(12,'Emma','Wang','emma.wang@example.com','2000-12-25','San Diego','678 Oak St','USA',2.57,2,'+1987674321'),(13,'Noah','Nguyen','noah.nguyen@example.com','2001-03-08','Houston','789 Elm St','USA',2.33,3,'+1876843210'),(14,'Isabella','Kim','isabella.kim@example.com','2000-07-19','Chicago','890 Pine St','USA',3.96,4,'+1765436109'),(15,'William','Chen','william.chen@example.com','2001-01-31','Los Angeles','901 Cedar St','USA',2.85,5,'+1684321098'),(16,'ffcv','vb','vev','2024-01-30','llll','hkkj','jk  hhk',0,1,'000');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `grade_code` varchar(10) DEFAULT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`,`date`),
  KEY `grade_code` (`grade_code`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`student_id`, `course_id`) REFERENCES `enroll` (`student_id`, `course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,1,'A','2023-01-15'),(2,3,'A','2023-03-15'),(3,4,'A','2023-09-10'),(4,5,'A','2023-05-01'),(14,6,'A','2023-05-01'),(5,1,'A-','2023-03-05'),(6,2,'A-','2023-09-05'),(9,6,'A-','2023-03-10'),(11,3,'A-','2023-06-20'),(13,4,'A-','2023-03-10'),(6,7,'A+','2023-09-05'),(7,3,'A+','2023-05-05'),(10,1,'A+','2023-05-12'),(14,5,'A+','2023-09-05'),(3,5,'B','2023-04-05'),(10,6,'B','2023-04-05'),(11,2,'B','2023-01-25'),(12,3,'B','2023-07-15'),(15,1,'B','2023-06-25'),(6,3,'B-','2023-04-10'),(8,5,'B-','2023-06-15'),(15,6,'B-','2023-06-15'),(4,1,'B+','2023-02-10'),(4,6,'B+','2023-01-20'),(7,4,'B+','2023-10-25'),(8,4,'B+','2023-01-20'),(10,2,'B+','2023-10-10'),(5,6,'C','2023-02-15'),(9,1,'C','2023-04-20'),(12,4,'C','2023-02-15'),(1,2,'C+','2023-07-18'),(1,3,'C+','2023-02-20'),(1,7,'C+','2023-07-20'),(2,4,'C+','2023-08-30'),(9,5,'C+','2023-07-20'),(5,2,'D','2023-08-30'),(5,7,'D+','2023-08-10'),(13,5,'D+','2023-08-10');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calculate_gpa` AFTER INSERT ON `test` FOR EACH ROW BEGIN
    DECLARE v_total_points DECIMAL(8, 2);
    DECLARE v_total_hours INT;
    DECLARE v_gpa DECIMAL(8, 2);
    
    
    SELECT COALESCE(SUM(Grades.grade * Courses.credit_hours), 0)
    INTO v_total_points
    FROM Test
    INNER JOIN Grades ON Test.grade_code = Grades.grade_code
    INNER JOIN Courses ON Test.course_id = Courses.course_id
    WHERE Test.student_id = NEW.student_id;

    
    SELECT COALESCE(SUM(Courses.credit_hours), 0)
    INTO v_total_hours
    FROM Test
    INNER JOIN Courses ON Test.course_id = Courses.course_id
    WHERE Test.student_id = NEW.student_id;

    
    IF v_total_hours > 0 THEN
        SET v_gpa = v_total_points / v_total_hours;
    ELSE
        SET v_gpa = 0;
    END IF;

    
    UPDATE students
    SET GPA = v_gpa
    WHERE student_id = NEW.student_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-11 20:19:53
