CREATE DATABASE  IF NOT EXISTS `travelguide` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `travelguide`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: travelguide
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contato` (
  `idContato` bigint(20) NOT NULL AUTO_INCREMENT,
  `assunto` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mensagem` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idContato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `idHorario` bigint(20) NOT NULL AUTO_INCREMENT,
  `diaSemana` varchar(255) DEFAULT NULL,
  `horario` time DEFAULT NULL,
  `tempoDePercurso` varchar(255) DEFAULT NULL,
  `idOnibus` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idHorario`),
  KEY `FK_lp4qf9hx6f18mecjyi9x89esj` (`idOnibus`),
  CONSTRAINT `FK_lp4qf9hx6f18mecjyi9x89esj` FOREIGN KEY (`idOnibus`) REFERENCES `onibus` (`idOnibus`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,'Sabado','05:22:00','25',1),(2,'Dias_uteis','05:15:00','17',2),(3,'Dias_uteis','05:30:00','17',3),(4,'Dias_uteis','09:48:00','22',4),(5,'Dias_uteis','10:00:00','22',5),(6,'Dias_uteis','10:30:00','25',6),(7,'Dias_uteis','08:30:00','34',7),(8,'Dias_uteis','09:00:00','34',8),(9,'Dias_uteis','09:30:00','39',9),(10,'Dias_uteis','11:00:00','39',10),(11,'Dias_uteis','10:30:00','51',11),(12,'Dias_uteis','11:30:00','51',12);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onibus`
--

