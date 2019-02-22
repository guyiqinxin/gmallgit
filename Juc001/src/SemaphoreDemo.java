import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    //信号灯 抢车位多对多  占用 释放
    public static void main(String[] args) {

        //模拟3个车位
        Semaphore semaphore =new Semaphore(3);
        //模拟有6个车
        for (int i = 1; i <6; i++) {
            new Thread(()->{
                try{
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                        //线程暂停一会
//                              try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                         Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                        semaphore.release();
                }
                  },String.valueOf(i)).start();

                 }
        }
    }

