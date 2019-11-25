package me.musclegeeker.sell.repository;

import lombok.extern.slf4j.Slf4j;
import me.musclegeeker.sell.SellApplicationTests;
import me.musclegeeker.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ProductCategoryRepositoryTest extends SellApplicationTests {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void insert() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);

        ProductCategory result = productCategoryRepository.save(productCategory);


        Assert.assertTrue(result.getCategoryId() != null);
    }

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryRepository.findOne(1);

        Assert.assertTrue(productCategory != null);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1, 2, 3));

        log.info("获取到栏目列表: {}", productCategoryList);
    }
}