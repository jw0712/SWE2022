package com.jiwon.todo;

public class TodoTask extends TodoList {
    String taskname;
    Boolean isCompletedTask = false; //complete: True


    public TodoTask(String listName1) {
        super(listName1);
    }
}
}
