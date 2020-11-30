package com.example.ramp;

import java.lang.reflect.Array;
import java.util.ArrayList;

// define the User class and what it stores e.g. username, password, email, user id
public class UserModel {
    public static String name;
    public static String gender;
    public String age;
    public ArrayList<Integer> chairList;
    public String colorBlind;
    public ArrayList<Integer> modalityList;
    public boolean firstTime;

    public  UserModel(){
        firstTime = true;
    }

    public UserModel(String name, String gender, String age, ArrayList<Integer> modalityList) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.chairList = new ArrayList<>();
        this.colorBlind = "default";
        this.modalityList = modalityList;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setChairList(ArrayList<Integer> chairList) {
        this.chairList = chairList;
    }

    public void setColorBlind(String colorBlind) {
        this.colorBlind = colorBlind;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public ArrayList<Integer> getChairList() {
        return chairList;
    }

    public String getColorBlind() {
        return colorBlind;
    }

    public String getGender() {
        return gender;
    }

    public boolean getFirstTime() {
        return firstTime;
    }

    public static String getName() {
        return name;
    }

    public ArrayList<Integer> getModalityList() {
        return modalityList;
    }
}
