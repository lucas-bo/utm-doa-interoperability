CREATE DATABASE sisantinho;

CREATE TABLE sisantinho.operator (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cpf INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sisantinho.UAS (
	id INT NOT NULL AUTO_INCREMENT,
	manufacturer VARCHAR(100) NOT NULL,
	model VARCHAR(100) NOT NULL,
	operator_id INT NOT NULL,
	maximum_flying_weigh FLOAT NOT NULL,
	serial_number VARCHAR(100) NOT NULL,
	experimental BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    INDEX operator_id_idx (operator_id ASC) VISIBLE,
    CONSTRAINT operator_id
        FOREIGN KEY (operator_id)
        REFERENCES sisantinho.operator (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);