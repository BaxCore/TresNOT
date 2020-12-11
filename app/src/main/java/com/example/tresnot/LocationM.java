package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class LocationM extends DaMenu {
    InputStream Ccode;
    TextView textView;
    Button buttonCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_m);

        Button Cconsepts=(Button)findViewById(R.id.ListCons);
        Cconsepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LocationM.this,Listing.class);
                startActivity(intent);
            }
        });


        textView=findViewById(R.id.TheCode);
        buttonCode=findViewById(R.id.CodeSee);

        buttonCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sos="";

                try{
                    Ccode=getAssets().open("mult.c");
                    int rootsize=Ccode.available();
                    byte[] baxArray=new byte[rootsize];
                    Ccode.read(baxArray);
                    Ccode.close();
                    Sos=new String(baxArray);

                }catch (IOException mac){
                    mac.printStackTrace();
                }
                textView.setText((CharSequence) Sos);


            }
        });
    }
}
