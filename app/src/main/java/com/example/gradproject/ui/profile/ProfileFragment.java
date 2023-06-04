package com.example.gradproject.ui.profile;

import static androidx.navigation.Navigation.findNavController;

import static com.example.gradproject.ui.Register.LoginFragment.IS_VENDOR;

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
    String phone;

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


    }

    private void getDataFromPref() {
        sharedPreferences = getActivity().getSharedPreferences("User", getContext().MODE_PRIVATE);
        boolean type = sharedPreferences.getBoolean("vendor", true);
        if (IS_VENDOR) {
            vendorModel = new VendorModel(
                    sharedPreferences.getString("Name", "none"),
                    sharedPreferences.getString("VendorId", "none"),
                    sharedPreferences.getString("location", "none"),
                    sharedPreferences.getString("phoneNumber", "none"),
                    sharedPreferences.getString("email", "none")
            );
            phone = vendorModel.getPhoneNumber();
            setVendor(vendorModel);
        } else {
            customerModel = new CustomerModel(
                    sharedPreferences.getString("Name", "none"),
                    sharedPreferences.getString("VendorId", "none"),
                    sharedPreferences.getString("location", "none"),
                    sharedPreferences.getString("phoneNumber", "none"),
                    sharedPreferences.getString("email", "none"),
                    sharedPreferences.getString("password", "none")
            );
            setCustomer(customerModel);
//            onCLickInSub();
        }
    }

    private void setVendor(VendorModel vendorModel) {
        binding.setModel(new User(vendorModel.getNameUser(), vendorModel.getPhoneNumber(), vendorModel.getEmail(), vendorModel.getPassword(), vendorModel.getLocation()));
        binding.tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneNumber", vendorModel.getPhoneNumber());
                bundle.putString("path", "Vendor");
                findNavController(view).navigate(R.id.editProfileFragment, bundle);
            }
        });
        binding.tvViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneNumber", phone);
                findNavController(view).navigate(R.id.boostProductFragment);
            }
        });
        binding.tvSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("vendor", vendorModel);
                findNavController(view).navigate(R.id.premiumFragment);
            }
        });


    }

    private void setCustomer(CustomerModel customerModel) {
        binding.setModel(new User(customerModel.getNameUser(), customerModel.getPhoneNumber(), customerModel.getEmail(), customerModel.getPassword(), customerModel.getLocation()));
        binding.tvSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Your just a customer", Toast.LENGTH_SHORT).show();
            }
        });
        binding.tvViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Your just a customer", Toast.LENGTH_SHORT).show();

            }
        });
        binding.tvEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneNumber", customerModel.getPhoneNumber());
                bundle.putString("path", "Customer");
                findNavController(view).navigate(R.id.editProfileFragment, bundle);
            }
        });
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