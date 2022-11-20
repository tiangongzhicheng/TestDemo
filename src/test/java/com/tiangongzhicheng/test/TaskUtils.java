package com.tiangongzhicheng.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskUtils {
    // 添加定时任务
    @Scheduled(cron = "59 59 23 0 0 5")
    // cron 表达式，每周五 23:59:59 执行
    public void doTask() {
        System.out.println("我是定时任务~");
    }
}