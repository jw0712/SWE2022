package com.jiwon.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*app 클래스가 */

public class TodoApp {
    ArrayList <TodoList> todoLists;

    //생성자
    public TodoApp(){
        this.todoLists = new ArrayList<>();
    }
    //리스트, 태스크의 차이일 뿐 추가,삭제,get의 형식이 비슷해서..어떻게 묶을 수 없을까
    //리스트 추가
    public void addList(TodoList newList){
        todoLists.add(newList);
    }

    //리스트 삭제
    public void removeList(TodoList list){
        if (!(todoLists.isEmpty())
                && todoLists.contains(list))
            todoLists.remove(list);
    }

    public String getList(){
        if (todoLists.isEmpty()) return "리스트를 추가해 주십시오";
        else return todoLists.toString();
    }
/* 리스트도 소팅하고 싶었지만 실패
    public class listSorting(String option){
        String listStringVer=todoLists.toString();
        switch (option){
            case("ascending"): Collections.sort(listStringVer);break;
            case("descending"): Collections.sort(listStringVer); Collections.reverse(listStringVer);break;

    }
        */

}
