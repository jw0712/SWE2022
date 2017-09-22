package LESSON3;

public class Constructor {

    private String firstName;
    private String lastName;

    public Constructor(){
        this("john", "doe");
    }
    public Constructor(String fname){
        this(fname, "doe");
    }
    public Constructor(String fname, String lname){
        firstName = fname;
        lastName = lname;
    }
    public String getName(){
        return firstName + " " + lastName;
    }
}