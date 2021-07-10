package com.dws.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.productservice.dto.DtoProduct;
import com.dws.productservice.repository.RepositoryProduct;

@Service
public class ServiceProductImp implements ServiceProduct {

    @Autowired
    RepositoryProduct repositoryProduct;

    @Override
    public List<DtoProduct> getProducts() throws Exception {
        return repositoryProduct.getProducts();
    }

    @Override
    public DtoProduct getProduct(String codigo) throws Exception {
        try {
            return repositoryProduct.getProduct(codigo);
        }catch (Exception e){
            throw new Exception("El producto no existe");
        }
    }

    @Override
    public void createProduct(DtoProduct product) throws Exception {
        repositoryProduct.createProduct(product);
    }

    @Override
    public void updateStockProduct(String codigo, int cantidad) throws Exception {

    }

    @Override
    public void deleteProduct(String codigo) throws Exception {
        try {
            repositoryProduct.deleteProduct(codigo);
        }catch (Exception e){
            throw new Exception("El producto no existe");
        }
    }

}
