package com.example.gradproject.ui.productList;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gradproject.R;
import com.example.gradproject.databinding.RowProductBinding;

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
        RowProductBinding binding = RowProductBinding.inflate(layoutInflater);

        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        ProductModel dataModel = list.get(position);
        holder.bind(dataModel);

        holder.binding.ivProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putParcelable("item", dataModel);
                findNavController(view).navigate(R.id.productDescriptionFragment,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ProductHolder extends RecyclerView.ViewHolder {
        public RowProductBinding binding;

        public ProductHolder(RowProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void bind(ProductModel model) {
            binding.setModel(model);
            Glide.with(binding.getRoot().getRootView()).load(model.getPhoto()).into(binding.ivProduct);

        }
    }
}