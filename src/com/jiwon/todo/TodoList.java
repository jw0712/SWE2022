package com.jiwon.todo;

import java.util.ArrayList;

public class TodoList {
    String listName = "이름 없는 목록";

    public TodoList(String listName1){

    }

    ArrayList<String> newList(String newListName){ //리스트 새로 만들 때 이름 설정하고 싶어요....(실패!)
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> newListName = temp;
        return newListName;
    }
    //이름바꾸기
    public String changeName(String newName){
        this.listName = newName;
        return listName;
    }
    //숨기기
    public HideCompletedTask(TodoTask task){
        if (TodoList == null) {return "List is empty"};
        if (task.isCompletedTask) {hideTask(TodoTask task)};
    }
    //숨기는 활동 자체
    private void hideTask(TodoTask task){
        ArrayList<String> hidelist= new ArrayList<>();
        hidelist.add(TodoTask task);
        newlist.remove(TodoTask task);
    }

}
