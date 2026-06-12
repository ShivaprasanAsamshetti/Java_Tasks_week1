import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Upper {

    public static void main(String args[]){
        List<String> l= Arrays.asList("shiva","prasan","karthik");

        Consumer<String> c1= li->System.out.print(li.toUpperCase());

        for(String s:l){
            c1.accept(s+" ");
        }
    }
}
