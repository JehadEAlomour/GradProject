package com.example.gradproject.ui.Register;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.gradproject.ui.profile.User;

public class VendorModel extends User implements Parcelable {
            private String  VendorId,RegDate,SubDate,EntryUser;

    public VendorModel(String vendorId, String regDate, String subDate, String entryUser) {
        VendorId = vendorId;
        RegDate = regDate;
        SubDate = subDate;
        EntryUser = entryUser;
    }
    public VendorModel(String name, String VendorId, String location, String phoneNumber,String email) {

    }
    public VendorModel(String nameUser, String phoneNumber, String email, String password, String location, String vendorId, String regDate, String subDate, String entryUser) {
        super(nameUser, phoneNumber, email, password, location);
        VendorId = vendorId;
        RegDate = regDate;
        SubDate = subDate;
        EntryUser = entryUser;
    }

    public VendorModel(User user) {
        super(user.getNameUser(), user.getPhoneNumber(), user.getEmail(), user.getPassword(), user.getLocation());
        this.VendorId="None";
        this.EntryUser="none";
        this.RegDate="none";
        this.SubDate="none";
    }

    protected VendorModel(Parcel in) {
        VendorId = in.readString();
        RegDate = in.readString();
        SubDate = in.readString();
        EntryUser = in.readString();
    }

    public static final Creator<VendorModel> CREATOR = new Creator<VendorModel>() {
        @Override
        public VendorModel createFromParcel(Parcel in) {
            return new VendorModel(in);
        }

        @Override
        public VendorModel[] newArray(int size) {
            return new VendorModel[size];
        }
    };

    public String getVendorId() {
        return VendorId;
    }

    public String getRegDate() {
        return RegDate;
    }

    public String getSubDate() {
        return SubDate;
    }

    public String getEntryUser() {
        return EntryUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(VendorId);
        parcel.writeString(RegDate);
        parcel.writeString(SubDate);
        parcel.writeString(EntryUser);
    }
}
