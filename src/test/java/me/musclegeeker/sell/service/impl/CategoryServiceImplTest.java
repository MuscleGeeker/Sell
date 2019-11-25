package me.musclegeeker.sell.service.impl;

import me.musclegeeker.sell.SellApplicationTests;
import me.musclegeeker.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends SellApplicationTests {

    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);

        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findAll();

        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));

        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = categoryService.save(new ProductCategory("当前最热", 4));

        Assert.assertNotNull(productCategory);
    }
}