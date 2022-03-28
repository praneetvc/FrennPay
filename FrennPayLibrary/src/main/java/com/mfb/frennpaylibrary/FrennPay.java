package com.mfb.frennpaylibrary;

import android.content.Context;
import android.content.Intent;

public class FrennPay {
    public void startFrennPay(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }
}
