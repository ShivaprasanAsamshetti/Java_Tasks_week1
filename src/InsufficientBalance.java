public class InsufficientBalance extends Exception {//checked custom exception
    public InsufficientBalance(String s){
        super(s); //storing that message in parent exception
    }

}

class Bankaccount{
    private double bal;
    Bankaccount(double bal){
        this.bal=bal;
    }
    public void withdraw(double money){
        
    }
}
