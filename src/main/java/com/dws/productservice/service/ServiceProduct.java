package com.dws.productservice.service;

import java.util.List;

import com.dws.productservice.dto.DtoProduct;

public interface ServiceProduct {

    public List<DtoProduct> getProducts() throws Exception;

    public DtoProduct getProduct(String codigo) throws Exception;

    public void createProduct(DtoProduct category) throws Exception;

    public void updateStockProduct(String codigo, int cantidad) throws Exception;

    public void deleteProduct(String codigo) throws Exception;

}
