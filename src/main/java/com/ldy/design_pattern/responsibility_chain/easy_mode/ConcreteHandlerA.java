package com.ldy.design_pattern.responsibility_chain.easy_mode;

public class ConcreteHandlerA implements Handler {

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("A")) {
            // 处理请求的逻辑
            System.out.println("ConcreteHandlerA done");
        } else {
            successor.handleRequest(request);
        }
    }
}
