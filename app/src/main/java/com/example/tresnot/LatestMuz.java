package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LatestMuz extends DaMenu {
    MediaPlayer Mediaplayer;
    Button starter,stoper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_muz);
        starter = findViewById(R.id.toplay);
        stoper = findViewById(R.id.btnpause);
        stoper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Mediaplayer != null && Mediaplayer.isPlaying()) {
                    Mediaplayer.stop();}
            }
        });
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mediaplayer= MediaPlayer.create(getApplicationContext(),R.raw.script);
                Mediaplayer.start();
            }
        });
    }
}
