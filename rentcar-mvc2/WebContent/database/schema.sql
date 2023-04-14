CREATE DATABASE mvc2_rentcar;
USE mvc2_rentcar;

-- 회원정보 
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(40) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `zonecode` varchar(5) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `sub_address` varchar(100) DEFAULT NULL,
  `type` char(1) DEFAULT '1',
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `phone` (`phone`)
);

ALTER TABLE `client` AUTO_INCREMENT=1001;

-- 지점정보
CREATE TABLE `venue` (
  `venue_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `zonecode` varchar(5) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `sub_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`venue_id`)
);

-- 차량정보 
CREATE TABLE `vehicle` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `hour_rate` int NOT NULL,
  `venue_id` int NOT NULL,
  `image_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `venue_id` (`venue_id`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`venue_id`)
);

-- 예약정보 
CREATE TABLE `booking` (
  `vehicle_id` int NOT NULL,
  `client_id` int NOT NULL,
  `venue_id` int NOT NULL,
  `date` timestamp NOT NULL,
  `hour` int NOT NULL,
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`vehicle_id`,`client_id`,`venue_id`),
  KEY `booking_ibfk_3` (`venue_id`),
  KEY `booking_ibfk_2` (`client_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`venue_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 게시글정보
CREATE TABLE `board` (
  `board_id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `client_name` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `contents` varchar(4000) NOT NULL,
  `image` blob,
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` char(1) DEFAULT '1',
  `vehicle_id` int DEFAULT NULL,
  PRIMARY KEY (`board_id`),
  KEY `board_ibfk_1` (`client_id`),
  KEY `board_ibfk_2` (`vehicle_id`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `board_ibfk_2` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 키 
CREATE TABLE `key` (
  `client_id` int NOT NULL,
  `client_key` varchar(100) NOT NULL,
  CONSTRAINT `key_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
);