package com.example.gradproject.ui.Register;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.gradproject.ui.profile.User;

public class CustomerModel extends User implements Parcelable {
    private String CustomerId, VendorId;

    public CustomerModel(String customerId, String vendorId) {
        CustomerId = customerId;
        VendorId = vendorId;
    }

    public CustomerModel(String nameUser, String phoneNumber, String email, String password, String location) {
        super(nameUser, phoneNumber, email, password, location);
        this.CustomerId = "none";
        this.VendorId = "none";
    }
    public CustomerModel(String nameUser, String customerId, String location, String phoneNumber, String email, String password) {
        super(nameUser, phoneNumber, email, password, location);
        this.CustomerId = "none";
        this.VendorId = "none";
    }

    public CustomerModel() {


    }

    public CustomerModel(String nameUser, String phoneNumber, String email, String password, String location, String customerId, String vendorId) {
        super(nameUser, phoneNumber, email, password, location);
        CustomerId = customerId;
        VendorId = vendorId;
    }

    public CustomerModel(User user) {
        super(user.getNameUser(), user.getPhoneNumber(), user.getEmail(), user.getPassword(), user.getLocation());
        CustomerId = "none";
        VendorId = "none";
    }


    protected CustomerModel(Parcel in) {
        CustomerId = in.readString();
        VendorId = in.readString();
    }

    public static final Creator<CustomerModel> CREATOR = new Creator<CustomerModel>() {
        @Override
        public CustomerModel createFromParcel(Parcel in) {
            return new CustomerModel(in);
        }

        @Override
        public CustomerModel[] newArray(int size) {
            return new CustomerModel[size];
        }
    };

    public String getCustomerId() {
        return CustomerId;
    }

    public String getVendorId() {
        return VendorId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(CustomerId);
        parcel.writeString(VendorId);
    }
}
