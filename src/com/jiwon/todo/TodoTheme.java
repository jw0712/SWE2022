package com.jiwon.todo;

import java.io.Serializable;

public class TodoTheme implements Serializable {
    private TodoThemeColors themeColor;
    private TodoThemeImages themeImage;

    //생성자
    public TodoTheme(){
        this.themeImage = TodoThemeImages.MOUNTAIN;//기본: 산
        this.themeColor = TodoThemeColors.BLUE;  //기본 : 파랑
    }

    public enum TodoThemeColors {BLUE,RED,PURPLE,SKYBLUE,GREEN}
    public enum TodoThemeImages {MOUNTAIN, TROPICAL, OCEAN, SKY, CITY, BLANK}

    // 색, 이미지 변경
    public void changeThemeColor(TodoThemeColors color){
        this.themeColor =color;
    }
    public void changeThemeImage(TodoThemeImages image){
        this.themeImage =image; }

    //현재 색, 이미지 가져오기
    public TodoThemeColors getThemeColor(){
        return this.themeColor;
    }
    public TodoThemeImages getThemeImage(){
        return this.themeImage;
    }

}

