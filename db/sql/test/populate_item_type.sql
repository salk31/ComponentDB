LOCK TABLES `item_type` WRITE;
SET SESSION FOREIGN_KEY_CHECKS=0;
/*!40000 ALTER TABLE `item_type` DISABLE KEYS */;
INSERT INTO `item_type` VALUES
(1,'Building',NULL,1),
(2,'Area',NULL,1),
(3,'Room',NULL,1),
(4,'Table',NULL,1),
(5,'Cabinet',NULL,1),
(6,'Rack',NULL,1),
(7,'Shelf',NULL,1),
(8,'Vacuum Gate Valve','',2),
(9,'Vacuum Chamber','',2),
(10,'BPM',NULL,2),
(11,'Absorber',NULL,2),
(12,'Assembly',NULL,2),
(13,'Vacuum Pump',NULL,2),
(14,'Gauge/Sensor - RGA',NULL,2),
(15,'Controller - Ion Pump',NULL,2),
(16,'Cable','',2),
(17,'Controller - Vacuum Gauge',NULL,2),
(18,'Rack','',2),
(19,'Cabinet',NULL,2),
(20,'Enclosure',NULL,2),
(21,'Card Cage','',2),
(22,'Controller - Generic',NULL,2),
(23,'Controller - Gate Valve',NULL,2),
(24,'Controller - Heat tape',NULL,2),
(25,'Controller - PID',NULL,2),
(26,'Controller - Temperature',NULL,2),
(27,'Controller - Motor','',2),
(28,'Controller - Power Supply',NULL,2),
(29,'PLC','',2),
(30,'Controller - Water flow',NULL,2),
(31,'Controller - RGA',NULL,2),
(32,'Monitoring System',NULL,2),
(33,'Gauge/Sensor - strain',NULL,2),
(34,'Gauge/Sensor  - vacuum',NULL,2),
(35,'Gauge/Sensor  - thermocouple',NULL,2),
(36,'Gauge/Sensor  - RTD',NULL,2),
(37,'Gauge/Sensor  - pressure',NULL,2),
(38,'Gauge/Sensor - waterflow',NULL,2),
(39,'Motor','',2),
(40,'Motor - Driver','',2),
(41,'Motor - Position Monitor',NULL,2),
(42,'Motor - Limit Switch',NULL,2),
(43,'Patch Panel',NULL,2),
(44,'Adapter',NULL,2),
(45,'Module',NULL,2),
(46,'Blackbox',NULL,2),
(47,'ADC',NULL,2),
(48,'DAC',NULL,2),
(49,'Discrete I/O',NULL,2),
(50,'CPU',NULL,2),
(51,'FPGA',NULL,2),
(52,'Oscilloscope/DSA',NULL,2),
(53,'Counter',NULL,2),
(54,'Function Generator',NULL,2),
(55,'Frequency Synthesizer',NULL,2),
(56,'Voltmeter','',2),
(57,'Power Supply','',2),
(58,'Amplifier','',2),
(59,'Multiplexor',NULL,2),
(60,'Interlock',NULL,2),
(61,'Readout/Display',NULL,2),
(62,'Controls Component',NULL,2),
(63,'Network',NULL,2),
(64,'Timing',NULL,2),
(65,'IOC',NULL,2),
(66,'Computer - Server/Workstation',NULL,2),
(67,'Video',NULL,2),
(68,'Interface Adapter',NULL,2),
(69,'Accelerator Component','',2),
(70,'Girder','',2),
(71,'Stand',NULL,2),
(72,'Transition Piece','',2),
(73,'Heat Tape',NULL,2),
(74,'Flag',NULL,2),
(75,'Scraper',NULL,2),
(76,'Bellows','',2),
(77,'Vacuum Flange',NULL,2),
(78,'Vacuum Seal',NULL,2),
(79,'Fastener',NULL,2),
(80,'Water line',NULL,2),
(82,'Water seal',NULL,2),
(83,'Magnet','',2),
(84,'Trim',NULL,2),
(85,'Dipole',NULL,2),
(86,'Quadrupole',NULL,2),
(87,'Sextupole',NULL,2),
(88,'PS Component',NULL,2),
(89,'Diagnostic Component',NULL,2),
(90,'Loss Monitor',NULL,2),
(91,'Current Monitor',NULL,2),
(92,'Flourescent Screen','',2),
(93,'Optics',NULL,2),
(94,'RF Component',NULL,2),
(95,'Cavity/accelerating structure',NULL,2),
(96,'Phase shifter',NULL,2),
(97,'Attenuator','',2),
(98,'coupler',NULL,2),
(99,'Envelope detector',NULL,2),
(100,'Phase monitor/detector',NULL,2),
(101,'Klystron',NULL,2),
(102,'HVPS',NULL,2),
(103,'Splitter',NULL,2),
(104,'RF Source',NULL,2),
(105,'Circulator',NULL,2),
(106,'Beamline Component','',2),
(107,'Insertion Device Component',NULL,2),
(108,'Plate','',2),
(109,'CSBEND',NULL,2),
(110,'KQUAD','',2),
(111,'KSEXT','',2),
(112,'MONI','',2),
(113,'VERTEX-POINT',NULL,2),
(114,'Computer - Laptop/Tablet',NULL,2),
(115,'High Voltage Pulser',NULL,2),
(116,'High Voltage Attenuator',NULL,2),
(117,'Plinth','',2),
(118,'Flash Disk',NULL,2),
(119,'BPM Processor','Takes BPM signals, converts to X/Y/Sum',2),
(120,'Instrument','',2),
(121,'MARK','',2),
(122,'Fan','',2),
(123,'Fanout',NULL,2),
(124,'Data Logging System',NULL,2),
(125,'Measurement System',NULL,2),
(126,'Gateway/Protocol Converter',NULL,2),
(127,'Current Transformer',NULL,2),
(128,'Support',NULL,2),
(129,'Signal Converter',NULL,2),
(130,'Overhaul Kit',NULL,2),
(131,'Actuator',NULL,2),
(132,'Frontend Component',NULL,2),
(133,'Test Stand','',2),
(134,'Shielding','',2),
(135,'Waveguide','',2),
(136,'LLRF','',2),
(137,'Modulator','',2),
(138,'Photon Monitor','',2),
(139,'Tune Measurement','',2),
(140,'Beam Loss Monitor','',2),
(141,'Water Hose','',2),
(143,'Roughing System','',2),
(144,'Undulator - Planar','',2),
(145,'Wiggler','',2),
(146,'Undulator - Super-Conducting (SCU)','',2),
(147,'Undulator - Variable Period','',2),
(148,'Undulator - Revolver','',2),
(149,'Undulator - Circularly Polarized (CPU)','',2),
(150,'Undulator - Horizontal-Gap Vertically-Polarized (HGVPU)','',2),
(151,'Undulator Canting Magnet','',2),
(152,'Mask','',2),
(153,'Collimator','',2),
(154,'Photon Shutter','',2),
(155,'Safety Shutter','',2),
(156,'RF Window','',2),
(157,'Window','',2),
(158,'Filter','',2),
(159,'Slit','',2),
(160,'Monochromator','',2),
(161,'Mirror','',2),
(162,'DSP','',2),
(163,'PS_CAB',NULL,1),
(164,'Q-bend','',2),
(165,'R-Bend','',2),
(166,'Corrector','',2),
(167,'Vacuum Isolation Valve','',2),
(168,'Gauge/Sensor - Temperature','',2),
(169,'Gauge/Sensor - Vacuum Pressure','',2),
(170,'Gauge/Sensor – Water Flow Rate','',2),
(171,'Table','',2),
(172,'Test Equipment','',2),
(173,'Vac Chamber','',2),
(174,'EAA Top Level','',2),
(175,'Quad Doublet Assembly','',2),
(176,'Beryllium Window','',2),
(177,'Vacuum Tube','',2),
(178,'Diagnostic','',2),
(179,'Printer','',2),
(180,'IP Mezzanine','',2),
(181,'Subnet','',2),
(182,'Transition','',2),
(183,'Relay','',2),
(184,'Motor - Transition','',2),
(185,'Cavity Tuner Systems','components associated with rf cavity tuner mechanical and electrical systems',2),
(187,'Template','',2),
(188,'Critical Spare','This catalog item requires critical spares to be available',2),
(189,'Support Assembly','',2),
(190,'Gap Separation Mechanism','Gap control for Insertion Devices',2),
(191,'FPGA Mezzanine Card','VadaTech FPGA mezzanine card',2),
(192,'MicroTCA Carrier Hub (MCH)','MicroTCA Carrier Hub (MCH)',2),
(193,'All ID Types','',2),
(194,'Crate','Shipping container',2),
(195,'PSS','Personnel Safety System',2),
(196,'ACIS','Access Control Interlock System',2),
(197,'Cryo Systems','',2),
(198,'Calibrated M&TE','This function is applied when sone inventroy items need their calibration checked',2),
(199,'Keeper','',2),
(200,'Pole','',2),
(201,'Strongback','',2),
(202,'Magnetic Structures','',2),
(203,'Scanner','Bar code / QR code scanner',2),
(204,'CDB Equipment','Devices recommended for CDB / eTraveler ',2),
(205,'Assembled Undulator','',2),
(206,'Wafer','',2),
(208,'App Type 1','',10),
(209,'App Type 2','',10);
/*!40000 ALTER TABLE `item_type` ENABLE KEYS */;
UNLOCK TABLES;
