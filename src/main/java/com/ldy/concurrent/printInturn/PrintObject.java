package com.ldy.concurrent.printInturn;

public class PrintObject {

    private int flag;

    private final int loopNum;

    public PrintObject(int flag, int loopNum) {
        this.flag = flag;
        this.loopNum = loopNum;
    }

    public void print(String str, int currFlag, int nextFlag) {
        for (int i = 0; i < loopNum; i++) {
            synchronized (this) {
                while (currFlag != this.flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintObject printObject = new PrintObject(1, 50);
        new Thread(() -> printObject.print("a", 1, 2)).start();
        new Thread(() -> printObject.print("b", 2, 1)).start();
    }
}
