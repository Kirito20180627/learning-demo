package com.ldy.design_pattern;

import com.ldy.design_pattern.observer.Observer;
import com.ldy.design_pattern.observer.spring_mode.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ObserverTest {

    @Autowired
    List<Observer> observerList;
    @Autowired
    OrderService orderService;

    @Test
    void observer() {
        sendMsg("bizType1", "业务1的内容");
        sendMsg("bizType2", "业务2的内容");
    }

    private void sendMsg(String bizType, String content) {
        // 同步阻塞方式
        // AsyncEventBus 可异步非阻塞实现
        observerList.forEach(observer -> observer.notify(bizType, content));
    }

    @Test
    public void springMode() {
        orderService.saveOrder();
    }

}
