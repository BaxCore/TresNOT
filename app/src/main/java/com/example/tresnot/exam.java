package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exam extends AppCompatActivity {
    Button not;
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


            }
        });

    }

}