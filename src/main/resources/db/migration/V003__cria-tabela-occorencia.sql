CREATE TABLE occurrence (
	id BIGINT NOT NULL AUTO_INCREMENT,
	delivery_id BIGINT NOT NULL,
	description TEXT NOT NULL,
	registration_date DATETIME NOT NULL,
	
	PRIMARY KEY (ID)
);

ALTER TABLE occurrence ADD CONSTRAINT fk_occurence_delivery
FOREIGN KEY (delivery_id) REFERENCES delivery (id);