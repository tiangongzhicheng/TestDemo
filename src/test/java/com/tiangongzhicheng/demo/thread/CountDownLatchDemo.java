package com.tiangongzhicheng.demo.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器
 */
public class CountDownLatchDemo implements Runnable {
    /**
     * 当所有的检查线程完成任务后，主线程才会继续进行。
     */

    //计数为10，表示需要有10个线程完成任务，主任务才能继续进行
    final static CountDownLatch end = new CountDownLatch(10);
    final static CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("检查完毕");
            //一个检查线程任务完成，通知计数器减1
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        //主线程等待检查线程任务执行
        end.await();
        System.out.println("执行主任务");
        exec.shutdown();
    }
}
