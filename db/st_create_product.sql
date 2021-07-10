-- drop procedure if exists st_create_product;

DELIMITER //

CREATE PROCEDURE st_create_product(
       at_codigo        CHAR(13),
       at_producto      VARCHAR(100),
       at_descripcion   VARCHAR(255),
       at_precio        FLOAT,
       at_cantidad      INT,
       at_id_categoria  INT
)
BEGIN   
        DECLARE _size  INT unsigned DEFAULT 0;
        DECLARE _count INT unsigned DEFAULT 1;

        -- Validar que no exista el código del producto
        IF (SELECT codigo FROM product WHERE codigo = at_codigo) > 0 THEN
           SIGNAL SQLSTATE '50400' SET MESSAGE_TEXT = 'El código del producto ya está registrado.';
        END IF;

        -- Validar que el id de categoría exista

        IF (SELECT id FROM category WHERE id = at_id_categoria) > 0 THEN
           BEGIN
                -- Obtener el id para asignarle al nuevo producto
                SET _size = (SELECT count(*) FROM product);
                WHILE _count <= _size DO
                      IF (SELECT id FROM product WHERE id = _count) > 0 THEN
                         BEGIN
                                SET _count = _count + 1;
                         END;
                      ELSE
                         BEGIN
                                SET _size = 0;
                         END;
                      END IF;
                END WHILE;
                INSERT INTO product VALUES(_count,
                                           at_codigo,
                                           at_producto,
                                           at_descripcion,
                                           at_precio,
                                           at_cantidad,
                                           NOW(),
                                           at_id_categoria);
           END;
        ELSE
           BEGIN
                SIGNAL SQLSTATE '50400' SET MESSAGE_TEXT = 'El id de categoría no existe.';
           END;
        END IF;
END; //

DELIMITER ;
