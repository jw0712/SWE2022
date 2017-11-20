package com.jiwon.todo;

import java.time.LocalDate;
import java.time.Period;

public class TodoTask{
    /*가지고 있어야 할 것
    * 메소드: 완료여부 체크, 이름 수정하기, 미리 할일인지 알람해주기, 기한설정
    * 속성: 완료여부, 이름, 기한*/
    private String taskName;
    private boolean completed = false;
    private LocalDate deadline; //기본 마감기한은 오늘
    private LocalDate alarmTime=null;
    private final LocalDate creatingTime=LocalDate.now(); //생성 시점은 final

    //생성자
    public TodoTask(String taskName){
        this.taskName= taskName;
        this.completed = false;
        this.deadline = LocalDate.now();//오늘
        this.alarmTime = null;

    }




    //완료여부 체크
    public boolean isCompletedTask(TodoTask task){
        if (task.completed==true) return true;
        else
            return false;

    }
    //수동으로 완료 처리하기 + 완료 표시 (체크박스를 모르겠어서 완료 메시지 출력)
    public String taskComplete(TodoTask task){
        task.completed = true;
        return "task is completed";
    }
    //수동으로 미완료 처리하기
    public void taskNotComplete(TodoTask task){
        task.completed=false;
    }




    //기한 재설정1 날짜선택 시 (연,월,일)
    public void setSelectedDeadline(int yy, int mm, int dd){
        this.deadline=LocalDate.of(yy,mm,dd);
    }
    //기한 재설정2: 옵션 3가지 (오늘, 내일, 다음주(7일후))
    //today, tomorrow, nextWeek 셋 중 하나를 option에 입력
    public void setDeadlineOptions(String option){
        switch (option){
            case "today" : this.deadline=LocalDate.now(); break;
            case "tomorrow": this.deadline=LocalDate.now().plusDays(1);break;
            case "nextWeek": this.deadline=LocalDate.now().plusWeeks(1);break;
            default: System.out.println("plz enter option: today, tomorrow, or nextWeek");
        }
    }



    //알림타임 설정
    public void getAlarmTime(int yy, int mm, int dd){
        this.alarmTime = LocalDate.of(yy,mm,dd);
    }
    //알림 타임 삭제
    public void removeAlarmTime(){
        this.alarmTime=null;
    }
    //미리 알림 시간이 되었는가 확인
    private boolean check(){
        if (this.alarmTime==null) return false;//알람타임이 없다
        if (this.alarmTime.compareTo(LocalDate.now())<=0) return false; //미리 알림 시간을 현재보다 과거로 설정할 경우
        return LocalDate.now().equals(this.alarmTime);
    }
    //미리 알림 해주기
    public boolean isAlarm(TodoTask task){
        if (task.check()==true) return true;
        else return false;
    }



    public String getName() {
        return this.taskName;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public LocalDate getCreatingTime() {
        return creatingTime;
    }

    public boolean getCompleted() {
        return this.completed;
    }
}
