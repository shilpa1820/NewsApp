package com.example.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });
        holder.itime.setText("Published at: "+modelClassArrayList.get(holder.getAdapterPosition()).getPublishedAt());
        holder.iauthor.setText(modelClassArrayList.get(holder.getAdapterPosition()).getAuthor());
        holder.iheading.setText(modelClassArrayList.get(holder.getAdapterPosition()).getTitle());
        holder.icontent.setText(modelClassArrayList.get(holder.getAdapterPosition()).getDescription());
        Glide.with(context).load(modelClassArrayList.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView iheading, icontent, iauthor,itime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iheading= itemView.findViewById(R.id.mainheading);
            icontent=itemView.findViewById(R.id.content);
            iauthor=itemView.findViewById(R.id.author);
            itime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }
}
