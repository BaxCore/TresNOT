package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LatestMuz extends AppCompatActivity {
Button btnplay , player ;
MediaPlayer plyM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_muz);
        btnplay = findViewById(R.id.toplay);
        player= findViewById(R.id.btnpause);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plyM != null && plyM.isPlaying()) {
                   plyM.stop();}
                btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plyM=MediaPlayer.create(getApplicationContext(),R.raw.tresnot);
                plyM.start();
            }
        });
    }
});
    }     }