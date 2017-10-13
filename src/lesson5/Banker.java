package lesson5;
//1번
public class Banker {
    //은행원인 나는 리퀘스트 받은 게 오케이 인지 아닌지 체크--boolean이용
    //입금 요청 잘 됐나 안됐나?!?
    public boolean requestDeposit(DepositRequest req){
        Account account = req.getDepositAccount();
        if(!account.isDepositable()) return false; //계좌검증
        Money money = req.getMoney();
        if(Banker.isMinimum_imit(money)) return false;
        return true;
    }
    public static final Money MINIMUM = new Money(Currency.WON,100);
    private static boolean isMinimum_imit(Money money) {
        return money.getMoney(Currency.WON)< MINIMUM.getMoney(Currency.WON);
    }
}
