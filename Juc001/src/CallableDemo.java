import sun.awt.image.IntegerComponentRaster;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//该两个类 1返回值不同 2异常处理不同 3方法名不同
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*********come in callable");
        return 9527;
    }
}

/*
class MyThread2 implements  Runnable{

    @Override
    public void run() {

    }
}*/



public class CallableDemo {

    //第三种获得多线程的方式   Callable
    public static void main(String[] args) {
        //代表有返回值的  右键Diagrams 查看架构图
       // FutureTask<Integer> futureTask =new FutureTask<Integer>(new MyThread());

        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println("*********come in callable");
            return 9527000;
        });

        Thread T1 =new Thread(futureTask,"A");
        T1.start();
        try {
            System.out.println("**************retValue:"+ futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}


