package com.example.gradproject.ui.category;

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

    public CategoryAdapter(ArrayList<CategoryModel> list) {
        this.list = list;
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
        holder.binding.ivPhoto.setImageResource(dataModel.getPhoto());
        holder.binding.tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.productListFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class CategoryHolder extends RecyclerView.ViewHolder {
        public CategoryRowBinding binding;

        public CategoryHolder(CategoryRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CategoryModel model) {

            binding.setModel(model);

        }

    }
}
