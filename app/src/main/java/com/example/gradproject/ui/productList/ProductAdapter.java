package com.example.gradproject.ui.productList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradproject.R;
import com.example.gradproject.databinding.ProductRowBinding;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private ArrayList<ProductModel> list;
    private LayoutInflater layoutInflater;

    public ProductAdapter(ArrayList<ProductModel> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductRowBinding binding = ProductRowBinding.inflate(layoutInflater);

        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        ProductModel dataModel = list.get(position);
        holder.bind(dataModel);
        holder.binding.ivProduct.setImageResource(dataModel.getPhoto());
        holder.binding.ivProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.productDescriptionFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ProductHolder extends RecyclerView.ViewHolder {
        public ProductRowBinding binding;

        public ProductHolder(ProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void bind(ProductModel model) {
            binding.setModel(model);
        }
    }
}
