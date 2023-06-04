package com.example.gradproject;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gradproject.databinding.ActivityMainBinding;
import com.example.gradproject.ui.Register.LoginFragment;
import com.example.gradproject.ui.Register.RegisterFragment;
import com.example.gradproject.ui.home.HomeFragment;
import com.example.gradproject.ui.profile.ProfileFragment;
import com.example.gradproject.ui.recommendation.AboutAsFragment;
import com.example.gradproject.ui.recommendation.RecommendationReferralsFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

//    MaterialToolbar toolbar;
//    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        initNavigation();

    }

//    private void initNavigation() {
//        toolbar=findViewById(R.id.toppar);
//        navigationView=findViewById(R.id.nav);

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                item.setChecked(true);
//             if(item.getItemId()==R.id.itemProfile)
//                 replaceFragment(new ProfileFragment());
//             else if (item.getItemId()==R.id.itemHome) {
//                 replaceFragment(new HomeFragment());
//
//
//             }
//             else if(item.getItemId()==R.id.itemLogin)
//                 replaceFragment(new LoginFragment());
//             else if(item.getItemId()==R.id.itemRegister)
//                 replaceFragment(new RegisterFragment());
//             else if(item.getItemId()==R.id.item_about)
//                 replaceFragment(new AboutAsFragment());
//             else if (item.getItemId()==R.id.itemRecommendation)
//                 replaceFragment(new RecommendationReferralsFragment());
//                return false;
//            }
//        });
//    }
//    private void replaceFragment(Fragment fragment)
//    {
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
//        fragmentTransaction.commit();

//    }


}


