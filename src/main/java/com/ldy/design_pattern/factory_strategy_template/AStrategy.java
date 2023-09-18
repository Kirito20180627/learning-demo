package com.ldy.design_pattern.factory_strategy_template;

import org.springframework.stereotype.Component;

/**
 * 要加这个注解，注册到Spring容器中
 */
@Component
public class AStrategy extends AbstractHandler {

    @Override
    public void strategyA(String name) {
        System.out.println(name + "AStrategy done");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyFactory.registerStrategy("A", this);
    }
}
