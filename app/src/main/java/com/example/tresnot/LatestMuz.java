package com.example.tresnot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class LatestMuz extends DaMenu {
    Button ply;
    SeekBar seekBar;
    TextView timlevel;
    MediaPlayer mediaPlayer;
    int ttime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_muz);
        ply = findViewById(R.id.pla);

        mediaPlayer = MediaPlayer.create(this, R.raw.script);
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        ttime=mediaPlayer.getDuration();
        seekBar = findViewById(R.id.sikbar);
        seekBar.setMax(ttime);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(fromUser){
                            mediaPlayer.seekTo(progress);
                            seekBar.setProgress(progress);

                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer!=null){
                    try {
                        Message message = new Message();
                        message.what= mediaPlayer.getCurrentPosition();
                        handler.sendMessage(message);
                        Thread.sleep(1000);

                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();

    };
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentpos = msg.what;
            seekBar.setProgress(currentpos);

            //    String timstamp = seekBar(currentpos);

        };

    };
    public void playBton(View view){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }else {
            mediaPlayer.pause();

        }
    }
}
