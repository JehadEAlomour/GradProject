package com.example.gradproject.ui.reviewAndReport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradproject.R;
import com.example.gradproject.databinding.CategoryRowBinding;
import com.example.gradproject.databinding.RowRevBinding;
import com.example.gradproject.ui.category.CategoryAdapter;
import com.example.gradproject.ui.category.CategoryModel;

import java.util.ArrayList;

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.ReviewHolder> {
    private ArrayList<ReviewModel> list;
    private LayoutInflater layoutInflater;

    public AdapterReview(ArrayList<ReviewModel> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }


    @NonNull
    @Override
    public AdapterReview.ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowRevBinding binding = RowRevBinding.inflate(layoutInflater);
        return new AdapterReview.ReviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReview.ReviewHolder holder, int position) {
        ReviewModel dataModel = list.get(position);
        holder.bind(dataModel);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ReviewHolder extends RecyclerView.ViewHolder {
        public RowRevBinding binding;

        public ReviewHolder(RowRevBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ReviewModel model) {

            binding.tvName.setText(model.getName());
            binding.tvText.setText(model.getText());

        }

    }

}
