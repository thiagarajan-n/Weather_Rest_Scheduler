CREATE SCHEMA `weather` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE weather.city
(
    city_id BIGINT(20) PRIMARY KEY NOT NULL,
    city_name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);
CREATE TABLE weather.temperature
(
	id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city_id BIGINT(20) NOT NULL,
    temp_min FLOAT(20),
    temp_max FLOAT(20),
    date DATE NOT NULL,
    CONSTRAINT FK_c7picib39dl7kxro2349cnpn9 FOREIGN KEY (city_id) REFERENCES city (city_id)
);

INSERT INTO `weather`.`city` (`city_id`, `city_name`, `country`) VALUES ('4671654', 'Austin', 'US');
INSERT INTO `weather`.`city` (`city_id`, `city_name`, `country`) VALUES ('4726206', 'San Antonio', 'US');

INSERT INTO `weather`.`temperature` (`id`, `city_id`, `date`, `temp_max`, `temp_min`) VALUES ('101', '4726206', '20171007', '79', '72');
INSERT INTO `weather`.`temperature` (`id`, `city_id`, `date`, `temp_max`, `temp_min`) VALUES ('102', '4671654', '20171007', '77', '71');

commit;