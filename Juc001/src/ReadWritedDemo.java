import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//多线程读写分离   写保证独占性 读保证共享性
public class ReadWritedDemo {
/*    多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
   但是如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
  小总结：
            读-读能共存
            读-写不能共存
            写-写不能共存
      飞机1 和 2 楼 分离。在同一楼
             */
public static void main(String[] args) {

    Mycache mycache = new Mycache();

    for (int i = 1; i <=5; i++) {
        final int temp = i;
        new Thread(() -> {
            try {
                mycache.writerput(temp + "", temp + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, String.valueOf(i)).start();

    }
    for (int i = 1; i <=5; i++) {
        final int temp = i;
        new Thread(() -> {
            try {
                mycache.readget(temp+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, String.valueOf(i)).start();

    }

}
}

class Mycache {
    //volatile 保持可见性
    private volatile Map<String, Object> map = new HashMap<>();


    //JUC 里ReadWrite中的读写锁
    ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    //普通的写方法
    public void writerput(String key, Object value) {

        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写" + key);

            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
        System.out.println("************************************");
    }

    //普通的读方法
    public Object readget(String key) {
        rwlock.readLock().lock();
        Object result = null;
        try {

            System.out.println(Thread.currentThread().getName() + "正在读");

            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读完成" + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
        return result;
    }
}