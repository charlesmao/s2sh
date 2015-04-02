 CREATE TABLE `user` (

 `id` int(11) NOT NULL AUTO_INCREMENT,

 `user_name` varchar(20) DEFAULT NULL,

 `password` varchar(20) DEFAULT NULL,

 `address` varchar(100) DEFAULT NULL,

 `phone_number` varchar(20) DEFAULT NULL,

 `create_time` datetime DEFAULT NULL,

 `update_time` datetime DEFAULT NULL,

 PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULTCHARSET=utf8;



INSERT INTO `user` VALUES ('1', 'test','test', 'test', 'test', '2014-03-29 00:48:14', '2014-03-29 00:48:17');