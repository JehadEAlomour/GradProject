package com.example.gradproject.ui.recommendation;

public class RecommendationModel {
    private String NameUser,Text;

    public RecommendationModel(String nameUser, String text) {
        NameUser = nameUser;
        Text = text;

    }

    public String getNameUser() {
        return NameUser;
    }

    public String getText() {
        return Text;
    }
}
