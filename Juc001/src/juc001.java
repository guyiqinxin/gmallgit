import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//企业级多线程 用Lock 和Runnable 代替了synchronized
//take is cheap ,show me your code!

public class juc001 {

    //    线程 操作 资源类  高内聚 低耦合
    public static void main(String[] args) {
       /* Thread(Runnable target, String name) Allocates a new Thread object.*/


        Ticket ticket = new Ticket();

        new Thread(() -> {  for (int i = 1; i <=40; i++)   ticket.sale();}, "A售票员").start();
        new Thread(() -> {  for (int i = 1; i <=40; i++)   ticket.sale(); },"B售票员").start();
        new Thread(() -> {  for (int i = 1; i <= 40; i++)  ticket.sale(); },"C售票员").start();


       /* //匿名内部类
       //CodeRecview 代码走查和演习
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "A售票员").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "B售票员").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "C售票员").start();*/

    }


}

class Ticket {
   //100张票
    private int number = 100;
    // 实现Lock锁 实现类
     Lock lock = new ReentrantLock();
    //资源类 卖票方法    低耦合的人通过高内聚资源类里的方法
    public void sale() {
        //相当于synchronized()锁方法
        lock.lock();
        try {
            //判断票大于0，输出卖票量
            if (number > 0) {

                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "张票" + "还剩下" + number + "张票");

            }
        } finally {
            lock.unlock();
        }

    }


}