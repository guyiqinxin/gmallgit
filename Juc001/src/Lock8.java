import org.jcp.xml.dsig.internal.dom.DOMUtils;
import org.omg.PortableServer.THREAD_POLICY_ID;

class Phone{

        public  synchronized  void sendSMS()throws Exception{
            System.out.println("***********发短信！");
        }


        public  synchronized  void sendEMAIL()throws Exception{
            System.out.println("***********发邮件！");
        }

}




public class Lock8 {
    public static void main(String[] args)throws InterruptedException {

    Phone phone =new Phone();

    new Thread(()->{
        try {
            phone.sendSMS();
        } catch (Exception e) {
            e.printStackTrace();
        }

    },"A线程").start();

     new Thread(()->{
        try {
           phone.sendEMAIL();
        } catch (Exception e) {
            e.printStackTrace();
        }

    },"B线程").start();
}

}


