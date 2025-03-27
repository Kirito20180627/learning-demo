package com.ldy.proxy;

import java.lang.reflect.Proxy;

public class Demo {

    public static void main(String[] args) {
        MyHandler<Ihello> handler = new MyHandler<>(new Hello());
        Ihello proxyInstance = (Ihello) Proxy.newProxyInstance(Ihello.class.getClassLoader(), new Class[]{Ihello.class}, handler);
        proxyInstance.say();
    }
}
