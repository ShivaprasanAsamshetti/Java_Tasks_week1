package Task1;

import java.util.function.Predicate;

interface salaryprocessor{
    double process(Employee emp);
}
class Employee  {
    private Integer employeeId;
    private String employeeName;
    private String department;
    private String role;
    private Integer experience;
    private Double salary;
    private Double performanceRating;

    public Employee(Integer employeeId,String employeeName,String department,String role,Integer experience, Double salary,Double performanceRating){
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.department=department;
        this.role=role;
        this.experience=experience;
        this.salary=salary;
        this.performanceRating=performanceRating;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                ", performanceRating=" + performanceRating +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getExperience() {
        return experience;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getPerformanceRating() {
        return performanceRating;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPerformanceRating(Double performanceRating) {
        this.performanceRating = performanceRating;
    }
}
public class Work{

   public static void main(String args[]){
      Employee obj=new Employee(1,"shiva","backend","developer",6,20000.0,5.0);

       salaryprocessor ref=(Employee obj2)-> {
           int per=0;
           double sal=obj2.getSalary();

           if(obj2.getPerformanceRating()>4.5){
               per+=20;
           }
           if(obj2.getExperience()>5){
               per+=15;
           }
           if(obj2.getRole().equals("developer")){
               per+=10;
           }
           if(obj2.getRole().equals("Testers")){
               per+=8;
           }
           if(obj2.getPerformanceRating()<3){
               per=0;

           }


           return per;
       };

       System.out.println("Employee "+obj.getEmployeeName());
       System.out.println("Role "+obj.getRole());
       System.out.println("old salary "+ obj.getSalary());
       System.out.println("Hike applied "+ref.process(obj)+"%");
       double hike=ref.process(obj);
       Predicate<Employee> deshike=(e)->e.getPerformanceRating()>=3;
       if(deshike.test(obj)){
           double newSal=(hike/100)*obj.getSalary()+obj.getSalary();
           obj.setSalary(newSal);
       }

       System.out.println("Final salary " +obj.getSalary());



   }
}