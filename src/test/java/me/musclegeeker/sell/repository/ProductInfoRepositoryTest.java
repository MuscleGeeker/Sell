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
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("");
        productInfo.setProductIcon("https://xxxxx.jpg");
        productInfo.setProductName("猪脚饭");
        productInfo.setProductPrice(new BigDecimal(18));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(12);

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