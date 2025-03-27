package com.ldy.proxy;

public class Hello implements Ihello {
    @Override
    public void say() {
        System.out.println("hello");
    }
}
