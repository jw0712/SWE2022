package lesson6;

public class FunctionalMain {
    static public void main(String[] args){
        Employee me = new Employee(2000), you = new Employee(5000);
        //R U loser?
        if (EmployeeTest.test(me, (employee)->employee.salary>3000)) {
            System.out.println("ok");
        }else System.out.println("loser");

        if (EmployeeTest.test(you, (employee)->employee.salary>2000)) {
            System.out.println("ok");
        }else System.out.println("loser");
    }
}
