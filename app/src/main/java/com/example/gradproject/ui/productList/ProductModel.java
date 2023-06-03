package com.example.gradproject.ui.productList;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ProductModel implements Parcelable {
    private String productId;
    private String name;
    private String description;
    private String phoneNumber;
    private String photo;
    private String Price;
    private String CategoryID;
    private String vendorID;
    private String location;

    public ProductModel() {
    }

    protected ProductModel(Parcel in) {
        productId = in.readString();
        name = in.readString();
        description = in.readString();
        phoneNumber = in.readString();
        photo = in.readString();
        Price = in.readString();
        CategoryID = in.readString();
        vendorID = in.readString();
        location = in.readString();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public ProductModel(String productId, String name, String description, String photo, String Price, String vendorID, String location, String phoneNumber, String categoryID) {
        this.productId = productId;
        this.photo = photo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.Price = Price;
        this.vendorID = vendorID;
        this.location = location;
        this.CategoryID = categoryID;
    }

    public ProductModel(String productId, String name, String description, String photo, String Price, String vendorID, String location, String phoneNumber) {
        this.productId = productId;
        this.photo = photo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.Price = Price;
        this.vendorID = vendorID;
        this.location = location;

    }


    public String getLocation() {
        return location;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String getPhoto() {
        return photo;
    }

    public String getPrice() {
        return Price;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public String getVendorID() {
        return vendorID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(productId);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(phoneNumber);
        parcel.writeString(photo);
        parcel.writeString(Price);
        parcel.writeString(CategoryID);
        parcel.writeString(vendorID);
        parcel.writeString(location);
    }
}
