package LESSON3;

public class Parent {
    private Strig name="";

    public String mutator(String v){
        name+=v;
        return name;


    }
    public String getName(){
        return name;

    }
    public String action(){
        return "parent" ;
    }
}
