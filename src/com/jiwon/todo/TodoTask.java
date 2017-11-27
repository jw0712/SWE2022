package com.jiwon.todo;

import java.time.LocalDate;

public class TodoTask{
    /*가지고 있어야 할 것
    * 메소드: 완료여부 체크, 이름 수정하기, 미리 할일인지 알람해주기, 기한설정
    * 속성: 완료여부, 이름, 기한
    */


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


    //이름 수정
    public void setName(String taskName){
        this.taskName = taskName;
    }



    //완료여부 체크
    public boolean isCompletedTask(TodoTask task){
        if (task.completed==true) return true;
        else
            return false;

    }
    //수동으로 완료 처리하기
    //complete(taskname): 할일 이름을 받아 해당 task.completed = true 후 완료상태, 이름 리턴

    public void complete(TodoTask task){
        task.completed = true;

    }
    //수동으로 미완료 처리하기
    //incomplete(taskname): task.incompleted로 처리 후 완료상태, 이름 리턴
    public void incomplete(TodoTask task){
        task.completed=false;
    }




    //기한 재설정1 날짜선택 시 (연,월,일)
    public void setSelectedDeadline(int yy, int mm, int dd){
        this.deadline=LocalDate.of(yy,mm,dd);
    }
    //기한 재설정2: 옵션 3가지 (오늘, 내일, 다음주(7일후))
    //today, tomorrow, nextWeek 셋 중 하나를 option에 입력
    public void setDeadlineOptions(String option) throws IllegalArgumentException{
        switch (option){
            case "today" : this.deadline=LocalDate.now(); break;
            case "tomorrow": this.deadline=LocalDate.now().plusDays(1);break;
            case "nextWeek": this.deadline=LocalDate.now().plusWeeks(1);break;
            default: throw new IllegalArgumentException("today, tomorrow, nextWeek 중 하나를 입력하여 주십시오.");
        }
    }



    //알림타임 설정
    public void setAlarmTime(int yy, int mm, int dd) throws IllegalArgumentException{
        if (LocalDate.now().compareTo(LocalDate.of(yy,mm,dd))>0) throw new IllegalArgumentException("현재보다 과거의 시간에 알림을 설정할 수 없습니다.");
        this.alarmTime = LocalDate.of(yy,mm,dd);
    }
    //알림 타임 삭제
    public void removeAlarmTime(){
        this.alarmTime=null;
    }
    //미리 알림 시간이 되었는가 확인.
    private boolean check(){
        if (this.alarmTime==null) return false;//알람타임이 없음.
        return LocalDate.now().equals(this.alarmTime);
    }
    //미리 알림 해주기
    //task가 완료되면 알림시간이 완료시점보다 미래여도 알림 자체가 울리지 않음.(실제 todo앱) 알림 시간은 존재하나 울려줄 필요x
    public boolean isAlarm(TodoTask task){
        if (isCompletedTask(task)) return false;
        if (task.check()==true) return true;
        else return false;
    }



//getter 모음 --------------------------------------------------------------------------
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

    public LocalDate getAlarmTime(){
        return this.alarmTime;
    }




}
