package com.tiangongzhicheng.test;


import java.util.Date;
import java.util.concurrent.*;

public class MyScheduledExecutorService {
    public static void main(String[] args) {
        // 创建任务队列
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 执行任务 1
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("进入 Schedule：" + new Date());
            try {
                // 休眠 5 秒
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run Schedule：" + new Date());
        }, 1, 3, TimeUnit.SECONDS);// 1s 后开始执行，每 3s 执行一次

        // 执行任务 2
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Run Schedule2：" + new Date());
        }, 1, 3, TimeUnit.SECONDS);// 1s 后开始执行，每 3s 执行一次

    }
}
