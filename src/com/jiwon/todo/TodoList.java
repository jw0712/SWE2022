package com.jiwon.todo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TodoList implements Serializable {
    /*가지고 있어야 할 것
    속성: 이름, task목록, 테마
    메소드: 이름 수정, 정렬하기, 테마 변경, 목록 삭제, 할일 추가, 빈목록출력(getlist)
    <과제3>
    addTodo (taskname, deadline, alarmDate) : todoList에 추가하고 리스트 출력
          출력 형식: [완료여부] 할일명, 완료일, 데드라인, 알림여부
    */


    private String listName;
    ArrayList<TodoTask> todoTasks = new ArrayList<>();
    private TodoTheme listTheme;
    boolean listSorted;


    //생성자
    public TodoList(String listname){
        this.listName=listname;
        this.todoTasks = new ArrayList<>();
        this.listSorted = false;
        this.listTheme = new TodoTheme();
    }



    //이름 재설정하기
    public void setListName(String newName){
        this.listName=newName;
    }


    //정렬 방식
    public enum sorting {CHR, REVERSE_CHR, DEADLINE,REVERSE_DEADLINE, CREATINGTIME, REVERSE_CREATINGTIME, COMPLETED, REVERSE_COMPLETED};
    public void sortTask(sorting sortingOption){
        this.listSorted = true;
        switch(sortingOption){
            case CHR:Collections.sort(todoTasks, sortByChr);
                break;
            case REVERSE_CHR:
                Comparator sortByChr2 = Comparator.reverseOrder();
                Collections.sort(todoTasks,sortByChr2);
                break;
            case DEADLINE:Collections.sort(todoTasks, sortByDeadline);
                break;
            case REVERSE_DEADLINE:
                Comparator sortByDeadline2 = Comparator.reverseOrder();
                Collections.sort(todoTasks, sortByDeadline2);
                break;
            case CREATINGTIME:Collections.sort(todoTasks, sortByCreation);
                break;
            case REVERSE_CREATINGTIME:
                Comparator sortByCreation2 = Comparator.reverseOrder();
                Collections.sort(todoTasks, sortByCreation2);
                break;
            /*case COMPLETED:Collections.sort(todoTasks, sortByCompleted);
                break;
            case REVERSE_COMPLETED:
                Comparator sortByCompleted2 = Comparator.reverseOrder();
                Collections.sort(todoTasks, sortByCompleted2);
                break;*/
        }
    }



    //테마변경
    public void changeThemeColor(TodoTheme.TodoThemeColors newColor){
        listTheme.changeThemeColor(newColor);
    }
    public void changeThemeImage(TodoTheme.TodoThemeImages newImage){
        listTheme.changeThemeImage(newImage);
    }



    //목록삭제 . 요청한 task가 목록 안에 있을 때만 삭제
    public void removeTask(TodoTask task){
        if (todoTasks.contains(task)) {this.todoTasks.remove(task);}
    }



    //할일 추가
    public void addTask(TodoTask newTask){
        this.listSorted=false;
        todoTasks.add(newTask);
    }





    //간편하게 Todotask 설정해보기! - 리스트의 addTodo를 처리하기 위함
    //s 형식: taskName,20180110,20171223 콤마로 구분
    //1. 태스크 이름만 왔을 때
    public void simpleAddingTask(TodoList list, String s){
        String[] temp = s.split(",");
        TodoTask task = new TodoTask(temp[0]);
        list.addTask(task);
    }

    //2. 태스크 이름과 데드라인만 왔을 때
    public void simpleAddingTaskwAlarm(TodoList list, String s){
        String[] temp = s.split(",");
        TodoTask task = new TodoTask(temp[0]);

        int yy = Integer.parseInt(temp[1].substring(0,4));
        int mm = Integer.parseInt(temp[1].substring(4,6));
        int dd = Integer.parseInt(temp[1].substring(6));
        task.setSelectedDeadline(yy,mm,dd);

        int ayy = Integer.parseInt(temp[2].substring(0,4));
        int amm = Integer.parseInt(temp[2].substring(4,6));
        int add = Integer.parseInt(temp[2].substring(6));
        task.setAlarmTime(ayy,amm,add);

        list.addTask(task);

    }//3.태스크 이름, 데드라인, 알림시간까지 왔을 때
    public void simpleAddingTaskwoAlarm(TodoList list, String s){
        String[] temp = s.split(",");
        TodoTask task = new TodoTask(temp[0]);
        int yy = Integer.parseInt(temp[1].substring(0,4));
        int mm = Integer.parseInt(temp[1].substring(4,6));
        int dd = Integer.parseInt(temp[1].substring(6,8));
        task.setSelectedDeadline(yy,mm,dd);
        list.addTask(task);
    }




    //todoApp.list(listname)을 처리하기 위한 메서드. task에 관한 모든 디테일을 보여줌.
    public void viewTaskDetails() {
        if (todoTasks.isEmpty()) throw new EmptyListException("Task를 추가하여 주십시오.");

        for (int i = 0; i < todoTasks.size(); i = i + 1) {
            TodoTask tempTask = todoTasks.get(i);
            //완료여부 체크박스
            String checkbox = "[-]";
            if (tempTask.getCompleted() == true) {
                checkbox = "[0]";
            }
            //할일 이름
            String tempTaskName = tempTask.getName();
            //데드라인
            String tempDeadline = tempTask.getDeadline().format(DateTimeFormatter.ofPattern("uuuu.MM.d"));
            //알람 시간
            String tempAlarmText = "";
            if (tempTask.getAlarmTime() == null) tempAlarmText = "알람 미설정";
            else tempAlarmText = tempTask.getAlarmTime().format(DateTimeFormatter.ofPattern("uuuu.MM.d"));

            String taskListString = String.format("%s  %s, 데드라인: %s, 알림시간: %s", checkbox, tempTaskName, tempDeadline, tempAlarmText);
            System.out.println(taskListString);
        }

    }

    public TodoTask findTask(String s) {
        TodoTask temp = null;
        for (int i = 0; i < todoTasks.size(); i = i + 1) {
            if (todoTasks.get(i).getName().equalsIgnoreCase(s)) {
                temp = todoTasks.get(i);
            }
        }return temp;
    }



    //---------------------------getter 모음------------------------------------------
    public String getName() {
        return listName;
    }

    public String getList() throws EmptyListException{
        if (todoTasks.isEmpty()) {throw new EmptyListException("목록이 비어있습니다. 할 일을 추가해주세요");}
        return todoTasks.toString();
    }
    public int getSize(){
        return todoTasks.size();
    }
    public String getTasks(){
        String taskString = "";
        for (int i=0;i<todoTasks.size();i=i+1){
            String temp=todoTasks.get(i).getName();
            taskString = taskString+","+temp;
        }
        return taskString;
    }


    //--------------------------- 정렬 방식 -------------------------------------------

    //문자열 정렬
    public final Comparator sortByChr = new Comparator<TodoTask>() {
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    //데드라인 별 정렬
    public final Comparator sortByDeadline = new Comparator<TodoTask>() {
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getDeadline().compareTo(o2.getDeadline());
        }
    };

    //생성시점
    public final Comparator sortByCreation = new Comparator<TodoTask>() {

        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getCreatingTime().compareTo(o2.getCreatingTime());
        }
    };


/*완료여부가 compareTo가 안되어서 잠시 주석처리.
    //완료여부
    public final Comparator sortByCompleted = new Comparator<TodoTask>() {
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getCompleted().compareTo(o2.getCompleted());
        }
    };*/
}

