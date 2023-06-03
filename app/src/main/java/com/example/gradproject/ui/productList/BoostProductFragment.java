package com.example.gradproject.ui.productList;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentBoostProductBinding;
import com.example.gradproject.ui.Register.VendorModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoostProductFragment extends Fragment {
    FragmentBoostProductBinding binding;
    private String CATEGORY_ID = "";
    private VendorModel vendorModel = new VendorModel("jehad", "0795670069", "jehad@gmail.com", "12345678", "zarqa", "jehad", "now", "now", "today");
    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gradproject-605bc-default-rtdb.firebaseio.com/App/Product");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBoostProductBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSpinner();
        onCLickDone();
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.CategoryIdList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CATEGORY_ID = adapterView.getSelectedItem().toString();
                Toast.makeText(getContext(), "you chose " + CATEGORY_ID, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void onCLickDone() {
        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ifNotNull()) {
                    setDataOnFireBase(view);
                } else
                    Toast.makeText(getContext(), "Fill the Fields ", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Fill the Fields ", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void setDataOnFireBase(View view) {
        ProductModel model = new ProductModel(binding.etProductName.getText().toString(), binding.etProductName.getText().toString()
                , binding.etDesc.getText().toString(), binding.etPhoto.getText().toString(), binding.etPrice.getText().toString()
                , vendorModel.getVendorId(), binding.etLocation.getText().toString(), vendorModel.getPhoneNumber(),CATEGORY_ID);

        reference.child(model.getName()).child("productId").setValue(model.getProductId());
        reference.child(model.getName()).child("name").setValue(model.getName());
        reference.child(model.getName()).child("description").setValue(model.getDescription());
        reference.child(model.getName()).child("photo").setValue(model.getPhoto());
        reference.child(model.getName()).child("Price").setValue(model.getPrice());
        reference.child(model.getName()).child("vendorID").setValue(model.getVendorID());
        reference.child(model.getName()).child("location").setValue(model.getLocation());
        reference.child(model.getName()).child("phoneNumber").setValue(model.getPhoneNumber());
        reference.child(model.getName()).child("CategoryID").setValue(model.getCategoryID());
        Toast.makeText(getContext(), "item is Added ", Toast.LENGTH_SHORT).show();
        findNavController(view).navigate(R.id.categoryFragment);


    }

    private boolean ifNotNull() {
        return !binding.etLocation.getText().toString().isEmpty() && !binding.etDesc.getText().toString().isEmpty() &&
                !binding.etPhoto.getText().toString().isEmpty() && !binding.etDesc.getText().toString().isEmpty()
                && !binding.etProductName.getText().toString().isEmpty() && !binding.etPrice.getText().toString().isEmpty()
                ;
    }
}