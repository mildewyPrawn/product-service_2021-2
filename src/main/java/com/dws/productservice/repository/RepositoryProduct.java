package com.dws.productservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dws.productservice.dto.DtoProduct;

@Repository
public class RepositoryProduct {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<DtoProduct> getProducts() throws Exception {
        try {
            return jdbcTemplate.query("SELECT * FROM product;", new BeanPropertyRowMapper<DtoProduct>(DtoProduct.class));
        }catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    public DtoProduct getProduct(String codigo) throws Exception {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM product WHERE codigo = " + codigo + ";", new BeanPropertyRowMapper<DtoProduct>(DtoProduct.class));
        }catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    public void createProduct(DtoProduct product) throws Exception {
        try {
            jdbcTemplate.update("{ CALL st_create_product(?,?,?,?,?,?)}",
                                product.getCodigo(),
                                product.getProducto(),
                                product.getDescripcion(),
                                product.getPrecio(),
                                product.getCantidad(),
                                product.getId_categoria());
        }catch(UncategorizedSQLException e) {
            throw new Exception(e.getSQLException().getLocalizedMessage());
        }
    }

    public void updateStockProduct(int id, int cantidad) throws Exception {

    }

    public void deleteProduct(String codigo) throws Exception {
        try {
            jdbcTemplate.update("DELETE FROM product WHERE codigo = " + codigo + ";");
        }catch(Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
}
