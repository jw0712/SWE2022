package com.jiwon.todo;




import java.io.InputStream;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.in;

public class TodoMain {
    public static void main(String[] args){

        //집에서 할 일 3가지 : 청소, 빨래, 쓰레기통 비우기
        TodoList home= new TodoList("home");
        TodoTask cleaning = new TodoTask("cleaning");
        TodoTask laundry = new TodoTask("laundry");
        TodoTask trash = new TodoTask("trash");
        home.addTask(cleaning);
        home.addTask(laundry);
        home.addTask(trash);

        //학교 과제 2가지: 과제1 커밋, 에세이 작성
        TodoList assignment = new TodoList("assignment");
        TodoTask task1 = new TodoTask("task1");
        TodoTask essay = new TodoTask("essay");
        assignment.addTask(task1);
        assignment.addTask(essay);


        TodoApp app= new TodoApp("app");

        //remove확인 : 잘 실행됨
       // System.out.println("\n"+"remove 확인:빈 목록에서 삭제");
        //app.removeList(assignment);

        //테스트 앱에 집에서 할일, 학교과제 추가
        app.addList(home);
        app.addList(assignment);

        //알림 설정해주기
        trash.setAlarmTime(2017,12,1);
        task1.setAlarmTime(2017,12,3);

        //데드라인 설정 (사용자가 설정함)
        laundry.setSelectedDeadline(2017,12,10);
        cleaning.setDeadlineOptions("tomorrow");
        essay.setDeadlineOptions("nextWeek");
        task1.setSelectedDeadline(2017,12,15);

        //완료여부 처리해보기
        laundry.complete(laundry);
        essay.incomplete(essay);


        //addList확인 . 주말에 할 일 리스트를 추가해 봄. (4 tasks)
        TodoList weekend = new TodoList("weekend");
        TodoTask goingCafe = new TodoTask("goingCafe");
        TodoTask meetFriends = new TodoTask("meetFriends");
        TodoTask nap = new TodoTask("nap");
        TodoTask buyClothes = new TodoTask("buyClothes");
        weekend.addTask(goingCafe);
        weekend.addTask(meetFriends);
        weekend.addTask(nap);
        weekend.addTask(buyClothes);
        app.addList(weekend);

        /*//remove확인
        System.out.println("\n"+"remove 확인:목록에 있는 것 삭제");
        app.removeList(weekend);
        app.getSimpleInfoOfLists();
        System.out.println("\n"+"remove 확인:목록에 없는 것 삭제"); //잘 실행됨.
        app.removeList(weekend);*/






        //scanner-----------------------------------------------------------------------

        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        TodoList list= null;
        TodoTask task = null;

        System.out.println("현재 app 내의 리스트 목록과 태스크 개수");
        app.getSimpleInfoOfLists();

        System.out.println("app 내에서 메서드를 적용할 List이름을 입력하여 주세요:");
        try {
            String listname = in.next();
            list = app.findList(listname);
        }catch(IllegalArgumentException ex) {System.out.println("해당 리스트가 app에 존재하지 않습니다. " +
                "새로운 리스트를 처리하고 싶은 경우, addList를 진행한 후 다시 시도해주세요.");}

        System.out.println("현재 포인터는 이 리스트를 가리키고 있습니다. " +
                "리스트를 바꾸고 싶으시면 'changeList:'를 입력 후 리스트 이름을 입력하세요.");
        System.out.println(list.getName());


        exit:
        while (true) {
            in.reset();
            while (in.hasNext()) {
                String s = in.next();

                //addList:리스트명 형식의 입력을 받아 리스트를 app에 추가한 뒤 app 출력
                if(s.startsWith("addList:")){
                    s=s.substring(8);
                    TodoList s1 = new TodoList(s);
                    app.addList(s1);
                    app.getSimpleInfoOfLists();
                }
                //list:리스트명 형식의 입력을 받아 해당 리스트를 출력
                else if (s.startsWith("list:")){
                    s=s.substring(5);
                    list=app.findList(s);
                    System.out.println(list.getName()+"의 task 세부사항은 아래와 같습니다.");
                    list.viewTaskDetails();
                }

                /*addTodo:할일명,날짜,알림날짜 명령을 입력받아 todo를 해당 리스트에 추가하고 다시 3번을 출력한다.
                -아예 새롭게 다 재설정하는 것인지,<-일단 이걸로 처리.
                -이미 task는 있는데 기한 혹은 알림 날짜를 수정하고자 한다는 것인지<-addTodo보다는 editTodo가 더 나을 듯

                -입력형식: 할일명,20170101,20170102  콤마로 구분
                -입력예시1: buyFlowers,20171201,20171130 -> buyFlowers : 기한 2017.12.01 , 알림날짜: 2017,11,30
                -입력예시2: buyFlowers,20171201,스페이스바 -> buyFlowers: 기한 2017.12.01, 알림 미설정
                -입력예시3: buyFlowers,, -> buyFlowers: 기한 오늘, 알림 미설정*/

                else if (s.startsWith("addTodo:")) {
                    System.out.println("이 task는 " + list.getName() + "에 추가되었습니다.");
                    String temp = s.substring(8);
                    String[] tempSplit = s.substring(8).split(",");
                    TodoTask addTodoTask= new TodoTask(tempSplit[0]);


                    if (tempSplit.length==1) list.simpleAddingTask(list, temp);
                    else if (tempSplit.length==2){
                        list.simpleAddingTaskwoAlarm(list, temp);
                    }else list.simpleAddingTaskwAlarm(list, temp);

                    list.viewTaskDetails();
                }

                else if (s.startsWith("changeList:")){
                    s=s.substring(11);
                    list=app.findList(s);
                    System.out.println("현재 포인터가 가리키는 리스트는 "+list.getName()+"입니다.");
                }
                else if (s.startsWith("complete:")){
                    s=s.substring(9);
                    task=list.findTask(s);
                    task.complete(task);
                    System.out.println("complete: "+task.getName());
                }
                else if (s.startsWith("incomplete:")){
                    s=s.substring(11);
                    task=list.findTask(s);
                    task.incomplete(task);
                    System.out.println("incomplete: "+task.getName());
                }
                else if (s.startsWith("exit")){
                    break exit;
                }
                }
            }
        }


    }


