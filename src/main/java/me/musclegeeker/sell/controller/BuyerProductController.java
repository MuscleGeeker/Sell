package me.musclegeeker.sell.controller;

import me.musclegeeker.sell.common.result.Response;
import me.musclegeeker.sell.common.result.ResultVO;
import me.musclegeeker.sell.entity.ProductInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO<List<ProductInfo>> list() {

        return Response.OK();
    }
}
