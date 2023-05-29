package com.example.gradproject.ui.category;

public class CategoryModel {
    private String CategoryID;
    private String CategoryName;
    private String Description;
    private String EntryUser;
    private String EntryDate;
    private int Photo;

    public CategoryModel(String categoryID, String categoryName, String description, String entryUser, String entryDate) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        Description = description;
        EntryUser = entryUser;
        EntryDate = entryDate;
    }

    public CategoryModel(String categoryID, String categoryName, String description, String entryUser, String entryDate, int photo) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        Description = description;
        EntryUser = entryUser;
        EntryDate = entryDate;
        Photo = photo;
    }

    public CategoryModel(String categoryID, String categoryName, int photo) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
        this.Photo = photo;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public String getEntryUser() {
        return EntryUser;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public int getPhoto() {
        return Photo;
    }
}
