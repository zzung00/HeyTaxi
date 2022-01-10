package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heytaxi.R;

public class VerifyActivity extends AppCompatActivity {
    private EditText phoneNum;
    private Button btnVerifyReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        phoneNum = (EditText) findViewById(R.id.editPhoneNum);
        btnVerifyReq = (Button) findViewById(R.id.btnVerifyReq);

        btnVerifyReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VerifiedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}