package com.example.tresnot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.widget.Toast;

public class MyReceiverBroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast toast = Toast.makeText(context,"Man YES Man", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        Vibrator vibratoralm;
        vibratoralm = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibratoralm.vibrate(4000);
    }
}
