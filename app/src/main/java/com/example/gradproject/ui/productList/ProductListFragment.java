package com.example.gradproject.ui.productList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentProductListBinding;

import java.util.ArrayList;


public class ProductListFragment extends Fragment {
    private FragmentProductListBinding binding;
    private ProductAdapter adapter;
    private ArrayList<ProductModel> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataOnList();
        initAdapter();
    }

    private void setDataOnList() {
        list = new ArrayList<>();
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));
        list.add(new ProductModel("1", "Jameed", "NOthing nothing nothing", R.drawable.cheese, "20 JD ", "Ahmad", "Karak", "795656565"));

    }

    private void initAdapter() {
        adapter = new ProductAdapter(list, getLayoutInflater());
        binding.rvProducts.setAdapter(adapter);


    }
}