package com.ldy.concurrent.TenThreadsDoAdd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
    private final int begin;
    private final int total;
    private final int threadNums;
    private int sum = 0;
    private Lock lock;
    private CountDownLatch latch;

    public Task(int threadNums, int total, int begin) {
        latch = new CountDownLatch(threadNums);
        lock = new ReentrantLock();
        this.begin = begin;
        this.total = total;
        this.threadNums = threadNums;
    }
    private int doAdd() throws InterruptedException {
        int average = (total - begin + 1) / threadNums;
        int start, end;
        for (int i = 1; i <= threadNums; i++) {
            start = (i - 1) * average + 1;
            end = i * average;
            new Thread(new Calculator(start, end)).start();
        }
        latch.await();
        return sum;
    }

    class Calculator implements Runnable {
        private int start;
        private int end;

        public Calculator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            lock.lock();
            try {
                sum += result;
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(10, 100, 1);
        System.out.println(task.doAdd());
    }
}
