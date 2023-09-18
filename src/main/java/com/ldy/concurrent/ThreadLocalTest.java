package com.ldy.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {
    private final List<String> message = new ArrayList<>();
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String s) {
        holder.get().message.add(s);
    }
    public static void clear() {
        holder.remove();
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("Today is 17, August");
        System.out.println(holder.get().message);
        ThreadLocalTest.clear();
    }
}
