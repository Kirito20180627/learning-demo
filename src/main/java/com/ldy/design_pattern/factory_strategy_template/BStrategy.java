package com.ldy.design_pattern.factory_strategy_template;

import org.springframework.stereotype.Component;

/**
 * 要加这个注解，注册到Spring容器中
 */
@Component
public class BStrategy extends AbstractHandler {

    @Override
    public String strategyB(String name) {
        return name + "BStrategy done";
    }

    @Override
    public void afterPropertiesSet() {
        StrategyFactory.registerStrategy("B", this);
    }
}
