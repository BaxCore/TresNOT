package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class RecyclerClass extends AppCompatActivity implements Addpterr.ItemClickListener {
    RecyclerView recyclerView;
    Addpterr adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_class);

        recyclerView=findViewById(R.id.recycle);

        ArrayList<String> elements = new ArrayList<>();
        elements.add("Supercomputer");
        elements.add("Mainframe");
        elements.add("Server Computer");
        elements.add("Workstation Computer");
        elements.add("Personal Computer or PC");
        elements.add("Microcontroller");
        elements.add("Smartphone");

        //set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Addpterr(this,elements);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}