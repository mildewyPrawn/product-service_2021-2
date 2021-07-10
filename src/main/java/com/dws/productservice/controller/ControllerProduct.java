package com.dws.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.productservice.dto.DtoProduct;
import com.dws.productservice.exceptionHandling.ApiException;
import com.dws.productservice.service.ServiceProduct;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping
    public ResponseEntity<Object> getProducts() throws Exception {
        try {
            return new ResponseEntity<>(serviceProduct.getProducts(), HttpStatus.OK);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> getProduct(@PathVariable("codigo") String codigo) throws Exception {
        try {
            return new ResponseEntity<>(serviceProduct.getProduct(codigo), HttpStatus.OK);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody DtoProduct product) throws Exception {
        try {
            serviceProduct.createProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Object> updateStockProduct(@RequestBody DtoProduct product) throws Exception {
        try {
            String codigo = product.getCodigo();
            int cantidad = product.getCantidad();
            serviceProduct.updateStockProduct(codigo, cantidad);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("codigo") String codigo) throws Exception {
        try {
            serviceProduct.deleteProduct(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

}
