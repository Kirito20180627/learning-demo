package com.ldy.threadPool;


import java.util.concurrent.*;

public class ThreadPoolUtil {

    public final static LinkedBlockingDeque<Runnable> LOG_IO_TASK_WORK_QUEUE = new LinkedBlockingDeque<>(10000);

    public final static Executor LOG_IO_THREAD_POOL = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() * 2,
            Runtime.getRuntime().availableProcessors() * 2,
            0L,
            TimeUnit.MILLISECONDS,
            LOG_IO_TASK_WORK_QUEUE,
            new NamedThreadFactory("log-io", false),
            new LogRejectPolice()
    );

}
