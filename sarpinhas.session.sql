-- CREATE DATABASE IF NOT EXISTS sarpinhas;

-- CREATE TABLE IF NOT EXISTS sarpinhas.operation_profile (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(40)
-- );

-- INSERT INTO sarpinhas.operation_profile (name) VALUES ('Padrão');
-- INSERT INTO sarpinhas.operation_profile (name) VALUES ('Recreativo');
-- INSERT INTO sarpinhas.operation_profile (name) VALUES ('Princípio de Sombra');
-- INSERT INTO sarpinhas.operation_profile (name) VALUES ('Aeronivelamento');

-- CREATE TABLE IF NOT EXISTS sarpinhas.flight_type (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(40)
-- );

-- INSERT INTO sarpinhas.flight_type (name) VALUES ('VLOS');
-- INSERT INTO sarpinhas.flight_type (name) VALUES ('EVLOS');
-- INSERT INTO sarpinhas.flight_type (name) VALUES ('BVLOS');

-- CREATE TABLE IF NOT EXISTS sarpinhas.operation_status (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(100)
-- );

-- INSERT INTO sarpinhas.operation_status (name) VALUES ('Processing');
-- INSERT INTO sarpinhas.operation_status (name) VALUES ('Authorized');
-- INSERT INTO sarpinhas.operation_status (name) VALUES ('Denied');

-- CREATE TABLE IF NOT EXISTS sarpinhas.operator (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(100)
-- );

-- CREATE TABLE IF NOT EXISTS sarpinhas.UAS (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     serial_number VARCHAR(100)
-- );

-- CREATE TABLE IF NOT EXISTS sarpinhas.flight_requests (
--     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     operator_id INT NOT NULL,
--     UAS_id INT NOT NULL,
--     operation_name VARCHAR(300) NOT NULL,
--     flight_type INT NOT NULL,
--     operation_profile INT NOT NULL,
--     start_timestamp TIMESTAMP NOT NULL,
--     end_timestamp TIMESTAMP NOT NULL,
--     operation_status INT NOT NULL,
--     INDEX operator_id_idx (operator_id ASC) VISIBLE,
--     INDEX UAS_id_idx (UAS_id ASC) VISIBLE,
--     INDEX flight_type_idx (flight_type ASC) VISIBLE,
--     INDEX operation_profile_idx (operation_profile ASC) VISIBLE,
--     INDEX operation_status_idx (operation_status ASC) VISIBLE,
--     CONSTRAINT operator_id
--         FOREIGN KEY (operator_id)
--         REFERENCES sarpinhas.operator (id)
--         ON DELETE NO ACTION
--         ON UPDATE NO ACTION,
--     CONSTRAINT UAS_id
--         FOREIGN KEY (UAS_id)
--         REFERENCES sarpinhas.UAS (id)
--         ON DELETE NO ACTION
--         ON UPDATE NO ACTION,
--     CONSTRAINT flight_type
--         FOREIGN KEY (flight_type)
--         REFERENCES sarpinhas.flight_type (id)
--         ON DELETE NO ACTION
--         ON UPDATE NO ACTION,
--     CONSTRAINT operation_profile
--         FOREIGN KEY (operation_profile)
--         REFERENCES sarpinhas.operation_profile (id)
--         ON DELETE NO ACTION
--         ON UPDATE NO ACTION,
--     CONSTRAINT operation_status
--         FOREIGN KEY (operation_status)
--         REFERENCES sarpinhas.operation_status (id)
--         ON DELETE NO ACTION
--         ON UPDATE NO ACTION
-- );

CREATE TABLE IF NOT EXISTS sarpinhas.operation_area_markers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    flight_request_id INT NOT NULL,
    latitude FLOAT(8,5) NOT NULL,
    longitude FLOAT(8,5) NOT NULL,
    sequence_value INT NOT NULL,
    INDEX flight_request_id_idx (flight_request_id ASC) VISIBLE,
    CONSTRAINT flight_request_id
        FOREIGN KEY (flight_request_id)
        REFERENCES sarpinhas.flight_requests (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

