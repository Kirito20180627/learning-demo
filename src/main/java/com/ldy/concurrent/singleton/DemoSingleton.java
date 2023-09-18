package com.ldy.concurrent.singleton;

public class DemoSingleton {

    public static volatile DemoSingleton singleton;

    public static DemoSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DemoSingleton.class) {
                if (singleton == null) {
                    singleton = new DemoSingleton();
                }
            }
        }
        return singleton;
    }

}
