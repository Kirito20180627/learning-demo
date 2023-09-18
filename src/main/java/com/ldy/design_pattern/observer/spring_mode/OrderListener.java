package com.ldy.design_pattern.observer.spring_mode;

import com.ldy.design_pattern.responsibility_chain.spring_mode.Order;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 异步使用线程池方式见：
 * <a href="https://www.cnblogs.com/admol/p/14036564.html">...</a>
 */
@Component
public class OrderListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("已生成订单:" + ((Order) event.getSource()).getOrderNo());
    }
}
