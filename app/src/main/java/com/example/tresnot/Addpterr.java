package com.example.tresnot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Addpterr extends RecyclerView.Adapter<Addpterr.ViewHolder> {

    private List<String> work;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    Addpterr(Context context, List<String> work2 ){
        this.inflater=LayoutInflater.from(context);
        this.work= work2;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.computertypes,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String w = work.get(position);
        holder.textView.setText(w);

    }

    @Override
    public int getItemCount() {
        return  work.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;

        ViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.alltypes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener !=null) itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return  work.get(id);}

    public void setClickListener(ItemClickListener itemClickListener2) {
        this.itemClickListener=itemClickListener2;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}