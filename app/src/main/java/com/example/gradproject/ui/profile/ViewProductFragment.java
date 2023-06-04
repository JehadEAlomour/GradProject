package com.example.gradproject.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.databinding.FragmentViewProductBinding;
import com.example.gradproject.ui.productList.ProductModel;
import com.example.gradproject.ui.productList.ViewProductAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ViewProductFragment extends Fragment {
    private FragmentViewProductBinding binding;
    private String model;
    private ArrayList<ProductModel> list = new ArrayList<>();
    private ViewProductAdapter adapter;

    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Product");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewProductBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getVendorModel();
        getDataFromFireBase();
    }

    private void getVendorModel() {
        model = getArguments().getString("phoneNumber");


    }

    private void getDataFromFireBase() {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(model)) {
                    snapshot.getChildren().forEach(dataSnapshot ->
                            {
                                list.add(snapshot.getValue(ProductModel.class));
                            }
                    );
                }
                initAdapter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initAdapter() {
        if (list.isEmpty()) {
            Toast.makeText(getContext(), "No products offered yet", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new ViewProductAdapter(list, getLayoutInflater());
            binding.rvViewProduct.setAdapter(adapter);
        }
    }
}