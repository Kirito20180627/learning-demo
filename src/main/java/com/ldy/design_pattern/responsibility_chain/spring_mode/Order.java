package com.ldy.design_pattern.responsibility_chain.spring_mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderNo;
    private BigDecimal price;
    private String paymentMethod;
    private boolean stockAvailability;
    private String shippingAddress;

    public Order(String orderNo) {
        this.orderNo = orderNo;
    }
}
