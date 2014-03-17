--
-- Table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `middle_name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_ukey` (`username`),
  UNIQUE KEY `user_name_ukey` (`first_name`, `last_name`, `middle_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table `group`
--

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name_ukey` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table `user_group`
--

DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_group_ukey` (`user_id`, `group_id`),
  KEY `user_group_user_id_fkey` (`user_id`),
  CONSTRAINT `user_group_user_id_fkey` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  KEY `user_group_group_id_fkey` (`group_id`),
  CONSTRAINT `user_group_group_id_fkey` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table `log`
--

CREATE TABLE `log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `created_on_date_time` datetime DEFAULT NOT NULL,
  `created_by_user_id` int(11) DEFAULT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `log_created_by_user_id_fkey` (`created_by_user_id`),
  CONSTRAINT `log_created_by_user_id_fkey` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
