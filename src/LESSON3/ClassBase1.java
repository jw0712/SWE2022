package LESSON3;

public class ClassBase1 {
    static public void main(String[] arg){
        Constructor c = new Constructor();
        System.out.println(c.getName());
        System.out.println(c.getFriend(0));

        Constructor c1 = new Constructor("jiwon");
        System.out.println(c1.getName());
        System.out.println(c1.getFriend(0));

        Constructor c2 = new Constructor("jiwon", "choi");
        System.out.println(c2.getName());
        System.out.println(c2.getFriend(0));
    }
}