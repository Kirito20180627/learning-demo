package com.ldy.design_pattern.responsibility_chain.spring_mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuilderOrderChain {

    @Autowired
    private AliPaymentHandler aliPaymentHandler;

    @Autowired
    private CheckOrderHandler checkOrderHandler;

    @Autowired
    private StockHandler stockHandler;

    List<OrderHandler> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(checkOrderHandler);
        list.add(stockHandler);
        list.add(aliPaymentHandler);
    }

    public void doFilter(Order order) {
        for (OrderHandler orderHandler : this.list) {
            orderHandler.handleOrder(order);
        }
    }
}
