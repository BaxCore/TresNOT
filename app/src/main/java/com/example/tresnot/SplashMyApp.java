package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashMyApp extends DaMenu {
   // public static int timercreen = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_my_app);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashMyApp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}
