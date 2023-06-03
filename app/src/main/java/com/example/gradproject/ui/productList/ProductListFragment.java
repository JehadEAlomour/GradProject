package com.example.gradproject.ui.productList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gradproject.databinding.FragmentProductListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ProductListFragment extends Fragment {
    private FragmentProductListBinding binding;
    private ProductAdapter adapter;
    private ArrayList<ProductModel> list;
    private String CATEGORY_ID;

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Product");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        initAdapter();
        setDataOnList();
    }

    private void getArgs() {
        CATEGORY_ID = getArguments().getString("id");
        Toast.makeText(getContext(), ""+CATEGORY_ID, Toast.LENGTH_SHORT).show();
    }

    private void setDataOnList() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ProductModel model = dataSnapshot.getValue(ProductModel.class);
                    Log.d("TAGModel", "onDataChange: " + model.getCategoryID());
                    assert model != null;
                    if (model.getCategoryID().equals(CATEGORY_ID)) {
                        list.add(model);
                    }
                }

                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void initAdapter() {
        list = new ArrayList<>();
        adapter = new ProductAdapter(list, getLayoutInflater());
        binding.rvProduct.setAdapter(adapter);


    }
}