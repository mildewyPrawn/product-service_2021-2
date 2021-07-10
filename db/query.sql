-- drop procedure if exists sp_create_category;

DELIMITER //

CREATE PROCEDURE sp_create_category(at_categoria VARCHAR(100))
BEGIN   
        DECLARE _size  INT unsigned DEFAULT 0;
        DECLARE _count INT unsigned DEFAULT 1;

        IF NOT (SELECT count(*) FROM category WHERE categoria = at_categoria) > 0 THEN
           BEGIN
                -- Obtener el id para asignarle a la nueva categoria
                SET _size = (SELECT count(*) FROM category);
                SELECT _size;
                WHILE _count <= _size DO
                      IF (SELECT count(*) FROM category WHERE id = _count) > 0 THEN
                         BEGIN
                                SET _count = _count + 1;
                         END;
                      ELSE
                         BEGIN
                                SET _size = 0;
                         END;
                      END IF;
                END WHILE;
                INSERT INTO category VALUES(_count, at_categoria);
           END;
        ELSE
           BEGIN
                SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'La categoría ya está registrada';
           END;
        END IF;
END; //

DELIMITER ;

-- CALL sp_test('Farmacia');
-- CALL sp_test('Electronica');
