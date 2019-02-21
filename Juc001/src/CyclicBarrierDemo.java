import java.util.concurrent.CyclicBarrier;
//循环屏障
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,() ->{
            System.out.println(Thread.currentThread().getName()+"召唤神龙");
        });

        for (int i = 1; i <=7 ; i++) {
            //lambda表达式必须用final修饰
                    final  int tempInt = i;
                    new Thread(()->{
                            try{
                                System.out.println(Thread.currentThread().getName()+"收集"+tempInt+"龙珠");
                                cyclicBarrier.await();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                              },String.valueOf(i)).start();

                             }
        }

    }

