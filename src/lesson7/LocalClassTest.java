package lesson7;

import java.util.Random;

public class LocalClassTest {
    static public void main(String[] args){
        IntSquence seq = randomints(3,5);
        System.out.println(seq.next());
    }
    private static Random generator = new Random();
    public static IntSquence randomints(int low, int high){
        return()-> low + generator.nextInt(high-low+1); //람다 최고~ 함수형 인터페이스니까 람다 표현식으로
    }
}
