DROP TABLE IF EXISTS category;

CREATE TABLE category(
       id INT,
       categoria VARCHAR(100)
);

INSERT INTO category VALUES(1,'Farmacia');
INSERT INTO category VALUES(2,'Bebidas');

SELECT * FROM category;
