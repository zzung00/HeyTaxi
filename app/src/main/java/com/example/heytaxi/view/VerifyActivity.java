package com.example.heytaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heytaxi.R;
import com.example.heytaxi.viewmodel.VerifyViewModel;

public class VerifyActivity extends AppCompatActivity {
    private EditText phoneNum;
    private Button btnVerifyReq;
    private VerifyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        phoneNum = (EditText) findViewById(R.id.editPhoneNum);
        btnVerifyReq = (Button) findViewById(R.id.btnVerifyReq);
        viewModel = new ViewModelProvider(this).get(VerifyViewModel.class);

        btnVerifyReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    private void request() {
        viewModel.request(phoneNum.getText().toString()).observe(this, response -> {
            if (response.isSuccess() == true) {
                Intent intent = new Intent(getApplicationContext(), VerifiedActivity.class);
                intent.putExtra("phone", phoneNum.getText().toString());
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}