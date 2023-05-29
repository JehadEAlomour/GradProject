package com.example.gradproject.ui.reviewAndReport;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentReviewBinding;

public class ReviewFragment extends Fragment {
FragmentReviewBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentReviewBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClick();
    }

    private void onClick() {
    binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.productDescriptionFragment);
            Toast.makeText(getContext(), "Thanks", Toast.LENGTH_SHORT).show();
        }
    });
    }
}