package com.ldy.concurrent.printInturn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCountDownLatch {
    private static Lock lock = new ReentrantLock();
    private static Condition conditionInt = lock.newCondition();
    private static Condition conditionChar = lock.newCondition();
    private static CountDownLatch latchLater = new CountDownLatch(1);

    public static void main(String[] args) {
        char[] ints = "1234567".toCharArray();
        char[] chars = "ABCDEFG".toCharArray();
        AtomicBoolean flag = new AtomicBoolean(false);
        new Thread(() -> {
            try {
                lock.lock();
                latchLater.countDown();
                for (char i : ints) {
                    System.out.print(i);
                    conditionChar.signal();
                    conditionInt.await();
                }
                conditionChar.signal();
            } catch (Exception e) {
                throw new RuntimeException();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                latchLater.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                lock.lock();
                for (char c : chars) {
                    System.out.print(c);
                    conditionInt.signal();
                    conditionChar.await();
                }
            } catch (Exception e) {
                throw new RuntimeException();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
