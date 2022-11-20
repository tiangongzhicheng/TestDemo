package com.tiangongzhicheng.learndemo.demo;

import org.junit.Test;

public class VolatileDemo {




    /**
     * volatile关键字
     * 保证多线程情况下的可见性，被volatile修饰的变量从内存读取，而不是读取线程内的缓存。
     * 不保证原子性。
     * 防止指令重排。
     */


    /* 保证可见性 */
    @Test
    public void testVisibility() {
        MyData myData = new MyData();
        long time = System.currentTimeMillis();
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
        }).start();

        while (myData.number == 0){

        }
        System.out.println("执行结束了,耗时：" + (System.currentTimeMillis()-time));
    }


    /* 不保证原子性 */
    @Test
    public void testAtomicity() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 5000; j++) {
                    myData.addplus();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"number = "+myData.number);

    }

}

class MyData{

    int number = 0;

     public void addTo60(){
         this.number = 60;
     }

     public void addplus(){
         this.number++;
    }

}