package me.musclegeeker.sell.controller;

import com.google.common.collect.Lists;
import me.musclegeeker.sell.common.result.Response;
import me.musclegeeker.sell.common.result.ResultVO;
import me.musclegeeker.sell.entity.ProductCategory;
import me.musclegeeker.sell.entity.ProductInfo;
import me.musclegeeker.sell.service.CategoryService;
import me.musclegeeker.sell.service.ProductService;
import me.musclegeeker.sell.vo.ProductInfoVO;
import me.musclegeeker.sell.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO<List<ProductVO>> list() {
        try {
            // 1.查询所有上架商品
            List<ProductInfo> productInfoList = productService.findUpAll();
            // 2.查询类目
            List<ProductCategory> productCategoryList = categoryService.findAll();
            // 3.组装数据
            List<ProductVO> productVOList = productCategoryList.stream().map(e -> {
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(e.getCategoryName());
                productVO.setCategoryType(e.getCategoryType());
                List<ProductInfoVO> productInfoVOList =
                        productInfoList.stream()
                                // 过滤条件 categoryType相等
                                .filter(productInfo -> productInfo.getCategoryType() == e.getCategoryType())
                                .map(productInfo -> {
                                    ProductInfoVO productInfoVO = new ProductInfoVO();
                                    BeanUtils.copyProperties(productInfo, productInfoVO);
                                    return productInfoVO;
                                }).collect(Collectors.toList());
                productVO.setProductInfoVOList(productInfoVOList);
                return productVO;
            }).collect(Collectors.toList());
            return Response.OK(productVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ERROR(500, "系统异常");
    }
}
