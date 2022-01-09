package com.example.heytaxi.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.heytaxi.MainActivity;
import com.example.heytaxi.R;
import com.example.heytaxi.viewmodel.SplashViewModel;


public class SplashActivity extends AppCompatActivity {
    private SplashViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        model = new ViewModelProvider(this).get(SplashViewModel.class);
        model.isConnected().observe(this, isConnected -> {
            if (!isConnected) {
                alertDialog();
            }else {
                goMainActivity();
            }
        });
    }

    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hey Taxi").setMessage("서버에 연결 불가능합니다");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void goMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}