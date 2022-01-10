package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heytaxi.R;

public class VerifiedActivity extends AppCompatActivity {
    private EditText verifyNum;
    private Button btnVerified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verified);

        verifyNum = (EditText) findViewById(R.id.editVerifyNum);
        btnVerified = (Button) findViewById(R.id.btnVerified);

        btnVerified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}