package com.dws.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.productservice.dto.DtoCategory;
import com.dws.productservice.repository.RepositoryCategory;

@Service
public class ServiceCategoryImp implements ServiceCategory {
	
    @Autowired
    RepositoryCategory repositoryCategory;

    @Override
    public List<DtoCategory> getCategorys() throws Exception {
        return repositoryCategory.getCategorys();
    }

    @Override
    public DtoCategory getCategory(int id) throws Exception {
        try {
            return repositoryCategory.getCategory(id);
        }catch (Exception e){
            throw new Exception("La categoría no existe");
        }
    }

    @Override
    public void createCategory(DtoCategory category) throws Exception {
        repositoryCategory.createCategory(category);
    }

    @Override
    public void updateCategory(DtoCategory category, int id) throws Exception {
        repositoryCategory.updateCategory(category, id);
    }

    @Override
    public void deleteCategory(int id) throws Exception {
        repositoryCategory.deleteRegion(id);
    }

}
