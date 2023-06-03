package com.example.gradproject.ui.reviewAndReport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentReportBinding;
import com.example.gradproject.ui.productList.ProductModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportFragment extends Fragment {
    FragmentReportBinding binding;
    ProductModel productModel;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Reports");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReportBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArgs();
        onClick();
    }

    private void getArgs() {
        productModel = getArguments().getParcelable("item");

    }

    private void onClick() {
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.etReport.getText().toString().isEmpty()){
                reference.child(productModel.getName()).child("Text").setValue(binding.etReport.getText().toString());
                Navigation.findNavController(view).navigate(R.id.categoryFragment);
                Toast.makeText(getContext(), "Thanks", Toast.LENGTH_SHORT).show();
            }}
        });
    }
}