


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//消费者产生者模式   synchronized   lock 2种模式。
public class ThreadWaitNotifyDemo {
//题目：现在两个线程，可以操作初始值为0的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
    //  实现交换，来10轮，变量初始值为0.

    //高内聚 低耦合： 线程 操作 资源类
    //              判断 干活  互通知

    // 避免虚假唤醒    线程之间的横向通信  if换成 while
    //if只判断一次 while是要多次判断

    public static void main(String[] args) {

        ShareResource sr = new ShareResource();

        new Thread(() -> {

            for (int i = 1; i <= 10; i++) {
                try {
                    sr.increment();

                    //让线程休息0.2秒
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, "A线程").start();


        new Thread(() -> {

            for (int i = 1; i <= 10; i++) {
                try {
                    sr.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, "B线程").start();


        new Thread(() ->

        {

            for (int i = 1; i <= 10; i++) {
                try {
                    sr.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, "C线程").

                start();


        new

                Thread(() ->

        {

            for (int i = 1; i <= 10; i++) {
                try {
                    sr.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }, "D线程").

                start();

    }

}

class ShareResource {
    private int number = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            //判断
            while (number == 0) {
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

   /* public synchronized void increment() throws Exception {
        //1判断
       while (number != 0) {
            this.wait();
        }
        //2干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3去通知

        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        //1判断
       while (number == 0) {
            this.wait();
        }
        //2干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3去通知

        this.notifyAll();
    }
*/

    }
}