import java.util.function.Predicate;

    class PredefinedFunction {
        public static void main(String args[]){
            String[] names={"Anushka", "Anupama", "Deepika", "Kajol", "Sunny"};
            Predicate<String> pre= p->p.charAt(0)=='A';

            for(String s:names) {
                System.out.println(pre.test(s));
            }



        }
    }


