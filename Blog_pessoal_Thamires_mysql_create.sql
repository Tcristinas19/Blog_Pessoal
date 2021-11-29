CREATE TABLE `Temas` (
	`id Arco íris` bigint(5) NOT NULL AUTO_INCREMENT,
	`sobre nós` varchar(255) NOT NULL,
	PRIMARY KEY (`id Arco íris`)
);

CREATE TABLE `Postagens` (
	`id` bigint(500) NOT NULL AUTO_INCREMENT,
	`titulo` varchar(200) NOT NULL,
	`texto` varchar(5000) NOT NULL,
	`data` int(200) NOT NULL,
	`id_tema` bigint(500) NOT NULL,
	`id_usuários` bigint(500) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Usuários` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`usuario` varchar(255) NOT NULL,
	`perfil` varchar(500) NOT NULL,
	`idade` int(500) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Temas` ADD CONSTRAINT `Temas_fk0` FOREIGN KEY (`sobre nós`) REFERENCES `Temas`(``);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk0` FOREIGN KEY (`id`) REFERENCES `Temas`(``);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk1` FOREIGN KEY (`id_tema`) REFERENCES `Temas`(`id Arco íris`);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk2` FOREIGN KEY (`id_usuários`) REFERENCES `Usuários`(`id`);




