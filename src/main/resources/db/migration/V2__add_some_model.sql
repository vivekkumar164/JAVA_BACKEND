CREATE TABLE some_model
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_somemodel PRIMARY KEY (id)
);

ALTER TABLE product
    ADD inventoty_count INT NULL;

ALTER TABLE product
    MODIFY inventoty_count INT NOT NULL;