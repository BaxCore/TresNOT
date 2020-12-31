package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SavePlace extends AppCompatActivity {
    EditText plcV;
    Button save;
    ListView listplaces;

        DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_place);

        plcV = findViewById(R.id.loct);
        save = findViewById(R.id.addPlace);
        listplaces = findViewById(R.id.listplaces);






    }
}