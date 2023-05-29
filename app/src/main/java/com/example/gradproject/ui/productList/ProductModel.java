package com.example.gradproject.ui.productList;

public class ProductModel {
    private String ProductId;
    private String Name;
    private String Description;
    private String EntryUser;
    private String EntryDate;
    private String PhoneNumber;
    private int Photo;
    private String Price;
    private String CategoryID;
    private String VendorName;
    private String Location;

    public String getPhoneNumber() {
        return PhoneNumber;
    }


    public ProductModel(String productId, String name, String description, int photo, String Price, String vendorID, String location,String phoneNumber) {
        this.ProductId = productId;
        this.Photo = photo;
        this.Name = name;
        this.PhoneNumber =phoneNumber;
        this.Description = description;
        this.Price = Price;
        this.VendorName = vendorID;
        this.Location = location;
    }

    public String getLocation() {
        return Location;
    }

    public String getProductId() {
        return ProductId;
    }

    public String getName() {
        return Name;
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

    public String getPrice() {
        return Price;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public String getVendorName() {
        return VendorName;
    }

}
