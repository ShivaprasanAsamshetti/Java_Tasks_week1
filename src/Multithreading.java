
public class Multithreading implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("i "+ i);
        }
    }
    public static void main(String args[]){

        Multithreading obj=new Multithreading();
        Thread t1=new Thread(obj);
            t1.start();
            for(int j=1;j<=5;j++){
                System.out.println(Thread.currentThread().getName());
            }

    }
}



//
//public class Multithreading extends Thread {
//    public void run(){
//        for(int i=0;i<5;i++){
//            System.out.println("i "+ i);
//        }
//    }
//    public static void main(String args[]){
//        Multithreading obj=new Multithreading();{
//            obj.start();
//            for(int j=1;j<=5;j++){
//                System.out.println(j);
//            }
//        }
//    }
//}
