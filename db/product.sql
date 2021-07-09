DROP TABLE IF EXISTS product;

CREATE TABLE product(
	id INT,
        codigo CHAR(13),
        producto VARCHAR(100),
        descripcion VARCHAR(255),
	precio FLOAT,
	cantidad INT,
	fecha_creacion DATE,
	id_categoria INT
);

INSERT INTO product VALUES(1,'7501055311453','Paracetamol 500mg','Paracetamol 500mg, 20 tabletas',20.00,100,NOW(),1);
INSERT INTO product VALUES(2,'7898917592649','Coca-Cola 600ml','Coca-Cola 600ml, no retornable',15.00,500,NOW(),2);

SELECT * FROM product;
