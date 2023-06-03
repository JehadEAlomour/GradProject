package com.example.gradproject.ui.reviewAndReport;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.databinding.FragmentReviewBinding;
import com.example.gradproject.ui.productList.ProductModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReviewFragment extends Fragment {
    FragmentReviewBinding binding;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Review");
    private AdapterReview adapter;
    private ArrayList<ReviewModel> list = new ArrayList<>();
    private ProductModel productModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReviewBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        getReviewFromFireBase();
        initAdapter();


    }

    private void getArgs() {
        assert getArguments() != null;
        productModel = getArguments().getParcelable("item");
        Log.d("TAGmodle", "getArgs: " + productModel.getProductId());
    }

    private void initAdapter() {
        adapter = new AdapterReview(list, getLayoutInflater());
        binding.rv.setAdapter(adapter);


    }

    private void getReviewFromFireBase() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ReviewModel model = dataSnapshot.getValue(ReviewModel.class);
                    assert model != null;
                    if (model.getProductId().equals(productModel.getProductId())) {
                        list.add(model);
                        Toast.makeText(getContext(), "" + model.getText() + " " + model.getName(), Toast.LENGTH_SHORT).show();


                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}