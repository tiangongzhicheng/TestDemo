package com.tiangongzhicheng.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {
    public static void main(String[] args) {
        // 定义一个任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run timerTask：" + new Date());
            }
        };
        // 计时器
        Timer timer = new Timer();
        // 添加执行任务(延迟 1s 执行，每 3s 执行一次)
        timer.schedule(timerTask, 1000, 3000);
    }
}
