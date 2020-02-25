package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        ListView listView = (ListView)findViewById(R.id.ClistCons);
        List<String> dataList = new ArrayList<String>();
        dataList.add("Arrays");
        dataList.add("Functions");
        dataList.add("Files");
        dataList.add("Loops");
        dataList.add("Data structures");
        dataList.add("Functions");
        dataList.add("Variables");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(Listing.this, "You clicked " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
