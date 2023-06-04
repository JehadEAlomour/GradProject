package com.example.gradproject.ui.profile;

import static androidx.navigation.Navigation.findNavController;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentEditProfileBinding;
import com.example.gradproject.ui.Register.CustomerModel;
import com.example.gradproject.ui.Register.VendorModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class EditProfileFragment extends Fragment {
    FragmentEditProfileBinding binding;
    Bundle bundle;
    String Path;
    SharedPreferences sharedPreferences;
    String phoneNumber;
    CustomerModel customerModel;
    VendorModel vendorModel;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/Users");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBundle();
        onClickEdit();
    }

    private void onClickEdit() {
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Path.equals("Vendor")) {
                    reference.child("Vendor").child(phoneNumber).child("VendorID").setValue(vendorModel.getVendorId());
                    reference.child("Vendor").child(phoneNumber).child("RegDate").setValue(vendorModel.getRegDate());
                    reference.child("Vendor").child(phoneNumber).child("SubDate").setValue(vendorModel.getSubDate());
                    reference.child("Vendor").child(phoneNumber).child("EntryUser").setValue(vendorModel.getEntryUser());
                    reference.child("Vendor").child(phoneNumber).child("nameUser").setValue(binding.etName.getText().toString());
                    reference.child("Vendor").child(phoneNumber).child("phoneNumber").setValue(binding.etPhoneNUmber.getText().toString());
                    reference.child("Vendor").child(phoneNumber).child("email").setValue(binding.etEmail.getText().toString());
                    reference.child("Vendor").child(phoneNumber).child("password").setValue(vendorModel.getPassword());
                    reference.child("Vendor").child(phoneNumber).child("location").setValue(binding.etLocation.getText().toString());
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                    changePrefData();
                    findNavController(view).navigate(R.id.itemHome);


                } else {
                    reference.child("Customer").child(phoneNumber).child("customerId").setValue(customerModel.getCustomerId());
                    reference.child("Customer").child(phoneNumber).child("vendorId").setValue(customerModel.getVendorId());
                    reference.child("Customer").child(phoneNumber).child("nameUser").setValue(binding.etName.getText().toString());
                    reference.child("Customer").child(phoneNumber).child("phoneNumber").setValue(binding.etPhoneNUmber.getText().toString());
                    reference.child("Customer").child(phoneNumber).child("email").setValue(binding.etEmail.getText().toString());
                    reference.child("Customer").child(phoneNumber).child("password").setValue(customerModel.getPassword());
                    reference.child("Customer").child(phoneNumber).child("location").setValue(binding.etLocation.getText().toString());
                    changePrefData();
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                    findNavController(view).navigate(R.id.itemHome);


                }


            }
        });
    }

    private void changePrefData() {
        if (Path.equals("vendor")) {
            sharedPreferences = getActivity().getSharedPreferences("User", getContext().MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.putBoolean("vendor", true);
            editor.putString("Name", binding.etName.getText().toString());
            editor.putString("VendorId", vendorModel.getVendorId());
            editor.putString("location", binding.etLocation.getText().toString());
            editor.putString("phoneNumber", binding.etPhoneNUmber.getText().toString());
            editor.putString("email", binding.etEmail.getText().toString());
            editor.putString("password", vendorModel.getPassword());
            editor.commit();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.putBoolean("vendor", false);
            editor.putString("Name", binding.etName.getText().toString());
            editor.putString("VendorId", customerModel.getVendorId());
            editor.putString("location", binding.etLocation.getText().toString());
            editor.putString("phoneNumber", binding.etPhoneNUmber.getText().toString());
            editor.putString("email", binding.etEmail.getText().toString());
            editor.putString("password", customerModel.getPassword());
            editor.commit();
        }
    }


    private void getBundle() {
        Path = getArguments().getString("path");
        phoneNumber = getArguments().getString("phoneNumber");
        sharedPreferences = getActivity().getSharedPreferences("User", getContext().MODE_PRIVATE);
        boolean type = sharedPreferences.getBoolean("vendor", false);
        if (type) {
            vendorModel = new VendorModel(
                    sharedPreferences.getString("Name", "none"),
                    sharedPreferences.getString("VendorId", "none"),
                    sharedPreferences.getString("location", "none"),
                    sharedPreferences.getString("phoneNumber", "none"),
                    sharedPreferences.getString("email", "none")
            );

        } else {
            customerModel = new CustomerModel(
                    sharedPreferences.getString("Name", "none"),
                    sharedPreferences.getString("VendorId", "none"),
                    sharedPreferences.getString("location", "none"),
                    sharedPreferences.getString("phoneNumber", "none"),
                    sharedPreferences.getString("email", "none"),
                    sharedPreferences.getString("password", "none")
            );

        }

    }
}