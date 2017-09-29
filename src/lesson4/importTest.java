package lesson4;

import lesson4.sample.imported;
//import lesson4.sample.imported.*;
import lesson4.StaticInnerClass.Class2.Class2Class1;

public class importTest {
    static public void main(String[] arg){
        System.out.println(lesson4.sample.imported.getText()) ;
        //System.out.println(imported.getText());
        //System.out.println(getText());

        StaticInnerClass.Class2 c = new StaticInnerClass.Class2();
        Class2Class1 c2 = new Class2Class1();
    }
}
