package com.atguigu.gmall.gmallmqtest;

public class TestMyThread {
    public static void main(String[] args) {
        MyThread my1 = new MyThread();
        my1.start();

        MyThread my2 = new MyThread();
        my2.start();

        for (int i = 10; i >= 1; i--) {
            System.out.println(Thread.currentThread().getName() + "线程：" + i);
        }
    }
}
class MyThread extends Thread{
    public void run(){
        for (int i = 1; i <= 10; i++) {
             System.out.println(super.getName() + "线程：" + i);
        }
    }
}
