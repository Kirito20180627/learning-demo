package com.ldy.concurrent.printInturn;

import java.util.concurrent.atomic.AtomicBoolean;

public class SyncWaitNotify {
    public static void main(String[] args) {
        Object lock = new Object();
        char[] ints = "1234567".toCharArray();
        char[] chars = "ABCDEFG".toCharArray();
        AtomicBoolean isIntsPrinterStart = new AtomicBoolean(false);
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isIntsPrinterStart.set(true);
            synchronized (lock) {
                try {
                    for (char i : ints) {
                        System.out.print(i);
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                lock.notify();
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    for (char c : chars) {
                        while (!isIntsPrinterStart.get()) {
                            lock.wait();
                        }
                        System.out.print(c);
                        lock.notify();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
