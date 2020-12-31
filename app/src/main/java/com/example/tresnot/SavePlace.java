package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SavePlace extends AppCompatActivity {
    EditText plcV;
    Button save;
    ListView listplaces;

        DbHelper dbHelper;
        ArrayList arrayList;
        ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_place);

        plcV = findViewById(R.id.loct);
        save = findViewById(R.id.addPlace);
        listplaces = findViewById(R.id.listplaces);

        final DbHelper dbHelper= new DbHelper(SavePlace.this);
        arrayList = dbHelper.Viewing();
        arrayAdapter = new ArrayAdapter(SavePlace.this, android.R.layout.activity_list_item, arrayList);
        listplaces.setAdapter(arrayAdapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newplace = plcV.getText().toString();
                if(!newplace.isEmpty()){
                    if(dbHelper.adding(newplace)){
                    plcV.setText("");
                    Toast.makeText(getApplicationContext(), "Place Added", Toast.LENGTH_LONG).show();
                    arrayList.clear();
                    arrayList.addAll(dbHelper.Viewing());
                    arrayAdapter.notifyDataSetChanged();
                    listplaces.invalidateViews();
                    listplaces.refreshDrawableState();



                    }
                }
            }
        });





    }
}