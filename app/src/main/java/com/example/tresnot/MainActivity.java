package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends DaMenu {

    TextView tView;
    Ringtone rtone;
    RecyclerView recyclerView;

    String[] types={"upercomputer", "Mainframe", "Server Computer", "Workstation Computer",
            "Personal Computer or PC", "Microcontroller","Smartphone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Addpterr(this, types));
*/
        tView = findViewById(R.id.Batry);
        BroadcastReceiver BLevel = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Integer BtryL = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                tView.setText(BtryL.toString() + "%");
                if (BtryL < 98) {
                    rtone.play();
                }

            }
        };
        registerReceiver(BLevel, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }
    public void sendMessage(View view){

        EditText message = (EditText)findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");

    }


    public void stpAlm(View view) {

    }
}
