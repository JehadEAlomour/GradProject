package com.example.gradproject.ui.productList;

import static androidx.navigation.Navigation.findNavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gradproject.R;
import com.example.gradproject.databinding.ViewProductRowBinding;

import java.util.ArrayList;

public class ViewProductAdapter extends RecyclerView.Adapter<ViewProductAdapter.ViewProductHolder> {
    private ArrayList<ProductModel> list;
    private LayoutInflater layoutInflater;

    public ViewProductAdapter(ArrayList<ProductModel> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewProductRowBinding binding = ViewProductRowBinding.inflate(layoutInflater);

        return new ViewProductAdapter.ViewProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewProductAdapter.ViewProductHolder holder, int position) {
        ProductModel dataModel = list.get(position);
        holder.bind(dataModel);

        holder.binding.ivProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.productDescriptionFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewProductHolder extends RecyclerView.ViewHolder {
        public ViewProductRowBinding binding;

        public ViewProductHolder(ViewProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void bind(ProductModel model) {
            binding.setModel(model);
            Glide.with(binding.getRoot().getRootView()).load(model.getPhoto()).into(binding.ivProduct);
            binding.btnBoost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.boostProductFragment);
                }
            });
            binding.btnEditProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.boostProductFragment);

                }
            });

        }
    }

}
