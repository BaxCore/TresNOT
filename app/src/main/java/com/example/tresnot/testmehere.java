package com.example.tresnot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class testmehere extends DaMenu{

    ImageView imageView;
    Button camerOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmehere);

        imageView = findViewById(R.id.imag);
        camerOpen = findViewById(R.id.Opencamera);

        //Camera permission
        if(ContextCompat.checkSelfPermission(testmehere.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(testmehere.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    120);
        }
        camerOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,120);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120) {
            Bitmap captionImj = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captionImj);
        }
    }

/*
    public void alarmsetting(View view){
        EditText editText = findViewById(R.id.alarmtext);
         int z =Integer.parseInt(editText.getText().toString());

        Intent intent= new Intent(getApplicationContext(),MyReceiverBroad.class);

        PendingIntent pendingIntent;
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);


        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
   alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (z* 1000),pendingIntent);
    Toast.makeText(this," Your Alarm is set in "+  z +"seconds",Toast.LENGTH_LONG).show();

    }*/
}
