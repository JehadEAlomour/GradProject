package com.example.gradproject.ui.category;


import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradproject.R;
import com.example.gradproject.databinding.CategoryRowBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private ArrayList<CategoryModel> list;
    private LayoutInflater layoutInflater;

    public CategoryAdapter(ArrayList<CategoryModel> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }


    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryRowBinding binding = CategoryRowBinding.inflate(layoutInflater);
        return new CategoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        CategoryModel dataModel = list.get(position);
        holder.bind(dataModel);
        holder.binding.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle= new Bundle();
                bundle.putString("id",dataModel.getCategoryID());
                findNavController(view).navigate(R.id.productListFragment,bundle);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class CategoryHolder extends RecyclerView.ViewHolder {
        public CategoryRowBinding binding;

        public CategoryHolder(CategoryRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CategoryModel model) {

            binding.tvCategory.setText(model.getCategoryName());
            binding.ivPhoto.setImageResource(model.getPhoto());

        }

    }
}
