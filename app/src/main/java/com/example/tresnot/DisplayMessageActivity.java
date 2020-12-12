package com.example.tresnot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DisplayMessageActivity extends DaMenu {
    TextView textView;
    Button Saver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("MESSAGE");
        TextView messageView =(TextView)findViewById(R.id.messageTextView);
        messageView.setText(message);


        Button Cconsepts=(Button)findViewById(R.id.toComp);
        Cconsepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayMessageActivity.this, RecyclerClass.class);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.messageTextView);
        Saver = findViewById(R.id.SaveEntered);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }
        Saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filname = textView.getText().toString();

                if(!filname.equals("")){
                    saveTaxtasF(filname);
                }
            }
        });


    }
    public void onClose(View view) {
        super.finish();

    }

    public void SaveCod(View view) {


    }

    private void saveTaxtasF(String filname){
        String Filname = filname + ".txt";

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filname);

        try {

            FileOutputStream Fos = null;
            Fos = new FileOutputStream(file);
            Fos.write(filname.getBytes());
            Fos.close();
            Toast.makeText(this,"Saved Successfuly", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"File not Saved", Toast.LENGTH_SHORT).show();

        } catch (IOException in){
            in.printStackTrace();
            Toast.makeText(this,"File not Saved", Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Storage access Granted", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this,"Storage access Denied", Toast.LENGTH_SHORT).show();
                    finish();



        }
    }
}
