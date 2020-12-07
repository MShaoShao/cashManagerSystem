# 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sex` int(2) NOT NULL,
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
	
# 	--订单表
CREATE TABLE `orders` (
  `id` bigint(20) not null AUTO_INCREMENT,
  `create_time` timestamp not null default CURRENT_TIMESTAMP,
  `order_type` bigint(20) not null,
  `unit_price` double not null,
  `total_price` double not null,
  `order_name` varchar(100) not null,
  `sale_name` varchar(100) not null,
  `is_settled` int(2) not null,
  `is_finished` int(2) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# 	--出货记录表
 CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT null,
  `work_name` varchar(100) NULL,
  `order_nums` double not null,
  `plate_length` double not null,
  `order_type` int(11) NOT NULL,
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# --进货记录表
 CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exp_name` varchar(100) NOT NULL,
  `exp_type` int(11) NOT NULL,
  `exp_nums` double NOT NULL,
  `unit_money` double NOT NULL,
  `sum_money` double NOT NULL,
 `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

alter table purchase change unit_money description varchar(1000);
