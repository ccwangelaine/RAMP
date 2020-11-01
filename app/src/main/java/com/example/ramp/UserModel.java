package com.example.ramp;

// define the User class and what it stores e.g. username, password, email, user id
public class UserModel {
    public String name;
    public String gender;
    public String age;
    public String chairInfo;
    public String colorBlind;
    public String modality;

    public  UserModel(){
    }

    public UserModel(String name, String gender, String age, String modality) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.chairInfo = "default";
        this.colorBlind = "default";
        this.modality = modality;
    }

    public UserModel(String name, String gender, String age, String chairInfo, String colorBlind, String modality) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.chairInfo = chairInfo;
        this.colorBlind = colorBlind;
        this.modality = modality;
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
}
