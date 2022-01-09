package com.example.heytaxi.viewmodel;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerifyViewModel extends ViewModel {
    private MutableLiveData<String> phone = new MutableLiveData<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void request(String phone) {

    }

    public void verify(String phone, String code) {

    }
}