DROP TABLE IF EXISTS `onibus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `onibus` (
  `idOnibus` bigint(20) NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `itinerario` longtext,
  `nomeOnibus` varchar(100) DEFAULT NULL,
  `numeroOnibus` int(11) DEFAULT NULL,
  `observacaoOnibus` varchar(200) DEFAULT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `valorOnibus` double DEFAULT NULL,
  `idTerminalDestino` bigint(20) DEFAULT NULL,
  `idTerminalOrigem` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idOnibus`),
  KEY `FK_rl7fqvd0hg5t2flixyiasn8ai` (`idTerminalDestino`),
  KEY `FK_59pcs0nq7ysxrqd0m4haa2ksg` (`idTerminalOrigem`),
  CONSTRAINT `FK_59pcs0nq7ysxrqd0m4haa2ksg` FOREIGN KEY (`idTerminalOrigem`) REFERENCES `terminal` (`idTerminal`),
  CONSTRAINT `FK_rl7fqvd0hg5t2flixyiasn8ai` FOREIGN KEY (`idTerminalDestino`) REFERENCES `terminal` (`idTerminal`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onibus`
--

LOCK TABLES `onibus` WRITE;
/*!40000 ALTER TABLE `onibus` DISABLE KEYS */;
INSERT INTO `onibus` VALUES (1,'TITRI','AV. PROF. HENRIQUE DA SILVA FONTES\r\nAV. DA SAUDADE\r\nROD. SC 401\r\nVILA IVAN MATOS\r\nR. CEL. LUIZ CALDEIRA\r\nROD. JOÃO PAULO\r\nROD. VIRGÍLIO VÁRZEA (PONTO FINAL)','Saco Grande via João Paulo',174,'','TITRI',3.1,1,1),(2,'TICEN','AV. PROF. HENRIQUE DA SILVA FONTES\r\nAV. GOV. IRINEU BORNHAUSEN\r\nAV. JORN. RUBENS DE ARRUDA RAMOS\r\nAV. OSVALDO RODRIGUES CABRAL\r\nAV. PAULO FONTES\r\nCENTRO\r\nBEIRA MAR','Beira Mar Norte',134,'','TITRI',3.1,2,1),(3,'TITRI','R. ANTÔNIO PEREIRA OLIVEIRA NETO\r\nAV. OSVALDO RODRIGUES CABRAL\r\nAV. JORN. RUBENS DE ARRUDA RAMOS\r\nR. CTE. CONSTANTINO NICOLAU SPYREDES\r\nAV. GOV. IRINEU BORNHAUSEN\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nTRINDADE','Beira Mar Norte',134,'','TICEN',3.1,1,2),(4,'TILAG','AV.PROF. HENRIQUE DA SILVA FONTES\r\nTREVO AGENOR PÓVOAS JÚNIOR\r\nAV.PROF. HENRIQUE DA SILVA FONTES\r\nR.BYRON BARCELOS\r\nR.JOE COLLAÇO\r\nAV.MADRE BENVENUTA\r\nRODOVIA SC 404\r\nAV.AFONSO DELAMBERT\r\nLAGOA DA CONCEIÇÃO\r\nTRINDADE\r\nSANTA MONICA','TITRI/TILAG',333,'','TITRI',3.1,4,1),(5,'TITRI','AV.AFONSO DELAMBERT\r\nRODOVIA SC 404\r\nAV.MADRE BENVENUTA\r\nAV.PROF. HENRIQUE DA SILVA FONTES\r\nLAGOA DA CONCEIÇÃO\r\nSANTA MONICA\r\nTRINDADE','TITRI/TILAG',333,'','TILAG',3.1,1,4),(6,'TILAG','R. PROF. ABELARDO SOUZA (PONTO FINAL)\r\nR. ALTAMIRO BARCELO DUTRA\r\nROD. JORNALISTA MANOEL DE MENEZES\r\nAV. PREF. ACÁCIO GARIBALDI\r\nAV. DAS RENDEIRAS\r\nR. HENRIQUE VERA DO NASCIMENTO\r\nR. MANOEL SEVERINO DE OLIVEIRA\r\nR. MOACYR PEREIRA JUNIOR\r\nAV. AFONSO DELAMBERT NETO\r\nBARRA DA LAGOA\r\nLAGOA DA CONCEICAO','Barra da Lagoa',360,'','TILAG',3.1,4,4),(7,'TISAN','AV. JORNALISTA RUBENS ARRUDA RAMOS / BEIRA-MAR NORTE\r\nAV. GOV. IRINEU BORNHAUSEN / BEIRA-MAR NORTE\r\nTITRI\r\nROD. SC 401\r\n','Santo Antônio via Beira Mar',332,'','TICEN',3.1,3,2),(8,'TICEN','ROD. SC 401\r\nTITRI\r\nAV. GOV. IRINEU BORNHAUSEN / BEIRA-MAR NORTE\r\nAV. JORNALISTA RUBENS ARRUDA RAMOS / BEIRA-MAR NORTE','Santo Antônio via Beira Mar',332,'','TISAN',3.1,2,3),(9,'TICEN','AV. AFONSO DELAMBERT NETO\r\nRODOVIA ADMAR GONZAGA / SC 404\r\nAV. MADRE BENVENUTA\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nTITRI\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nAV. GOV. IRINEU BORNHAUSEN\r\nAV. JORN. RUBENS DE ARRUDA RAMOS\r\nAV. OSVALDO RODRIGUES CABRAL\r\nAV. PAULO FONTES','Lagoa da Conceição - Semidireto',320,'','TILAG',3.1,2,4),(10,'TILAG','R. ANTÔNIO PEREIRA OLIVEIRA NETO\r\nAV. OSVALDO RODRIGUES CABRAL\r\nAV. JORN. RUBENS DE ARRUDA RAMOS\r\nR. CTE. CONSTANTINO NICOLAU SPYRIDES\r\nAV. GOV. IRINEU BORNHAUSEN\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nTITRI\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nTREVO AGENOR PÓVOAS JÚNIOR\r\nAV. PROF. HENRIQUE DA SILVA FONTES\r\nR.BYRON BARCELOS\r\nR.JOE COLLAÇO\r\nAV. MADRE BENVENUTA\r\nRODOVIA ADMAR GONZAGA / SC 404\r\nAV. AFONSO DELAMBERT NETO','Lagoa da Conceição - Semidireto',320,'','TICEN',3.1,4,2),(11,'TICEN','RUA FRANCISCO FAUSTO MARTINS\r\nTRAVESSA OLINDINA VIEIRA DOS SANTOS\r\nRODOVIA SC 403\r\nRODOVIA SC 401\r\nRUA PADRE LOURENÇO RODRIGUES DE ANDRADE\r\nTISAN\r\nRUA PADRE LOURENÇO RODRIGUES DE ANDRADE\r\nRODOVIA SC 401\r\nAVENIDA DA SAUDADE\r\nRUA DELMINDA SILVEIRA\r\nRUA RUI BARBOSA\r\nRUA FREI CANECA\r\nRUA HEITOR LUZ\r\nAVENIDA MAURO RAMOS\r\nRUA SILVA JARDIM\r\nAVENIDA GOVERNADOR GUSTAVO RICHARD','Canasvieiras Mauro Ramos',221,'','TICAN',3.1,2,6),(12,'TICAN','RUA PROCURADOR ABELARDO GOMES\r\nAVENIDA PAULO FONTES\r\nRUA DOUTOR ÁLVARO MILLEN DA SILVEIRA\r\nRUA DOUTOR JORGE DA LUZ FONTES\r\nRUA SILVA JARDIM\r\nAVENIDA MAURO RAMOS\r\nAVENIDA JORNALISTA RUBENS DE ARRUDA RAMOS\r\nRUA COMANDANTE CONSTANTINO NICOLAU SPYRIDES\r\nRUA DELMINDA SILVEIRA\r\nRUA IDALINA PEREIRA DOS SANTOS\r\nAVENIDA GOVERNADOR IRINEU BORNHAUSEN\r\nAVENIDA DA SAUDADE\r\nRODOVIA SC 401\r\nRUA PADRE LOURENÇO RODRIGUES DE ANDRADE\r\nTISAN\r\nRUA PADRE LOURENÇO RODRIGUES DE ANDRADE\r\nRODOVIA SC 401\r\nRUA FRANCISCO FAUSTO MARTINS','Canasvieiras Mauro Ramos',221,'','TICEN',3.1,6,2);
/*!40000 ALTER TABLE `onibus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradas`
--

DROP TABLE IF EXISTS `paradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradas` (
  `idParadas` bigint(20) NOT NULL AUTO_INCREMENT,
  `localizacao` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idParadas`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradas`
--

LOCK TABLES `paradas` WRITE;
/*!40000 ALTER TABLE `paradas` DISABLE KEYS */;
INSERT INTO `paradas` VALUES (1,'João Paulo',1),(2,'Trindade',2),(3,'Centro',3),(4,'Saco Grande',4),(5,'Barra da lagoa',5),(6,'Lagoa da conceição',6),(7,'Canasvieiras',7);
/*!40000 ALTER TABLE `paradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradasonibus`
--

DROP TABLE IF EXISTS `paradasonibus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradasonibus` (
  `idOnibus` bigint(20) NOT NULL,
  `idParadas` bigint(20) NOT NULL,
  KEY `FK_2ht3jkilutgm7qa6q6bbkdmfe` (`idParadas`),
  KEY `FK_e98lka1mt8wk1lj0ysjl4ohgs` (`idOnibus`),
  CONSTRAINT `FK_e98lka1mt8wk1lj0ysjl4ohgs` FOREIGN KEY (`idOnibus`) REFERENCES `onibus` (`idOnibus`),
  CONSTRAINT `FK_2ht3jkilutgm7qa6q6bbkdmfe` FOREIGN KEY (`idParadas`) REFERENCES `paradas` (`idParadas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradasonibus`
--

LOCK TABLES `paradasonibus` WRITE;
/*!40000 ALTER TABLE `paradasonibus` DISABLE KEYS */;
INSERT INTO `paradasonibus` VALUES (1,1),(1,4),(2,3),(3,2),(4,6),(5,2),(6,5),(6,6),(7,3),(8,3),(9,2),(9,3),(10,6),(11,3),(12,7);
/*!40000 ALTER TABLE `paradasonibus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminal`
--

DROP TABLE IF EXISTS `terminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminal` (
  `idTerminal` bigint(20) NOT NULL AUTO_INCREMENT,
  `dominio` varchar(255) DEFAULT NULL,
  `terminal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTerminal`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminal`
--

LOCK TABLES `terminal` WRITE;
/*!40000 ALTER TABLE `terminal` DISABLE KEYS */;
INSERT INTO `terminal` VALUES (1,NULL,'TITRI'),(2,NULL,'TICEN'),(3,NULL,'TISAN'),(4,NULL,'TILAG'),(6,NULL,'TICAN'),(7,NULL,'TIRIO');
/*!40000 ALTER TABLE `terminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `senha` varchar(12) DEFAULT NULL,
  `ativacaoCadastro` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Arthur Jorge','1996-05-08','105.356.456-45','arthursenai@gmail.com','Florianópolis','080596',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'travelguide'
--

--
-- Dumping routines for database 'travelguide'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-05  0:50:04
