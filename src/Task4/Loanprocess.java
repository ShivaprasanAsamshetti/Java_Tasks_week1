package Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface LoanRule {
    boolean validate(Customer customer);

    default LoanRule and(LoanRule other) {
        return customer -> this.validate(customer) && other.validate(customer);
    }

    default LoanRule or(LoanRule other) {
        return customer -> this.validate(customer) || other.validate(customer);
    }

    default LoanRule negate() {
        return customer -> !this.validate(customer);
    }
}

public class Loanprocess {
    public static void main(String args[]){
        Customer customer=new Customer(1,"shiva",21,60000.0,780,5000.0,"Business",30000.0);
        Predicate<Customer> age= o->o.getAge()>=21 && o.getAge()<=60;
        Predicate<Customer> salaryRule=salary->salary.getMonthlySalary()>50000;
        Predicate<Customer> creditscore=credit->credit.getCreditScore()>=750;
        Predicate<Customer> emi=e->e.getExistingEmi()<(e.getMonthlySalary() * 0.40);
        Predicate<Customer> loan=lo->lo.getRequestedLoanAmount()<=20*lo.getMonthlySalary();
        Predicate<Customer> emptype=em->em.getEmploymentType().equalsIgnoreCase("business") || em.getEmploymentType().equalsIgnoreCase("salaried");

        Predicate<Customer> result=age.and(salaryRule)
                                        .and(creditscore)
                                        .and(emi)
                                        .and(loan)
                                        .and(emptype);

        List<String> li=new ArrayList<>();
        if(!age.test(customer))
            li.add("Age must be between 21 and 60");
        if(!salaryRule.test(customer))
            li.add("Monthly salary must be greater than 50000");
        if(!creditscore.test(customer))
            li.add("credit score is below 750");
        if(!emi.test(customer))
            li.add("Existing EMI is more than allowed limit");
        if(!loan.test(customer))
            li.add("Requested loan amount is exceeded limit");
        if(!emptype.test(customer))
            li.add("Employement type must be salaried or business");

        if(li.isEmpty()){
            System.out.println(customer.getCustomerName());
            System.out.println("is Approved");
        }
        else{
            System.out.println(customer.getCustomerName());
            System.out.println("Rejected");
            System.out.println("Failed Rules");
            li.forEach(System.out::print);
        }


    }
}
