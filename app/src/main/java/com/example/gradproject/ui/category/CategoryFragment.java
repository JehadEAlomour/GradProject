package com.example.gradproject.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentCategoryBinding;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;
    private CategoryAdapter adapter;
    private ArrayList<CategoryModel> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataOnList();
        initAdapter();
    }

    private void initAdapter() {
        adapter=new CategoryAdapter(list,getLayoutInflater());
        binding.rvCategory.setAdapter(adapter);


    }

    private void setDataOnList() {
        list = new ArrayList<>();
        list.add(new CategoryModel("1", "Dairy Products", R.drawable.dairy2));
        list.add(new CategoryModel("2", "Fruits And Vegetables", R.drawable.fruits2));
        list.add(new CategoryModel("3", "Olives And Oils", R.drawable.oil_and_olives2));
        list.add(new CategoryModel("4", "Baked goods", R.drawable.shrak2));
        list.add(new CategoryModel("5", "Jams And Jars", R.drawable.jars2));
        list.add(new CategoryModel("6", "Honey", R.drawable.honey2));
        list.add(new CategoryModel("7", "Dates", R.drawable.dates2));
        list.add(new CategoryModel("8", "Handcrafts", R.drawable.handcrafts2));
        list.add(new CategoryModel("9", "Events", R.drawable.dabkeeeee));

    }
}