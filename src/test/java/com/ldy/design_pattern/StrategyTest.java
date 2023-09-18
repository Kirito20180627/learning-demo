package com.ldy.design_pattern;

import com.ldy.design_pattern.factory_strategy_template.AbstractHandler;
import com.ldy.design_pattern.factory_strategy_template.StrategyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrategyTest {

    @Test
    void strategy() {
        AbstractHandler handler = StrategyFactory.getStrategy("A");
        handler.strategyA("Apple:");

        AbstractHandler handler1 = StrategyFactory.getStrategy("B");
        System.out.println(handler1.strategyB("Banana:"));
    }

    @Test
    void test() {
    }

}
