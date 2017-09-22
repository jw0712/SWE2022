package LESSON3;

public class Constructor {
    private String firstName;
    private String lastName;

    public Constructor(){
        this(Constructor("john", "doe"));

    }
    public Constructor(String fname){
        Constructor(fname," ");


    }
    public Constructor(String fname, String lname){
        firstName = fname;
        lastName = lname;


    }
    public String getName(){
        return firstName + " " +lastName;
    }
}
