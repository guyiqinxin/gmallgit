public class LambdaExer {
//符合函数式接口，都可以用函数式编程 落实实现都可以用lambda表达式
    //理论 代码 小总结

//函数式接口  接口里有且只有一个方法
//拷贝小括号，写死右箭头，落地大括号。
//逆水行舟 不进则退  你想要和平吗？就准备战争吧，你想要不被淘汰吗？就准备学习吧！
//显示函数式接口 @FunctionalInterface
    @FunctionalInterface
    interface  Foo{

      //  public void sayHello();

        public  int add(int x , int y );

    //java 1.8以后 函数式接口允许有多个default方法
        public  default int div1(int x,int y){
            return x/y;
        }
    //java 1.8以后 函数式接口支持有静态方法
        public  static  int  mul(int x,int y){
            return  x*y;
        }
    }



    public static void main(String[] args) {

       /*     Foo foo = new Foo() {
                @Override
                public void sayHello() {
                    System.out.println("**********Hello,lambda表达式");
                }
              foo.sayHello();*/



     /*   foo = () -> {  Syste m.out.println("**********Hello,lambda表达式2"); };
            foo.sayHello();*/

         /*   Foo foo =new Foo() {
                @Override
                public int add(int x, int y) {

                    return 12345;
                }
            };
            */
         Foo foo =(int x , int y ) ->{
             System.out.println("**********come in ");
             return  x+y;
         };
        System.out.println(foo.add(3,5));
        System.out.println(foo.div1(10,5));
        //静态方法 类名.方法名
        System.out.println(Foo.mul(3,5));
    }
}
