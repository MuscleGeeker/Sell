package me.musclegeeker.sell.service.impl;

import me.musclegeeker.sell.entity.ProductCategory;
import me.musclegeeker.sell.repository.ProductCategoryRepository;
import me.musclegeeker.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) throws Exception {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() throws Exception {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) throws Exception {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) throws Exception {
        return productCategoryRepository.save(productCategory);
    }
}
