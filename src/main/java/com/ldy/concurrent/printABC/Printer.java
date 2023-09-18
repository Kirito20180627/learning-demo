package com.ldy.concurrent.printABC;

import java.util.concurrent.locks.*;

public class Printer {
    private int num;
    private final int printCount;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public Printer(int printCount) {
        this.printCount = printCount;
    }

    private void printABC(String text, int targetNum, Condition currentThread, Condition nextThread) {
        for (int i = 0; i < printCount; ) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await();  // 阻塞当前线程
                }
                num++;
                i++;
                // System.out.println(i);
                System.out.print(text);
                nextThread.signal();   // 唤醒下一个线程，而不是唤醒所有线程
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer(10);
        new Thread(() -> printer.printABC("A", 0, c1, c2)).start();
        new Thread(() -> printer.printABC("B", 1, c2, c3)).start();
        new Thread(() -> printer.printABC("C", 2, c3, c1)).start();
    }
}
