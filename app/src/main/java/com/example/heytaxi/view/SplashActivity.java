package com.example.heytaxi.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

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
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void goMainActivity() {
        Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);
        startActivity(intent);
        finish();
    }
}