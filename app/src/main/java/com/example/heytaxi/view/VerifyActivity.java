package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.heytaxi.R;

public class VerifyActivity extends AppCompatActivity {
    private EditText phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        phoneNum = (EditText) findViewById(R.id.editPhoneNum);
    }
}