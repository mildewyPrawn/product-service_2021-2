package com.dws.productservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dws.productservice.dto.DtoCategory;


@Repository
public class RepositoryCategory {

    @Autowired
    JdbcTemplate jdbcTemplate;
	
    public List<DtoCategory> getCategorys() throws Exception {
        try {
            return jdbcTemplate.query("SELECT * FROM category;", new BeanPropertyRowMapper<DtoCategory>(DtoCategory.class));
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
	
    public DtoCategory getCategory(int id) throws Exception {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM category WHERE id = " + id + ";", new BeanPropertyRowMapper<DtoCategory>(DtoCategory.class));
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    public void createCategory(DtoCategory categoria) throws Exception {
        try {
            jdbcTemplate.update("CALL sp_create_category(?);",categoria.getCategoria());
            
        } catch (UncategorizedSQLException e) {
            throw new Exception(e.getSQLException().getLocalizedMessage());
        }
    }

    public void updateCategory(DtoCategory categoria, int id) throws Exception {

    }

    public void deleteRegion(int id) throws Exception {
        try {
            jdbcTemplate.update("DELETE FROM category WHERE id = " + id + ";");
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
}
