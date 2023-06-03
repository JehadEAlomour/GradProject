package com.example.gradproject.ui.profile;

public class User {
    private String NameUser, PhoneNumber, Email, Password,Location;

    public User() {

    }

    public User(String nameUser, String phoneNumber, String email, String password,String location) {
        NameUser = nameUser;
        PhoneNumber = phoneNumber;
        Email = email;
        Password = password;
        Location=location;
    }

    public String getNameUser() {
        return NameUser;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }


    public String getLocation() {
        return Location;
    }



}
