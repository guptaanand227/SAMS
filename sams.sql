-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.48-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sams
CREATE DATABASE IF NOT EXISTS `sams` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `sams`;

-- Dumping structure for table sams.login
CREATE TABLE IF NOT EXISTS `login` (
  `user_type` varchar(20) COLLATE armscii8_bin NOT NULL,
  `username` varchar(15) COLLATE armscii8_bin NOT NULL,
  `contact_no` varchar(20) COLLATE armscii8_bin DEFAULT NULL,
  `email_id` varchar(450) COLLATE armscii8_bin DEFAULT NULL,
  `firstname` varchar(50) COLLATE armscii8_bin DEFAULT NULL,
  `lastname` varchar(50) COLLATE armscii8_bin DEFAULT NULL,
  `password` longblob,
  PRIMARY KEY (`user_type`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Dumping data for table sams.login: ~2 rows (approximately)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`user_type`, `username`, `contact_no`, `email_id`, `firstname`, `lastname`, `password`) VALUES
	('Admin', 'Arjun227', '9919528643', 'Arjun@gmail.com', 'Arjun', 'Deva', _binary 0x41726A756E40323237),
	('Faculty', 'Jay227', '9919528641', 'jay@gmail.com', 'Jay', 'Kumar', _binary 0x4A617940323237),
	('Faculty', 'Shalani227', '9919528643', 'shalini@gmail.com', 'Shalani', 'Sharma', _binary 0x5368616C616E6940323237),
	('Student', 'Prashant123', '9919528642', 'pk381860@gmail.com', 'Pranav', 'Singh', _binary 0x5061737340323237),
	('Student', 'Prashant227', '8828443340', 'guptaanand227@gmail.com', 'Prashant', 'Kumar', _binary 0x5061737340323237);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table sams.student_assignment
CREATE TABLE IF NOT EXISTS `student_assignment` (
  `task_id` varchar(50) COLLATE armscii8_bin NOT NULL,
  `faculty_username` varchar(100) COLLATE armscii8_bin DEFAULT NULL,
  `task` varchar(1000) COLLATE armscii8_bin DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Dumping data for table sams.student_assignment: ~1 rows (approximately)
/*!40000 ALTER TABLE `student_assignment` DISABLE KEYS */;
INSERT INTO `student_assignment` (`task_id`, `faculty_username`, `task`, `end_date`) VALUES
	('2', 'Jay227', 'Assignment 1', '2020-10-28'),
	('3', 'Jay227', 'Assignment 2', '2020-10-28'),
	('4', 'Jay227', 'Assignment 3', '2020-10-28'),
	('5', 'Jay227', 'Assignment 4', '2020-10-28'),
	('6', 'Jay227', 'Assignment 5', '2020-10-28'),
	('7', 'Jay227', 'Assignment 6', '2020-10-30'),
	('8', 'Jay227', 'Assignment 7', '2020-10-31'),
	('9', 'Jay227', 'Assignment 8', '2020-11-06');
/*!40000 ALTER TABLE `student_assignment` ENABLE KEYS */;

-- Dumping structure for table sams.student_submitted_assignment
CREATE TABLE IF NOT EXISTS `student_submitted_assignment` (
  `stutask_id` varchar(50) COLLATE armscii8_bin NOT NULL,
  `faculty_username` varchar(50) COLLATE armscii8_bin DEFAULT NULL,
  `student_username` varchar(50) COLLATE armscii8_bin DEFAULT NULL,
  `uploaded_file` longblob,
  `task_id` varchar(50) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`stutask_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Dumping data for table sams.student_submitted_assignment: ~1 rows (approximately)
/*!40000 ALTER TABLE `student_submitted_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_submitted_assignment` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
