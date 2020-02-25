package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        TextView messageView =(TextView)findViewById(R.id.messageTextView);
        messageView.setText(message);


        Button Cconsepts=(Button)findViewById(R.id.toComp);
        Cconsepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayMessageActivity.this, Addpterr.class);
                startActivity(intent);
            }
        });
    }
    public void onClose(View view) {
        super.finish();

    }
}
