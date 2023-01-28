CREATE TABLE delivery (
	id BIGINT NOT NULL AUTO_INCREMENT,
	client_id BIGINT NOT NULL,
	fee DECIMAL(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	orderer_date DATETIME NOT NULL,
	finish_date DATETIME NOT NULL,
	
	recipient_name VARCHAR(60) NOT NULL,
	recipient_adress VARCHAR(255) NOT NULL,
	recipient_number VARCHAR(30) NOT NULL,
	recipient_complement VARCHAR(60) NOT NULL,
	recipient_neighborhood VARCHAR(30) NOT NULL,
	
	PRIMARY KEY (ID)
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_client
FOREIGN KEY (client_id) REFERENCES client (id);