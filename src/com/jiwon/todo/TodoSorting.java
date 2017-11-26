package com.jiwon.todo;
/*정렬 방식: 제목(ABC...)/기한/만든날짜 /완료여부

클래스로 만들긴 했는데 불필요했던 것일까...*/


import java.util.Collections;
import java.util.Comparator;
class TodoSorting {

    //문자열 정렬
    public final Comparator sortByChr = new Comparator<TodoTask>() {
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public final Comparator sortByChr2 = sortByChr.reversed();




    //데드라인 별 정렬
    public final Comparator sortByDeadline = new Comparator<TodoTask>() {
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getDeadline().compareTo(o2.getDeadline());
        }
    };
    public final Comparator getSortByDeadline2 = sortByDeadline.reversed();




    //생성시점
    public final Comparator sortByCreation = new Comparator<TodoTask>() {

        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getCreatingTime().compareTo(o2.getCreatingTime());
        }
    };
    public final Comparator sortByCreation2 = sortByCreation.reversed();




/*
    public final Comparator sortByCompleted = new Comparator<TodoTask>() {

        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getCompleted().compareTo(o2.getCompleted()); //boolean이라 비교 불가능이라는데 어떻게 해결하지
        }
    };*/
}
