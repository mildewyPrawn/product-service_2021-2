-- drop procedure if exists sp_create_category;

DELIMITER //

CREATE PROCEDURE st_update_category(at_categoria VARCHAR(100), at_id INT)
BEGIN
        IF (SELECT count(*) FROM category WHERE id = at_id) > 0 THEN
        -- si existe el id
           BEGIN
                IF (SELECT count(*) FROM category WHERE categoria = at_categoria) > 0 THEN
                   BEGIN
                           SIGNAL SQLSTATE '50400' SET MESSAGE_TEXT = 'La categoría ya está registrada';
                   END;
                ELSE
                   BEGIN
                           UPDATE category SET id = at_id, categoria = at_categoria WHERE id = at_id;
                   END;
                END IF;
           END;
        ELSE
           BEGIN
                SIGNAL SQLSTATE '50404' SET MESSAGE_TEXT = 'La categoría no existe.';
           END;
        END IF;
END; //

DELIMITER ;
