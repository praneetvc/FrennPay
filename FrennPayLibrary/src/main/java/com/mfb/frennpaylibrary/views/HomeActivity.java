package com.mfb.frennpaylibrary.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.mfb.frennpaylibrary.R;
import com.mfb.frennpaylibrary.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        loadFragment(new HomeFragment());
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameMainLayout, fragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}