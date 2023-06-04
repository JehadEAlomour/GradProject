package com.example.gradproject.ui.Register;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentRegisterBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private static final String USER_PATH = "Users";

    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/Users");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickButtonRegister();
    }

    private void onClickButtonRegister() {
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ifNotNull()) {
                    setDataInFireBase(view);

                } else {
                    Toast.makeText(getContext(), "Fill the Fields ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setDataInFireBase(View view) {
        if (binding.cbVendor.isChecked()) {
            VendorModel model = new VendorModel(binding.etName.getText().toString(), binding.etPhoneNumber.getText().toString(), binding.etEmail.getText().toString(), binding.etPassword.getText().toString()
                    , binding.etLocation.getText().toString(), "1", "10/5/2023", "none", "10"
            );

            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("VendorID").setValue(model.getVendorId());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("RegDate").setValue(model.getRegDate());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("SubDate").setValue(model.getSubDate());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("EntryUser").setValue(model.getEntryUser());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("nameUser").setValue(model.getNameUser());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("phoneNumber").setValue(model.getPhoneNumber());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("email").setValue(model.getEmail());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("password").setValue(model.getPassword());
            reference.child("Vendor").child(binding.etPhoneNumber.getText().toString()).child("location").setValue(model.getLocation());
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
            findNavController(view).navigate(R.id.itemLogin);

        } else {
            CustomerModel model = new CustomerModel(binding.etName.getText().toString(), binding.etPhoneNumber.getText().toString()
                    , binding.etEmail.getText().toString(), binding.etPassword.getText().toString(), binding.etLocation.getText().toString(), "2", "1"
            );

            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("customerId").setValue(model.getCustomerId());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("vendorId").setValue(model.getPhoneNumber());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("nameUser").setValue(model.getNameUser());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("phoneNumber").setValue(model.getPhoneNumber());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("email").setValue(model.getEmail());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("password").setValue(model.getPassword());
            reference.child("Customer").child(binding.etPhoneNumber.getText().toString()).child("location").setValue(model.getLocation());
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
            findNavController(view).navigate(R.id.itemLogin);


        }
    }


    private boolean ifNotNull() {
        return !binding.etEmail.getText().toString().isEmpty() && !binding.etName.getText().toString().isEmpty() &&
                !binding.etPassword.getText().toString().isEmpty() && !binding.etPhoneNumber.getText().toString().isEmpty()
                ;


    }
}