/*package lesson7;

public class AbstractClassTest {
    static abstract class Person{
        private String name;
        /*public Person(){this.name="";}
        public Person(String name){this.name=name;}
        public final String getName(){return name;}

        public abstract int getId();
        //바디가 없음. 인터페이스와 비슷하지만, 가시성을 지정할 수 있다는 것이 특징.(public/private/protected ...)
        // abstract class 에서만 abstract method 선언 가능. 일반 클래스에서는 abstract method 선언 불가능.

        }
    static abstract class Student extends Person{
        private int id;
        public Student(String name, int id) {
            //super(name); //superset의 생성자를 반드시 호출할 책임이 있다.. 가장 앞에 반드시 가잦ㅇ 앞에!!
            this.id=id;
        }
    }
    static public void main(String[] arg){
        //익명 클래스 : 중괄호 안에 override // 익명 클래스로는 new 때릴 수 있어욤
        Person a = new Person("jiwon"){
            //바디가 하나넴...? 생성자가 인자를 받지 않아야 함수형 인터페이스로 할 수 있죵
            @Override
            public int getId() {
                return 0;
            }
        };
        //Person p2 = ()->0; //abstract class는 람다로 쓸 수 없어욤. 인터페이스만 람다로 받을 수 있어욤.
    }
}
*/