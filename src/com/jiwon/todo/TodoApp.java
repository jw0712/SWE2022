package com.jiwon.todo;

import java.io.Serializable;
import java.util.ArrayList;

/*try ~ catch 문을 사용해서 예외처리 하고 싶었으나 상황별로 어떻게 나눌지 헷갈려서 if~ throw 처리*/

public class TodoApp implements Serializable {
    ArrayList<TodoList> todoLists;
    String appName;

    //생성자
    public TodoApp(String appName) {
        this.todoLists = new ArrayList<>();
        this.appName = appName;
    }





    //리스트 추가.
    public void addList(TodoList listname) {
        todoLists.add(listname);
    }

    //리스트 삭제.
    public void removeList(TodoList list) throws EmptyListException,IllegalArgumentException {
        if (this.todoLists.isEmpty()) throw new EmptyListException("App이 비어있습니다.");
        //목록에 없는 것을 삭제하고자 하였으므로 불법적인 인자 예외로 처리함.
        if (!(this.todoLists.contains(list))) throw new IllegalArgumentException("해당 리스트가 존재하지 않습니다.");
        todoLists.remove(list);

    }

    //getSimpleInfoOfLists : 리스트를 개괄적으로 보여준다. 리스트 이름과 그 리스트 안의 할 일 개수 리턴
    public String getSimpleInfoOfLists() throws EmptyListException {
        String temp = "";
        if (todoLists.isEmpty()) {
            throw new EmptyListException("App이 비어있습니다. 목록을 추가해주세요.");
        }
        for (int i = 0; i < todoLists.size(); i = i + 1) {
            TodoList templist=todoLists.get(i);
            String listNames = templist.getName();
            int listSize=templist.getSize();

            String listString = String.format("-TodoList이름: %s => TodoTask 개수: %d",listNames, listSize);
            System.out.println(listString);
            temp = temp+"\n"+listString;
        }return temp;
    }
    /*list(String listname): listname이라는 해당 리스트를 출력.
    app이 list 디테일을 알 필요가 없으므로 todoList에게 가지고 있는 task 디테일을 요구.*/
    public void list(TodoList list){
        if (todoLists.isEmpty()) throw new EmptyListException("리스트가 비어 있습니다.");
        if (!todoLists.contains(list)) throw new IllegalArgumentException("해당 리스트가 존재하지 않습니다.");
        System.out.println("TodoList: "+list.getName());
        list.viewTaskDetails();
    }


    public TodoList findList(String s){
        TodoList temp = null;
        for(int i=0;i<todoLists.size();i=i+1){
            if(todoLists.get(i).getName().equalsIgnoreCase(s)) {
                temp = todoLists.get(i);
            }
        }return temp;
    }




    public int getSize() {
        return todoLists.size();
    }




}



/*EmptyListException: 리스트가 비어있을 경우, 추가, 삭제, 정렬, 받아오기 등의 메서드 실행 불가
* 자바에서 제공하는 예외 중 IllegalArgumentException도 있다고 하는데 잘 모르겠어서 checked Exception 생성
* 일단 비어있는 리스트에서 어떤 메서드를 실행하는 것은 상태불량이니 Illegal State*/
class EmptyListException extends IllegalStateException {
    public EmptyListException(String message) {
        super(message);
    }
}



/* 리스트도 소팅하고 싶었지만 실패
    public class listSorting(String option){
        String listStringVer=todoLists.toString();
        switch (option){
            case("ascending"): Collections.sort(listStringVer);break;
            case("descending"): Collections.sort(listStringVer); Collections.reverse(listStringVer);break;
    }
        */