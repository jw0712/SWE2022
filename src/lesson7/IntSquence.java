package lesson7;

public interface IntSquence {
    int next();
    default boolean hasNext(){return true;}

}
