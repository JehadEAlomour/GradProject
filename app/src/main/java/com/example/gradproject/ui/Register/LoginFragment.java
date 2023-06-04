package com.example.gradproject.ui.Register;

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
import com.example.gradproject.databinding.FragmentLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    SharedPreferences sharedPref;
    public static boolean IS_VENDOR;


    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/Users");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
        OnClickLogin();
        onClickReg();

    }

    private void onClickReg() {
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.itemRegister);
            }
        });
    }

    private void OnClickLogin() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckDataBase(view);
            }
        });
    }


    private void CheckDataBase(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();

        if (
                binding.etPhoneNumber.getText().toString().isEmpty() ||
                        binding.etPassword.getText().toString().isEmpty()
        ) {
            Toast.makeText(view.getContext(), "add Email or Password", Toast.LENGTH_SHORT).show();
        } else if (binding.cbVendor.isChecked()) {
            reference.child("Vendor").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    IS_VENDOR=true;
                    if (snapshot.hasChild(binding.etPhoneNumber.getText().toString())) {
                        final String getPassword = snapshot.child(binding.etPhoneNumber.getText().toString()).child("password").getValue(String.class);
                        assert getPassword != null;
                        if (getPassword.equals(binding.etPassword.getText().toString())) {
                            String nameUser = snapshot.child(binding.etPhoneNumber.getText().toString()).child("nameUser").getValue(String.class);
                            String vendorId = snapshot.child(binding.etPhoneNumber.getText().toString()).child("VendorID").getValue(String.class);
                            String email = snapshot.child(binding.etPhoneNumber.getText().toString()).child("email").getValue(String.class);
                            String location = snapshot.child(binding.etPhoneNumber.getText().toString()).child("location").getValue(String.class);
                            String phoneNumber = snapshot.child(binding.etPhoneNumber.getText().toString()).child("phoneNumber").getValue(String.class);
                            String password = getPassword;
                            editor.putBoolean("vendor", true);
                            editor.putString("Name", nameUser);
                            editor.putString("VendorId", vendorId);
                            editor.putString("location", location);
                            editor.putString("phoneNumber", phoneNumber);
                            editor.putString("email", email);
                            editor.putString("password", password);
                            editor.commit();
                            Toast.makeText(getContext(), "Welcome!", Toast.LENGTH_SHORT).show();

                            findNavController(view).navigate(R.id.itemHome);

                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        } else if (binding.cbCustomer.isChecked()) {
            reference.child("Customer").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    IS_VENDOR=false;
                    if (snapshot.hasChild(binding.etPhoneNumber.getText().toString())) {
                        final String getPassword = snapshot.child(binding.etPhoneNumber.getText().toString()).child("password").getValue(String.class);
                        assert getPassword != null;
                        if (getPassword.equals(binding.etPassword.getText().toString())) {
                            String nameUser = snapshot.child(binding.etPhoneNumber.getText().toString()).child("nameUser").getValue(String.class);
                            String vendorId = snapshot.child(binding.etPhoneNumber.getText().toString()).child("customerId").getValue(String.class);
                            String email = snapshot.child(binding.etPhoneNumber.getText().toString()).child("email").getValue(String.class);
                            String location = snapshot.child(binding.etPhoneNumber.getText().toString()).child("location").getValue(String.class);
                            String phoneNumber = snapshot.child(binding.etPhoneNumber.getText().toString()).child("phoneNumber").getValue(String.class);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putBoolean("vendor", false);
                            editor.putString("Name", nameUser);
                            editor.putString("VendorId", vendorId);
                            editor.putString("location", location);
                            editor.putString("phoneNumber", phoneNumber);
                            editor.putString("email", email);
                            editor.commit();
                            Toast.makeText(getContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                            findNavController(view).navigate(R.id.itemHome);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        } else {
            Toast.makeText(getContext(), "no Account like this!!", Toast.LENGTH_SHORT).show();
        }


    }

    private void setData() {
        sharedPref = getContext().getSharedPreferences("User", getContext().MODE_PRIVATE);

    }

}