CREATE DATABASE anime_store;

CREATE TABLE anime_store.producer (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE anime_store.anime (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(300) NOT NULL,
    episodes INT NOT NULL,
    producer_id INT NOT NULL,
    PRIMARY KEY (id),
    INDEX producer_id_idx (producer_id ASC) VISIBLE,
    CONSTRAINT producer_id
        FOREIGN KEY (producer_id)
        REFERENCES anime_store.producer (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);

INSERT INTO producer (id, name)
VALUES (id:int, 'name:varchar');