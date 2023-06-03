package com.example.gradproject.ui.category;

public class CategoryModel {
    private String categoryID;
    private String categoryName;

    private int photo;


    public CategoryModel(String categoryID, String categoryName, int photo) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.photo = photo;
    }

    public CategoryModel() {
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public int getPhoto() {
        return photo;
    }
}
