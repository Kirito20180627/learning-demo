package com.ldy.design_pattern.factory_strategy_template;

import com.ldy.design_pattern.factory_strategy_template.AbstractHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyFactory {
    public static Map<String, AbstractHandler> strategyMap = new ConcurrentHashMap<>();

    public static AbstractHandler getStrategy(String name) {
        return strategyMap.get(name);
    }

    public static void registerStrategy(String name, AbstractHandler handler) {
        if (name != null && handler != null) {
            strategyMap.put(name, handler);
        }
    }
}
