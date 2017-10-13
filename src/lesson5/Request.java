package lesson5;
//2번
public interface Request {
    //속성, 생성자 생성 불가능!
    //뭘 보장해야 할까요??
    Customer getCustomer();
    Money getMoney();

}
//인터페이스를 정의해야!!!!! 나머지 클래스들을 구현할 때 헷갈리지 않아요!