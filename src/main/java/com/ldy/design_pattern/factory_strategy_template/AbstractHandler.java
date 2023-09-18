package com.ldy.design_pattern.factory_strategy_template;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public abstract class AbstractHandler implements InitializingBean, BeanPostProcessor {

    /**
     * 注意抛的这个异常，保证不同的策略只支持特定的方法，而不用实现所有方法
     */
    public void strategyA(String name) {
        throw new UnsupportedOperationException();
    }

    public String strategyB(String name) {
        throw new UnsupportedOperationException();
    }
}
