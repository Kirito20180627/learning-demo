package com.ldy.design_pattern.responsibility_chain.spring_mode;

import org.springframework.stereotype.Component;

@Component
public class StockHandler extends OrderHandler {
    @Override
    public void handleOrder(Order order) {
        if (!order.isStockAvailability()) {
            throw new RuntimeException("订单库存不足");
        }
        System.out.println("库存扣减成功");
    }
}
