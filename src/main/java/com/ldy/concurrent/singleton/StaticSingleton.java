package com.ldy.concurrent.singleton;

public class StaticSingleton {

    private StaticSingleton() {}

    private static class Inner {
        public static StaticSingleton singleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return Inner.singleton;
    }
}
