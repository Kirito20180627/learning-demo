package com.ldy.threadPool;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 注意这里拒绝策略如果定义的不正确，可能有坑
 * https://juejin.cn/post/7186512174779465765
 */

public class LogRejectPolice implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (executor.getThreadFactory() instanceof NamedThreadFactory) {
            NamedThreadFactory namedThreadFactory = (NamedThreadFactory) executor.getThreadFactory();
            if ("log-io".equals(namedThreadFactory.getNamePrefix())) {
                System.out.println("LOG-IO 线程池有任务被拒绝了，请关注");
            }
        }
        throw new RejectedExecutionException("Task " + r.toString()
                + " reject from "
                + executor
        );
    }
}
