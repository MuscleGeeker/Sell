package me.musclegeeker.sell.repository;

import me.musclegeeker.sell.SellApplicationTests;
import me.musclegeeker.sell.entity.ProductInfo;
import me.musclegeeker.sell.utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class ProductInfoRepositoryTest extends SellApplicationTests {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(StringUtils.uuid());
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("");
        productInfo.setProductIcon("https://360buy.img");
        productInfo.setProductName("Apple iPhone 11 Pro 512G Black");
        productInfo.setProductPrice(new BigDecimal(22.4));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(10);

        productInfo = productInfoRepository.save(productInfo);

        Assert.assertNotNull(productInfo.getProductId());
    }

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoRepository.findOne("516AC47E364B41FAB76D992AE26B5B51");

        Assert.assertNotNull(productInfo);
    }


    @Test
    public void findAll() {
        List<ProductInfo> productInfoList = productInfoRepository.findAll();

        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);

        Assert.assertNotEquals(0, productInfoList.size());
    }
}