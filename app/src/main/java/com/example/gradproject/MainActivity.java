package com.example.gradproject;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.gradproject.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    NavController navController;
    NavHostFragment navHostFragment;
    AppBarConfiguration appBarConfiguration;
    MaterialToolbar toolbar;
    NavigationView navigationView;
//    int home = R.id.itemProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavigation();

    }

    private void initNavigation() {
//        toolbar=findViewById(R.id.tool)
    }


}


