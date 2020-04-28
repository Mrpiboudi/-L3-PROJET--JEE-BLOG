
CREATE TABLE `user` 
(
	`id_user` INT NOT NULL AUTO_INCREMENT,
	`pseudo` VARCHAR(25),
	`nom` VARCHAR(25),
	`prenom` VARCHAR(25),
	`age` INT,
	`mdp` CHAR(40),
	`email` VARCHAR(25),
	`genre` VARCHAR(10),
	PRIMARY KEY (id_user)
);

CREATE TABLE `post`
(
	`id_post` INT NOT NULL AUTO_INCREMENT,
	`id_user` INT,
	`message` VARCHAR(255),
	`date` TIMESTAMP NOT NULL,
	PRIMARY KEY (id_post, id_user)
);

CREATE TABLE `commentaire` 
(
	`id_comm` INT NOT NULL AUTO_INCREMENT,
	`id_post` INT,
	`id_user` INT,
	`message` VARCHAR(255),
	`date` TIMESTAMP NOT NULL,
	PRIMARY KEY (id_comm, id_post)
);

CREATE TABLE `relation`
(
	`id_relation` INT NOT NULL AUTO_INCREMENT,
	`id_user1` INT,
	`id_user2` INT, 
	PRIMARY KEY (id_relation)
);


