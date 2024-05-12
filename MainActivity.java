package com.example.medhost;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.example.medhost.databinding.ActivityMainBinding;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_doctor, R.id.nav_medicine)
                .setOpenableLayout(drawer)
                .build();

        // Setting up button navigation
        findViewById(R.id.btnDoctors).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DoctorsActivity.class)));
        findViewById(R.id.btnPatients).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PatientsActivity.class)));
        findViewById(R.id.btnNurses).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NursesActivity.class)));
        findViewById(R.id.btnMedicines).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MedicinesActivity.class)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}


