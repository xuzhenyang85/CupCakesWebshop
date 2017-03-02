-- CREATE 

DROP schema IF EXISTS cupcakes;

CREATE schema cupcakes;
USE cupcakes;

CREATE TABLE customers(
name VARCHAR(100),
adresse VARCHAR(45),
phone VARCHAR(45),
email VARCHAR(45) PRIMARY KEY,
password VARCHAR(45),
balance DOUBLE(15,2) DEFAULT 0
);

CREATE TABLE ptop(
id INT(30) PRIMARY KEY AUTO_INCREMENT,
topName VARCHAR(45),
topPrice DOUBLE(5,2),
topImgurl VARCHAR(20)
);

CREATE TABLE pbottom(
id INT(30) PRIMARY KEY AUTO_INCREMENT,
bottomName VARCHAR(45),
bottomPrice DOUBLE(5,2),
bottomImgurl VARCHAR(20)
);

CREATE TABLE products(
pid INT(30) PRIMARY KEY AUTO_INCREMENT,
pname VARCHAR(100),
price double(17,2),
FK_ptopId INT(30) DEFAULT NULL,
FK_pbottomId INT(30) DEFAULT NULL,
FOREIGN KEY (FK_ptopId) REFERENCES ptop(id),
FOREIGN KEY(FK_pbottomId) REFERENCES pbottom(id)
);


CREATE TABLE orders(
oid INT(30) PRIMARY KEY AUTO_INCREMENT,
date DATETIME DEFAULT NULL,
oPrice DOUBLE (15,2),
status TINYINT (0)
);

CREATE TABLE o_lines(
id INT(30) PRIMARY KEY AUTO_INCREMENT,
FK_oid INT(30),
FK_pid INT(30),
FK_cemail VARCHAR(45),
qty INT(30),
FOREIGN KEY (FK_oid) REFERENCES orders(oid),
FOREIGN KEY (FK_pid) REFERENCES products(pid),
FOREIGN KEY (FK_cemail) REFERENCES customers(email)
);


-- INSERT 
INSERT INTO customers (name,adresse,phone,email,password) VALUES ('Martin','Nørrebrogade 1','+4538281746','martin@dk.dk','1234');

INSERT INTO ptop (topName,topPrice,topImgurl) VALUES ('Chocolate',5.00,'peanut.png'),('Blueberry',5.00,'pecan.png'),('Rasberry', 5.00,'peanut.png'),('Crispy',6.00,'pecan.png'),('Strawberry',6.00,'peanut.png'),('Rum/Raisin',7.00,'pecan.png'),('Orange',8.00,'peanut.png'),('Lemon',8.00,'pecan.png'),('Blue cheese',9.00,'pecan.png');

INSERT INTO pbottom (bottomName,bottomPrice,bottomImgurl) VALUES ('Chocolate',5.00,'chocolate.png'),('Vanilla',5.00,'strawberry.png'),('Vanilla',5.00,'vanilla.png'),('Pistacio',6.00,'chocolate.png'),('Almond',7.00,'strawberry.png');

INSERT INTO products (pname,price) VALUES ('Cup Cake Standard',5.00);

-- INSERT INTO img (imgname, imgurl, FK_pid) VALUES ('Standard CupCake','standard.jpg',1);

INSERT INTO orders (date,oPrice,status) VALUES (NOW(),50.00,0);

INSERT INTO o_lines (FK_oid,FK_pid,FK_cemail,qty) VALUES (1,1,'martin@dk.dk',2);

CREATE VIEW productList AS
SELECT * FROM products;

CREATE VIEW customerOrders AS
SELECT * FROM customers 
INNER JOIN o_lines ON customers.email = o_lines.FK_cemail 
INNER JOIN orders ON o_lines.FK_oid = orders.oid 
INNER JOIN  products ON o_lines.FK_pid = products.pid;




