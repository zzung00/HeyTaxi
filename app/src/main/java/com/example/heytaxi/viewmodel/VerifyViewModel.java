package com.example.heytaxi.viewmodel;

import android.os.Build;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.heytaxi.model.VerifyDTO;
import com.example.heytaxi.service.HeyTaxiAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyViewModel extends ViewModel {
    private int ms = 1000;
    private int value;
    private int exitDelay = 61;
    private CountDownTimer timer;
    private TextView txtTimer;
    private MutableLiveData<VerifyDTO.Response> result = new MutableLiveData<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LiveData<VerifyDTO.Response> request(String phone) {
        VerifyDTO.Request request = new VerifyDTO.Request(phone, null, null);
        Call<VerifyDTO.Response> call = HeyTaxiAPI.getInstance().getService().verifyReq(request);
        call.enqueue(new Callback<VerifyDTO.Response>() {
            @Override
            public void onResponse(Call<VerifyDTO.Response> call, Response<VerifyDTO.Response> response) {
                if (response.isSuccessful()) {
                    VerifyDTO.Response res = response.body();
                    result.setValue(res);
                }
            }

            @Override
            public void onFailure(Call<VerifyDTO.Response> call, Throwable t) {
                VerifyDTO.Response res = new VerifyDTO.Response();
                res.setSuccess(false);
                res.setMessage("오류가 발생했습니다! 다시 시도해주세요.");
                result.setValue(res);
            }
        });
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LiveData<VerifyDTO.Response> verify(String phone, String code) {
        VerifyDTO.Request request = new VerifyDTO.Request(phone, "", code);
        Call<VerifyDTO.Response> call = HeyTaxiAPI.getInstance().getService().verify(request);
        call.enqueue(new Callback<VerifyDTO.Response>() {
            @Override
            public void onResponse(Call<VerifyDTO.Response> call, Response<VerifyDTO.Response> response) {
                if (response.isSuccessful()) {
                    VerifyDTO.Response res = response.body();
                    res.getToken();
                    result.setValue(res);
                }
            }

            @Override
            public void onFailure(Call<VerifyDTO.Response> call, Throwable t) {
                VerifyDTO.Response res = new VerifyDTO.Response();
                res.setSuccess(false);
                result.setValue(res);
            }
        });
        return result;
    }

    public void confirm() {
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
