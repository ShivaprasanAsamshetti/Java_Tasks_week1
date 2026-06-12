import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String args[]){
        List<Integer> l= Arrays.asList(2,4,5,1,3);
        l.sort((a1,a2)->Integer.compare(a2,a1));
        System.out.print(l);
    }
}
