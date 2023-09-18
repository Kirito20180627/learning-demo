package com.ldy.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class SpringRetryDemo {
    private final static Logger log = LoggerFactory.getLogger(SpringRetryDemo.class);

    /**
     * 标记的方法发生异常时会重试
     * value  指定发生的异常进行重试
     * maxAttempts  重试次数
     * backoff  重试补充机制
     *      默认是@Backoff()注解
     *      delay=200L表示延迟200毫秒 multiplier=2表示两倍 即第一次重试200毫秒后,第二次重试400毫秒后,第三次重试800毫秒后
     */
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 4, backoff = @Backoff(delay = 200L, multiplier = 2))
    public String call(String param) throws Exception {
        log.info("开始服务调用");
        return queryOrderCenter(param);
    }

    /**
     * 具体会返回哪个 Recover ，详见：https://www.whywhy.vip/archives/151#recover逻辑
     */
    @Recover()
    public String serviceNotResponse(String param) throws Exception {
        log.info(param + "-1.没有获取到返回信息");
        return "1.call failure";
    }

    @Recover
    public String serviceNotResponse(String param, Exception e) throws Exception {
        log.info(param + "-2.没有获取到返回信息");
        return "2.call failure";
    }

    @Recover
    public String serviceNotResponse(String param, TimeoutException e) throws Exception {
        log.info(param + "-3.没有获取到返回信息");
        return "3.call failure";
    }

    private String queryOrderCenter(String param) throws TimeoutException{
        throw new TimeoutException("调用订单中心超时");
    }
}
