LOCK TABLES `property_type` WRITE;
/*!40000 ALTER TABLE `property_type` DISABLE KEYS */;
INSERT INTO `property_type` VALUES
(1,'EDP Collection',NULL,4,4,NULL,NULL),
(2,'QA Level','',2,NULL,'D',NULL),
(3,'QA Inspection Template','Inspection Procedure Document',2,NULL,NULL,NULL),
(4,'QA Inspection Report','Inspection Result Document',2,NULL,NULL,NULL),
(5,'Electrical Equipment Status','NRTL Approved or APS Inspection Required or Not Required',2,NULL,NULL,NULL),
(6,'Electrical Inspection #','Inspection # from DEEI (use desc of Status?)',2,NULL,NULL,NULL),
(7,'Documentation URI','',4,3,NULL,NULL),
(8,'Form Factor','',3,NULL,NULL,NULL),
(9,'Slot Length','',3,NULL,NULL,NULL),
(10,'Required Water Flow',NULL,3,NULL,NULL,NULL),
(11,'WBS','',1,NULL,NULL,NULL),
(12,'Traveler Template',NULL,2,5,NULL,NULL),
(13,'Traveler Instance',NULL,2,5,NULL,NULL),
(14,'Image',NULL,4,2,NULL,NULL),
(15,'Document',NULL,4,1,NULL,NULL),
(16,'ICMS Document/Drawing',NULL,4,5,NULL,NULL),
(17,'PDMLink Drawing',NULL,4,6,NULL,NULL),
(18,'AMOS Order',NULL,4,7,NULL,NULL),
(19,'Purchase Requisition',NULL,4,8,NULL,NULL),
(20,'Cost',NULL,4,9,NULL,NULL),
(21,'QA Inspection Complete','',2,10,'false',NULL),
(22,'Pressure System Component','',2,10,NULL,NULL),
(23,'Custodian','',NULL,NULL,NULL,NULL),
(24,'Date of Manufacture','',5,11,NULL,NULL),
(25,'Date In Service','',5,11,NULL,NULL),
(26,'Date Next Maintenance Due','',5,11,NULL,NULL),
(27,'Maintenance Record Template','',5,5,NULL,NULL),
(28,'Maintenance Record','',5,5,NULL,NULL),
(29,'Fiducialization Record Template','',5,5,NULL,NULL),
(30,'Fiducialization Record','',5,5,NULL,NULL),
(31,'Alignment Record Template','',5,5,NULL,NULL),
(32,'Alignment Record','',5,5,NULL,NULL),
(33,'Design Status','',6,NULL,NULL,NULL),
(34,'Component Instance Status','',6,NULL,NULL,NULL),
(35,'Length','',3,NULL,NULL,NULL);
/*!40000 ALTER TABLE `property_type` ENABLE KEYS */;
UNLOCK TABLES;
