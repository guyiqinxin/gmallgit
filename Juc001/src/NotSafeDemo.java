import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotSafeDemo {

//举例说明集合类是不安全的
    //ArrayList 没用同步机制  写比读快
    public static void main(String[] args) {

      /*  List<String> list = Arrays.asList("A","B","C");
        list.forEach(System.out::println);*/
        List<String> list =new ArrayList<>();

       /* 不用解决方案  List<String> list =new Vector();
                   List<String> list =new collections.synchronizedList(new ArrayList());可以但不用*/

        /* 解决方案：！！！！写时复制技术！
        List<String> list =new CopyOnWriteArrayList<>();*/
                        //new CopyOnWriteArraySet<>()
       /* list.add("a");
        list.add("b");
        list.add("c");*/
        for (int i = 1; i <=3 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,4));

                System.out.println(list);

            },String.valueOf(i)).start();
        }


    }
}
//常见的异常 java.util.ConcurrentModificationException

/**笔记   写时复制
 CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素之后，
 再将原容器的引用指向新的容器 setArray(newElements);。这样做的好处是可以对CopyOnWrite容器进行并发的读，
 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 public boolean add(E e)
 {
 final ReentrantLock lock = this.lock;

 lock.lock();

 try
 {
 Object[] ele ments = getArray();
 int len = elements.length;
 Object[] newElements = Arrays.copyOf(elements, len + 1);
 newElements[len] = e;
 setArray(newElements);
 return true;
 }
 finally
 {
 lock.unlock();
 }
 }
 */