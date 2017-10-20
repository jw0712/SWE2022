package lesson6;
//해당 종업원이 제대로된 종업원 형태를 갖추고 있는가를 확인
//인터페이스여도 상관 없음

import java.util.function.Predicate;

public interface EmployeeTest {
    static public boolean test(Employee em, Predicate<Employee> tester){
        return tester.test(em);

    }


}
