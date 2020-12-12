package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class testmehere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmehere);
    }
    public void alarmsetting(View view){
        EditText editText = findViewById(R.id.alarmtext);
         int z =Integer.parseInt(editText.getText().toString());

        Intent intent= new Intent(getApplicationContext(),MyReceiverBroad.class);

        PendingIntent pendingIntent;
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);


        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
   alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (z* 1000),pendingIntent);
    Toast.makeText(this," Your Alarm is set in "+  z +"seconds",Toast.LENGTH_LONG).show();

    }
}
