package me.musclegeeker.sell.service.impl;

import me.musclegeeker.sell.entity.ProductInfo;
import me.musclegeeker.sell.enums.ProductStatusEnum;
import me.musclegeeker.sell.repository.ProductInfoRepository;
import me.musclegeeker.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品
 *
 * @author musclegeeker
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) throws Exception {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() throws Exception {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) throws Exception {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) throws Exception {
        return productInfoRepository.save(productInfo);
    }
}
