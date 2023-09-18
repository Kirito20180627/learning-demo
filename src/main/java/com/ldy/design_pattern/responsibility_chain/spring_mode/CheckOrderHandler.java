package com.ldy.design_pattern.responsibility_chain.spring_mode;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Component
public class CheckOrderHandler extends OrderHandler {
    @Override
    public void handleOrder(Order order) {
        if (StringUtils.isEmpty(order.getOrderNo())) {
            throw new RuntimeException("订单编号不能为空");
        }
        if (order.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("订单金额不能小于等于0");
        }
        if (StringUtils.isEmpty(order.getShippingAddress())) {
            throw new RuntimeException("收货地址不能为空");
        }
        System.out.println("订单参数校验通过");
    }
}
