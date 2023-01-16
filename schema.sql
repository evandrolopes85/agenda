-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: db_agenda
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_agendamento`
--

DROP TABLE IF EXISTS `tbl_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_agendamento` (
  `id_agendamento` int NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `hora_inicio` time NOT NULL,
  `hora_final` time NOT NULL,
  `tbl_profissional_id_profissional` int NOT NULL,
  `tbl_servico_id_servico` int NOT NULL,
  `tbl_cliente_id_cliente` int NOT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `fk_tbl_horario_marcado_tbl_profissional_idx` (`tbl_profissional_id_profissional`),
  KEY `fk_tbl_horario_marcado_tbl_servico1_idx` (`tbl_servico_id_servico`),
  KEY `fk_tbl_agendamento_tbl_cliente1_idx` (`tbl_cliente_id_cliente`),
  CONSTRAINT `fk_tbl_agendamento_tbl_cliente1` FOREIGN KEY (`tbl_cliente_id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`),
  CONSTRAINT `fk_tbl_horario_marcado_tbl_profissional` FOREIGN KEY (`tbl_profissional_id_profissional`) REFERENCES `tbl_profissional` (`id_profissional`),
  CONSTRAINT `fk_tbl_horario_marcado_tbl_servico1` FOREIGN KEY (`tbl_servico_id_servico`) REFERENCES `tbl_servico` (`id_servico`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_cliente`
--

DROP TABLE IF EXISTS `tbl_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_profissiona_servico`
--

DROP TABLE IF EXISTS `tbl_profissiona_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_profissiona_servico` (
  `tbl_profissional_id_profissional` int NOT NULL,
  `tbl_servico_id_servico` int NOT NULL,
  PRIMARY KEY (`tbl_profissional_id_profissional`,`tbl_servico_id_servico`),
  KEY `fk_tbl_profissiona_servico_tbl_profissional1_idx` (`tbl_profissional_id_profissional`),
  KEY `fk_tbl_profissiona_servico_tbl_servico1_idx` (`tbl_servico_id_servico`),
  CONSTRAINT `fk_tbl_profissiona_servico_tbl_profissional1` FOREIGN KEY (`tbl_profissional_id_profissional`) REFERENCES `tbl_profissional` (`id_profissional`),
  CONSTRAINT `fk_tbl_profissiona_servico_tbl_servico1` FOREIGN KEY (`tbl_servico_id_servico`) REFERENCES `tbl_servico` (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_profissional`
--

DROP TABLE IF EXISTS `tbl_profissional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_profissional` (
  `id_profissional` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `profissao` varchar(100) NOT NULL,
  PRIMARY KEY (`id_profissional`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_servico`
--

DROP TABLE IF EXISTS `tbl_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_servico` (
  `id_servico` int NOT NULL AUTO_INCREMENT,
  `servico` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id_servico`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-15 21:16:51
