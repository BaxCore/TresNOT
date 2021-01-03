package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exam extends AppCompatActivity {
    Button not;
    String mee="Gwe man can you see this";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        not = findViewById(R.id.notc);

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder bb = new NotificationCompat.Builder(
                        exam.this)
                        .setSmallIcon(R.drawable.lvhi)
                        .setContentTitle("Man")
                        .setContentText("this is a funny notification for plactice")
                        .setAutoCancel(true);

                Intent i = new Intent(exam.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("See that",mee);

                PendingIntent pd = PendingIntent.getActivity(exam.this,
                        0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                bb.setContentIntent(pd);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, bb.build());

            }
        });

    }

}