package lesson4;

import lesson4.sample.imported;

public class StaticInnerClass {
    private static class Class1{//StaticInnerClass만 알고싶다구여!!
        static class Class1Class1{}
        Class1(){
            System.out.println(imported.getText());
        }

    }
    static class Class2{
        static class Class2Class1{}


    }
    static public void main(String[] arg){
        //Class1 c= new Class1();
        lesson4.StaticInnerClass.Class1.Class1Class1 c = new StaticInnerClass.Class1.Class1Class1();
        ////qualitified full name
        System.out.println(imported.getText());



    }
}
