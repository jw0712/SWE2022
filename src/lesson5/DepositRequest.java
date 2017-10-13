package lesson5;
//4번
//입금 관련 리퀘스트 형식이긴 하지만 Request랑 똑같자나요!?! 고객이름하고 금액 받아야하잖아요?? 상속(확장)ㄲㄱ
public interface DepositRequest extends Request {
    Account getDepositAccount(); //입금할 때는 입금계좌가 필요한데요
    //야 Account가 알아서 다 해줘
}
