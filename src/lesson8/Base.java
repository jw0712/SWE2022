package lesson8;

class Base {
    int baseValue;

    public Base(int baseValue){
        this.baseValue=baseValue;

    }
    @Override
    //gpu 등은 클론이 불가능한 애들은 못해요,,
    protected Base clone() throws CloneNotSupportedException{
        return new Base(this.baseValue);
    }

    @Override
    public boolean equals(Object obj) { //기본형은 아님. object 타입이니까
        if(obj==null) return false; //가장 부하가 적고 가장 첫번째로 체크해야 하기 때문에 제일 먼저 배제. 안전.
        if(!(obj instanceof Base)) return false; //같은 클래스에서 태어났니? 메소드 호출 안했으므로 더 가벼워!
        if (obj.hashCode()==this.hashCode()) return true; //같은 객체면 해시코드가 같아야 하므로. 메소드 호출!
        return this.baseValue==((Base)obj).baseValue; //shield pattern, validation.
    }

    @Override
    public String toString(){
        return "base: "+this.hashCode()+"value: "+this.baseValue;
    }
}
