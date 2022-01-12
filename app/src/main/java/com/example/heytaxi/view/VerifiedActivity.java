package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heytaxi.R;
import com.example.heytaxi.viewmodel.VerifyViewModel;

public class VerifiedActivity extends AppCompatActivity {
    private EditText verifyNum;
    private Button btnVerified;
    private String phone;
    private VerifyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified);

        verifyNum = (EditText) findViewById(R.id.editVerifyNum);
        btnVerified = (Button) findViewById(R.id.btnVerified);
        phone = getIntent().getParcelableExtra("phone");
        viewModel = new ViewModelProvider(this).get(VerifyViewModel.class);

        btnVerified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
            }
        });
    }

    private void verify() {
        viewModel.verify(phone, verifyNum.getText().toString()).observe(this, response -> {
            if (response.isSuccess() == true) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}