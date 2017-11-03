package lesson7;

import java.util.Random;

public class LocalClassTest {
    static public void main(String[] args){
        IntSquence seq = randomints(3,5);
        System.out.println(seq.next());
    }
    private static Random generator = new Random();
    public static IntSquence randomints(int low, int high){
        class RandomSquence implements IntSquence{

            @Override
            public int next() {
                return low + generator.nextInt(high-low+1);
            }
        }
        return new RandomSquence();
    }
}
