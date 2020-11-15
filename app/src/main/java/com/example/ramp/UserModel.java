package com.example.ramp;

import java.util.ArrayList;

// define the User class and what it stores e.g. username, password, email, user id
public class UserModel {
    public static String name;
    public static String gender;
    public String age;
    public String chairInfo;
    public String colorBlind;
    public ArrayList<Integer> modalityList;

    public  UserModel(){
    }

    public UserModel(String name, String gender, String age, ArrayList<Integer> modalityList) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.chairInfo = "default";
        this.colorBlind = "default";
        this.modalityList = modalityList;
    }

    public UserModel(String name, String gender, String age, String chairInfo, String colorBlind, ArrayList<Integer> modalityList) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.chairInfo = chairInfo;
        this.colorBlind = colorBlind;
        this.modalityList = modalityList;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setChairInfo(String chairInfo) {
        this.chairInfo = chairInfo;
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

    public String getChairInfo() {
        return chairInfo;
    }

    public String getColorBlind() {
        return colorBlind;
    }

    public String getGender() {
        return gender;
    }

    public static String getName() {
        return name;
    }

    public ArrayList<Integer> getModalityList() {
        return modalityList;
    }
}
