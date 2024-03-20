CREATE DATABASE CRUDSql;
USE CRUDSql;
CREATE TABLE user905(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    e_name VARCHAR(4000),
    e_password VARCHAR(4000),
    e_email VARCHAR(4000),
    e_country VARCHAR(4000)
);

INSERT INTO user905(id, e_name, e_password, e_email, e_country) VALUES (63, "Amit Kumar Rana",  "amtkmjj45", "amitkumar12@gmail.com", "India");
INSERT INTO user905(id, e_name, e_password, e_email, e_country) VALUES (61, "Rahul Kumar",  "rahul4000", "rahulkk@gmail.com", "India");
INSERT INTO user905(id, e_name, e_password, e_email, e_country) VALUES (62, "Sonoo Jaiswal",  "sonoobsk", "sonoojaiswal1@gmail.com", "India");
INSERT INTO user905(id, e_name, e_password, e_email, e_country) VALUES (44, "Adarsh Kumar",  "kkkkk", "adarsh232@gmail.com", "India");

select * from user905;