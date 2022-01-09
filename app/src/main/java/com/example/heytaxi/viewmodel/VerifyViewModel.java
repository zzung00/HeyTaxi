package com.example.heytaxi.viewmodel;

import android.os.Build;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;

import com.example.heytaxi.dto.VerifyDTO;
import com.example.heytaxi.model.HeyTaxiAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyViewModel extends ViewModel {
    private int ms = 1000;
    private int value;
    private int exitDelay = 61;
    private CountDownTimer timer;
    private TextView txtTimer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void request(String phone) {
        VerifyDTO.Request request = new VerifyDTO.Request(phone, null, null);
        Call<VerifyDTO.Response> call = HeyTaxiAPI.getInstance().getService().verifyReq(request);
        call.enqueue(new Callback<VerifyDTO.Response>() {
            @Override
            public void onResponse(Call<VerifyDTO.Response> call, Response<VerifyDTO.Response> response) {
                if (response.isSuccessful()) {
                    countDown();
                }
            }

            @Override
            public void onFailure(Call<VerifyDTO.Response> call, Throwable t) {

            }
        });
    }

    public void verify(String phone, String code) {

    }

    public void countDown() {
        int delay;
        value = 61;
        delay = exitDelay * ms;
        timer = new CountDownTimer(delay, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                value--;
                txtTimer.setText(value+"");
            }

            @Override
            public void onFinish() {
                txtTimer.setText("인증시간 만료");
            }
        };
        timer.start();
    }
}
