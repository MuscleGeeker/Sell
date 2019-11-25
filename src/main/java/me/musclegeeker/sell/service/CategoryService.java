package me.musclegeeker.sell.service;

import me.musclegeeker.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    /**
     * 查询单条记录
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId) throws Exception;

    /**
     * 查询所有栏目
     *
     * @return
     */
    List<ProductCategory> findAll() throws Exception;

    /**
     * 根据一组栏目查询
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) throws Exception;

    /**
     * 新增/更新
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory) throws Exception;
}
