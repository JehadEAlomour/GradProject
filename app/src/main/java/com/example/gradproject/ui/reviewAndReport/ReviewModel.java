package com.example.gradproject.ui.reviewAndReport;

public class ReviewModel {
    private String Name, Text, ProductId;

    public ReviewModel(String name, String text, String productId) {
        Name = name;
        Text = text;
        ProductId = productId;
    }

    public ReviewModel(String name, String text) {
        Name = name;
        Text = text;
    }

    public String getProductId() {
        return ProductId;
    }

    public ReviewModel() {
    }

    public String getName() {
        return Name;
    }

    public String getText() {
        return Text;
    }

}

