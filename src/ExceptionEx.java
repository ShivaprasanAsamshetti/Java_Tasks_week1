public class ExceptionEx {
    public static void main(String args[]){
        int i=0;
    try {
        System.out.print(5 / i);
    }
    catch(ArithmeticException e){
        System.out.print(e.getMessage());
    }
    System.out.print(1);
    }
}
