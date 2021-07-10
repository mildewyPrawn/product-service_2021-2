-- drop procedure if exists sp_create_category;

DELIMITER //

CREATE PROCEDURE st_update_product(at_codigo CHAR(13),
                                   at_cantidad INT
                                   )
BEGIN

        DECLARE _amount  INT DEFAULT 0;

        -- El código existe
        IF (SELECT count(*) FROM product WHERE codigo = at_codigo) > 0 THEN
           BEGIN

                SET _amount = (SELECT cantidad FROM product WHERE codigo = at_codigo);

                SET _amount = _amount + at_cantidad;

                IF _amount > 0 THEN
                   BEGIN
                        UPDATE product SET cantidad = _amount WHERE codigo = at_codigo;
                   END;
                ELSE
                   BEGIN
                        SIGNAL SQLSTATE '50400' SET MESSAGE_TEXT = 'La cantidad ingresada no es válida.';
                   END;
                END IF;

           END;
        ELSE
           BEGIN
                SIGNAL SQLSTATE '50404' SET MESSAGE_TEXT = 'El código del producto no existe.';
           END;
        END IF;
END; //

DELIMITER ;
