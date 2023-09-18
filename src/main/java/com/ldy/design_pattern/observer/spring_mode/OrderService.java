package com.ldy.design_pattern.observer.spring_mode;

import com.ldy.design_pattern.responsibility_chain.spring_mode.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void saveOrder() {
        System.out.println("订单生成ing...");
        eventPublisher.publishEvent(new OrderEvent(new Order("123456")));
    }
}
