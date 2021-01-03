package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashMyApp extends DaMenu {
   // public static int timercreen = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_my_app);

        NotificationCompat.Builder nB = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.lvhi)
                .setContentTitle("The trespas")
                .setContentText("mwana check me am dying")
                .setAutoCancel(true);

        Intent in = new Intent(this, MainActivity.class);
        @SuppressLint("WrongConstant") PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, in, Intent.FLAG_ACTIVITY_NEW_TASK);
        nB.setContentIntent(pendingIntent);
        

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
