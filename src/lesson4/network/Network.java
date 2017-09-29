package lesson4.network;

import java.util.ArrayList;

public class Network {
    public class Member{

        final.private String name; //한번 선언하면 절대 바뀌지 않는다 이름 못바꿔요!
        private ArrayList<Member> friends; //원소가 되는 아이의 클래스 이름을 <>안에 넣어준다

        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();

        }

        }
        public void leave(){
            members.remove(this);

        }
    }
    //Network-------------------------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        //this == new Network() == net1 == newMember.outer
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
    public void remove(Member member){
        members.remove(member);
    }
}
