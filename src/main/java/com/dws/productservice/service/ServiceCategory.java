package com.productservice.service;

import java.util.List;

import com.productservice.dto.DtoCategory;

public interface ServiceCategory {

    public List<DtoCategory> getCategorys() throws Exception;
	
    public DtoCategory getCategory(int id) throws Exception;
	
    public void createCategory(DtoCategory category) throws Exception;
	
    public void updateCategory(DtoCategory category, int id) throws Exception;
	
    public void deleteCategory(int id) throws Exception;

}
