package com.example.gradproject.ui.productDescrption;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentProductDiscrptionBinding;
import com.example.gradproject.ui.productList.ProductModel;


public class ProductDescriptionFragment extends Fragment {
    FragmentProductDiscrptionBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductDiscrptionBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataOnView();
        onClickButton();
    }

    private void onClickButton() {
        binding.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.reviewFragment);
            }
        });
        binding.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.reportFragment);
            }
        });
        binding.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.reviewFragment);
            }
        });
    }

    private void setDataOnView() {
        ProductModel model = new ProductModel("1", "Chess", " nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing nothing ", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565");
        binding.setModel(model);
        binding.ivProduct.setImageResource(model.getPhoto());
    }
}