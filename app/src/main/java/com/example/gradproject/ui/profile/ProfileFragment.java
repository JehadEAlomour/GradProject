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
import com.example.gradproject.databinding.FragmentProfileBinding;
import com.example.gradproject.ui.Register.CustomerModel;
import com.example.gradproject.ui.Register.VendorModel;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    SharedPreferences sharedPreferences;
    CustomerModel customerModel;
    VendorModel vendorModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromPref();
        onCLickInSub();
        onClickInViewProducts();
        onClickInEditProfile();


    }

    private void getDataFromPref() {
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
            Toast.makeText(getContext(), "" + vendorModel.getNameUser(), Toast.LENGTH_SHORT).show();
        } else {
            customerModel = new CustomerModel(
                    sharedPreferences.getString("Name", "none"),
                    sharedPreferences.getString("VendorId", "none"),
                    sharedPreferences.getString("location", "none"),
                    sharedPreferences.getString("phoneNumber", "none"),
                    sharedPreferences.getString("email", "none"),
                    sharedPreferences.getString("password", "none")
            );
            Toast.makeText(getContext(), "" + vendorModel.getNameUser(), Toast.LENGTH_SHORT).show();
        }
    }


    private void onCLickInSub() {
        binding.tvSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.premiumFragment);
            }
        });
    }

    private void onClickInViewProducts() {
    }

    private void onClickInEditProfile() {
        binding.tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.editProfileFragment);
            }
        });
    }
}