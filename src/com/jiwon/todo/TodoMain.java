package com.jiwon.todo;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;//단지 date를 인쇄해보고싶었는데 인텔리제이가 넣어줬음

public class TodoMain {
    public static void main(String[] args){
        AtomicReference<Date> d1 = new AtomicReference<>(new Date());
        System.out.println(d1.get());
        String temp = d1.toString();
        System.out.println(temp);
    }

}
