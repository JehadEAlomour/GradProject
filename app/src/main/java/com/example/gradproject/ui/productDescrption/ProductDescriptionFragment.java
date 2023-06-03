package com.example.gradproject.ui.productDescrption;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentProductDiscrptionBinding;
import com.example.gradproject.ui.productList.ProductModel;


public class ProductDescriptionFragment extends Fragment {
    FragmentProductDiscrptionBinding binding;
    ProductModel model;


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
        getArgs();
        setDataOnView();
        onClickButton();
    }

    private void getArgs() {
        assert getArguments() != null;
        model = getArguments().getParcelable("item");
    }

    private void onClickButton() {
        binding.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("item", model);
                findNavController(view).navigate(R.id.reportFragment,bundle);
            }
        });
        binding.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("item", model);
                findNavController(view).navigate(R.id.reviewFragment, bundle);
            }
        });
        binding.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("NameItem", model);
                findNavController(view).navigate(R.id.rateFragment, bundle);
            }
        });
    }

    private void setDataOnView() {


        binding.setModel(model);
        Glide.with(binding.getRoot().getRootView()).load(model.getPhoto()).into(binding.ivProduct);

    }
}