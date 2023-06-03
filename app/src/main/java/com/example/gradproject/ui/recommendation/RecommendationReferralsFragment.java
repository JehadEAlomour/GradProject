package com.example.gradproject.ui.recommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.databinding.FragmentRecommendationReferralsBinding;
import com.example.gradproject.ui.profile.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecommendationReferralsFragment extends Fragment {
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("App/Recommendation");
    FragmentRecommendationReferralsBinding binding;
    private User user;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecommendationReferralsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickAdd();
    }

    private void onClickAdd() {
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user= new User("Jehad","795684","email","02123","zarqa");
                RecommendationModel model= new RecommendationModel(user.getNameUser(),binding.etRecommendation.getText().toString());
                if (!binding.etRecommendation.getText().toString().isEmpty()) {
                    reference.push().setValue(model);
                    Toast.makeText(getContext(), "Thanks", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "fill the Recommendation", Toast.LENGTH_SHORT).show();
            }

        });
    }
}