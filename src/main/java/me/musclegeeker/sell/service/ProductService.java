package me.musclegeeker.sell.service;

import me.musclegeeker.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    /**
     * 查询单条
     *
     * @param productId
     * @return
     * @throws Exception
     */
    ProductInfo findOne(String productId) throws Exception;

    /**
     * 查询所有有效商品列表
     *
     * @return
     * @throws Exception
     */
    List<ProductInfo> findUpAll() throws Exception;

    /**
     * 查询所有商品
     *
     * @param pageable
     * @return
     * @throws Exception
     */
    Page<ProductInfo> findAll(Pageable pageable) throws Exception;

    ProductInfo save(ProductInfo productInfo) throws Exception;

    // 加库存

    // 减库存
}
