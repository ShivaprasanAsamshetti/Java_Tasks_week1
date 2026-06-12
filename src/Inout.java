import java.util.function.Function;

public class Inout {
    public static void main(String args[]) {
        int n = 5;
        Function<Integer, Integer> fn =
                num -> num * num;

        System.out.print(fn.apply(n));
    }
}
