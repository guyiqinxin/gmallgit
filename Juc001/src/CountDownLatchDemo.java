import java.util.concurrent.CountDownLatch;

//数字下降开始 做减法  秦灭六国 一统华夏（班长锁门 ）
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch   = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                    try{
                        System.out.println(Thread.currentThread().getName()+"国被灭");
                        //离开一个减少一个
                        countDownLatch.countDown();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                      },CountryEnum.forEach_countryEnum(i).getRetMessage()).start();

                     }

                     //加入await()方法
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"**************一统华夏");
        System.out.println(CountryEnum.ONE.getRetMessage());
        System.out.println(CountryEnum.TWO.getRetCoDE());
        System.out.println(CountryEnum.THREE.getRetMessage());
        System.out.println(CountryEnum.FOUR);
        System.out.println(CountryEnum.FIVE);
        System.out.println(CountryEnum.SIX);
        }

    }

