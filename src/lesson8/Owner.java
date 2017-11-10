package lesson8;
//모든 변수는 기본적으로 final , 클래스는 다 보수적으로 .. 숨겨버렷..
//메소드, 클래스에 final 걸지 말아요.. 상속과 override가 되지 않아요. extend가 안되잖아요..
//우리는 점진적인 확장을 하기 때문에 ... 변수와 클래스는 보수적으로 , 상속,override는 그대로.
//디커플링 중간자 ; 추상메소드, 인터페이스
class Owner {
    private final int ownerValue;
    private final Base ownerBase;

    public Owner(int ownerValue, Base ownerBase) {
        this.ownerValue = ownerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //얕은 복사
        Owner result = new Owner(this.ownerValue, this.ownerBase);
        //깊은 복사
        result=new Owner(this.ownerValue, this.ownerBase.clone());
        return result;
    }

    public Base getBase() {
        return ownerBase;
    }
}
