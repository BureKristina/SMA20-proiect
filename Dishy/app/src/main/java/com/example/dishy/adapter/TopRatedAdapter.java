package com.example.dishy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dishy.Asian;
import com.example.dishy.Mexican;
import com.example.dishy.R;
import com.example.dishy.TopRated;

import java.util.List;

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder> {

    Context context;
    List<TopRated> topRatedList;

    public TopRatedAdapter(Context context, List<TopRated> topRatedList) {
        this.context=context;
        this.topRatedList=topRatedList;
    }

    @NonNull
    @Override
    public TopRatedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.top_rated,parent,false);
        return new TopRatedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedViewHolder holder, int position) {

        holder.restaurantImage.setImageResource(topRatedList.get(position).getImageUrl());
        holder.name.setText(topRatedList.get(position).getName());
        holder.spots.setText(topRatedList.get(position).getSpots());

        holder.itemView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, Asian.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return topRatedList.size();
    }

    public static final  class TopRatedViewHolder extends RecyclerView.ViewHolder{

        ImageView restaurantImage;
        TextView spots,name;

        public TopRatedViewHolder(@NonNull View itemView){
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restImg);
            name=itemView.findViewById(R.id.restName);
            spots=itemView.findViewById(R.id.freeSpots);

        }

    }

}
