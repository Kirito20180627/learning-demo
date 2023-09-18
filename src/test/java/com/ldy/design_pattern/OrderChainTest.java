package com.ldy.design_pattern;

import com.ldy.design_pattern.responsibility_chain.spring_mode.BuilderOrderChain;
import com.ldy.design_pattern.responsibility_chain.spring_mode.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OrderChainTest {

    @Autowired
    private BuilderOrderChain builderOrderChain;

    @Test
    public void test() {
        Order order = new Order("123456",
                new BigDecimal("100"),
                "支付宝",
                true,
                "长沙");
        builderOrderChain.doFilter(order);
    }
}
