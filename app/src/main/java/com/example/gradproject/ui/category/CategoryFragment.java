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
        initAdapter();
    }


    private void initAdapter() {
        list = new ArrayList<>();
        String[] nameList = getResources().getStringArray(R.array.CategoryIdList);

        list.add(new CategoryModel(nameList[0], nameList[0], R.drawable.dairy2));
        list.add(new CategoryModel(nameList[1], nameList[1], R.drawable.honey2));
        list.add(new CategoryModel(nameList[2], nameList[2], R.drawable.shrak2));
        list.add(new CategoryModel(nameList[3], nameList[3], R.drawable.jars2));
        list.add(new CategoryModel(nameList[4], nameList[4], R.drawable.oil_and_olives2));
        list.add(new CategoryModel(nameList[5], nameList[5], R.drawable.fruits2));
        list.add(new CategoryModel(nameList[6], nameList[6], R.drawable.dates2));
        list.add(new CategoryModel(nameList[7], nameList[7], R.drawable.handcrafts2));
        list.add(new CategoryModel(nameList[8], nameList[8], R.drawable.dabkeeeee));
        list.add(new CategoryModel(nameList[9], nameList[9], R.drawable.question));


        adapter = new CategoryAdapter(list, getLayoutInflater());
        binding.rvCategory.setAdapter(adapter);


    }
    void onClick(View view)
    {
    }


}