package com.mfb.frennpay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mfb.frennpaylibrary.FrennPay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startButton).setOnClickListener(view -> {
            FrennPay pay = new FrennPay();
            pay.startFrennPay(this);
        });
    }
}