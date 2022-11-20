package com.tiangongzhicheng.demo.thread;

import java.util.ArrayList;

public class VolatileDemo {

    public static void main(String[] args){
        MyThread myThread = new MyThread();

/*        Thread aaa = new Thread(() -> {
            System.out.println("正在执行的线程=="+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myThread.changeParam();
            System.out.println("param被修改了");
        }, "AAA");
        aaa.start();*/

        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.parallelStream().forEach(a->{
            System.out.println(Thread.currentThread().getName());
            if(!Thread.currentThread().getName().equals("main")){
                System.out.println("正在执行的线程=="+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myThread.changeParam();
                System.out.println("param被修改了");
            }

        });


        while (myThread.param == 10){

        }
        System.out.println(Thread.currentThread().getName()+"执行结束了");
    }

}
    class MyThread {
        /**
         * 被volatile修饰的参数被A线程修改后，另外一个线程会立马收到通知
         */
        int param = 10;


        public void changeParam() {
            this.param = 20;
        }
}