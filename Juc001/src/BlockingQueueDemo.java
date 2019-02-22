import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
//消费者生产者  阻塞队列
//以前的等待唤醒相当于手动挡 现在的BlockingQueue相当于自动挡 一切准备好了
    //上帝视角
    public static void main(String[] args) {
        //有界阻塞队列  例如  List list = new ArrayList();等等
        //触类旁通  不谋全局者，不足谋一域。  不谋大事者，不足谋一时。
        BlockingQueue blockingQueue =new ArrayBlockingQueue(3);
    }

}
