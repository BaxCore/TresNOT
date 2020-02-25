package com.example.tresnot;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Addpterr extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String[] items;

    public Addpterr(Context context, String[] items){
    this.context=context;
    this.items=items;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View rows=inflater.inflate(R.layout.computertypes, parent, false);
        Tems items=new Tems(rows);
        return items;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Tems)holder).textView.setText(items[position]);
    }

    @Override
    public int getItemCount() {

        return items.length;
    }
    public class Tems extends RecyclerView.ViewHolder {
        TextView textView;
        public Tems(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.alltypes);
        }
    }
}
