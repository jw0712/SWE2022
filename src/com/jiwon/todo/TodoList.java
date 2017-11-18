package com.jiwon.todo;

import java.util.ArrayList;

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




    /*정렬 방식: 제목(ABC...)/기한/만든날짜 /완료여부/myday 추가여부
    *넘 많다..천천히.. */
    public void sortByUpper(){
    }



    //테마변경
    public void changeThemeColor(TodoTheme.TodoThemeColors newColor){
        listTheme.changeThemeColor(newColor);
    }
    public void changeThemeImage(TodoTheme.TodoThemeImages newImage){
        listTheme.changeThemeImage(newImage);
    }



    //목록삭제 . 요청한 task가 목록 안에 있을 때만 삭제
    public void deleteTask(TodoTask task){
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
}


