package me.musclegeeker.sell.service.impl;

import me.musclegeeker.sell.dto.OrderDTO;
import me.musclegeeker.sell.entity.OrderDetail;
import me.musclegeeker.sell.entity.OrderMaster;
import me.musclegeeker.sell.entity.ProductInfo;
import me.musclegeeker.sell.enums.ProductStatusEnum;
import me.musclegeeker.sell.enums.ResultEnum;
import me.musclegeeker.sell.exception.SellException;
import me.musclegeeker.sell.repository.OrderDetailRepository;
import me.musclegeeker.sell.repository.OrderMasterRepository;
import me.musclegeeker.sell.service.OrderService;
import me.musclegeeker.sell.service.ProductService;
import me.musclegeeker.sell.utils.GlobalKeyGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductService productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) throws Exception {
        String orderId = GlobalKeyGenerator.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 1.查询商品(库存、价格)
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null || productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 2.计算总价
            orderAmount = orderAmount.add(orderDetail.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())));

            // 订单详情入库
            orderDetail.setDetailId(GlobalKeyGenerator.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }
        // 3.写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderAmount);
        orderMasterRepository.save(orderMaster);
        // 4.扣减库存

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> list(String openId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO pay(OrderDTO orderDTO) {
        return null;
    }
}
