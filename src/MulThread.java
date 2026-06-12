public class MulThread  {

    public static void main(String args[]){
        Runnable in1=()->{
          for(int i=0;i<=10;i++){
              System.out.println(i);
          }
        };
        in1.run();
    }
}
