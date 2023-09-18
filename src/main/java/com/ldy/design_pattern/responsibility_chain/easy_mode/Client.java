package com.ldy.design_pattern.responsibility_chain.easy_mode;

public class Client {
    public static void main(String[] args) {
        ConcreteHandlerA handlerA = new ConcreteHandlerA();
        ConcreteHandlerB handlerB = new ConcreteHandlerB();
        ConcreteHandlerC handlerC = new ConcreteHandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        Request request = new Request("A");
        handlerA.handleRequest(request);
    }
}
