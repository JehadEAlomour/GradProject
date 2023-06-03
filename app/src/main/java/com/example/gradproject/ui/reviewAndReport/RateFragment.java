package com.example.gradproject.ui.reviewAndReport;

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
import com.example.gradproject.databinding.FragmentRateBinding;
import com.example.gradproject.ui.productList.ProductModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RateFragment extends Fragment {
    FragmentRateBinding binding;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Review");
    ProductModel productModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRateBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        onClickInSubmit();
    }

    private void getArgs() {
        assert getArguments() != null;
        productModel = getArguments().getParcelable("NameItem");
    }

    private void onClickInSubmit() {

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReviewModel model = new ReviewModel(productModel.getVendorID(), binding.etRate.getText().toString(),productModel.getProductId());
                if (!binding.etRate.getText().toString().isEmpty()) {
                    if (!getArguments().isEmpty()) {
                        reference.child(model.getText()).child("Name").setValue(model.getName());
                        reference.child(model.getText()).child("Text").setValue(model.getText());
                        reference.child(model.getText()).child("ProductId").setValue(model.getProductId());
                        Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.categoryFragment);
                    } else {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                } else Toast.makeText(getContext(), "Fill your Rating ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}