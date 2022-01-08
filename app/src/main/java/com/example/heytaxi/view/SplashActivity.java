package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.heytaxi.R;
import com.example.heytaxi.viewmodel.SplashViewModel;


public class SplashActivity extends AppCompatActivity {
    private SplashViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        model = new ViewModelProvider(this).get(SplashViewModel.class);
        model.isConnected().observe(this, isConnected -> {
            System.out.println(isConnected);
            if (!isConnected) {
                Toast.makeText(getApplicationContext(), "not!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}