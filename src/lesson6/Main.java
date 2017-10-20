package lesson6;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Run implements Runnable{

        @Override
        public void run() {
            for(int i =0 ; i<1000 ; i++) Main.doWork();
        }

        /*private void doWork() {
        }*/
    }
    static class LengthComparator implements Comparator<String>{

        @Override
        public int compare(String first, String second) {
            return first.length()-second.length();
        }
    }
    static class EmployeeComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee first, Employee second) {
            return first.salary-second.salary;
        }
    }
    static void doWork(){}
    static public void main(String[] arg){
        Runnable task = new Run();
        /*인자없음*/
        Runnable task2 = ()-> {
            for (int i = 0; i < 2000; i++) doWork();
        };
        Comparator<String> comp1 = new LengthComparator();
        Comparator<String> comp2 = (f,s)->f.length()-s.length();

        Employee me = new Employee(100), you = new Employee(200);
        Employee[] members = {me, you};
        Arrays.sort(members, new EmployeeComparator());
        Arrays.sort(members,(f, s)->f.salary-s.salary);
        /*for(){
            Arrays.sort(members,(f,s)->f.salary-s.salary);
        }
        Arrays.sort(members,func);*/

    }

}
