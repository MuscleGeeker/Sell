package me.musclegeeker.sell.repository;

import me.musclegeeker.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 获取种类列表
     *
     * @param categoryIds
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
