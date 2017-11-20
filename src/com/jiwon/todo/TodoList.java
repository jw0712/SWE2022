package com.jiwon.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TodoList {
    /*가지고 있어야 할 것
    속성: 이름, task목록, 테마
    메소드: 이름 수정, 정렬하기, 테마 변경, 목록 삭제, 할일 추가, 빈목록출력(getlist)
    할수잇ㅅ서..
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

    public Object getName() {
        return listName;
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
            case COMPLETED:Collections.sort(todoTasks, sortByCompleted);
                break;
            case REVERSE_COMPLETED:
                Comparator sortByCompleted2 = Comparator.reverseOrder();
                Collections.sort(todoTasks, sortByCompleted2);
                break;
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

    public String getList(){
        if (todoTasks.isEmpty()) return "목록이 비어있습니다. 할 일을 추가해주세요";
        else return todoTasks.toString();
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


    //완료여부
    public final Comparator sortByCompleted = new Comparator<TodoTask>() {

        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getCompleted().compareTo(o2.getCompleted());
        }
    };
}


