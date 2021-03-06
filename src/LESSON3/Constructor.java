
package LESSON3;

import java.util.ArrayList;

public class Constructor {

    final String firstName;
    private final String lastName;
    private String seperator;
    private ArrayList<String> friends;
    {
        seperator=" ";

    }
    {
        friends = new ArrayList<>();
        friends.add("jane");
        friends.add("tom");
    }

    public Constructor(){
        this("john", "doe");
    }
    public Constructor(String fname){
        this(fname, "doe");
    }
    public Constructor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }
    static public int plus(int a, int b){
        return a+b;
    }
    public String getName(){
        int a = this.plus(3,5);
        int b = plus(6,7);
        int c = Constructor.plus(6,7);

        //return firstName + " " + lastName;
        return this.firstName+this.seperator+this.lastName;
    }
    public String getFriend(int index){
        return this.friends.get(index)+" is "+this.getName() + "'s friend.";
    }
}