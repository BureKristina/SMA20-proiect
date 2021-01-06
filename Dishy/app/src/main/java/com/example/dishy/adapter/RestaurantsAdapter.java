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
import com.example.dishy.Restaurant;
import com.example.dishy.TopRated;

import java.util.List;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder> {

    Context context;
    List<Restaurant> restaurantsList;

    public RestaurantsAdapter(Context context, List<Restaurant> restaurantsList) {
        this.context=context;
        this.restaurantsList=restaurantsList;
    }

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.restaurant,parent,false);
        return new RestaurantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

        holder.restaurantImage.setImageResource(restaurantsList.get(position).getImageUrl());
        holder.name.setText(restaurantsList.get(position).getName());
        holder.spots.setText(restaurantsList.get(position).getSpots());


    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public static final  class RestaurantsViewHolder extends RecyclerView.ViewHolder{

        ImageView restaurantImage;
        TextView spots,name;

        public RestaurantsViewHolder(@NonNull View itemView){
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.restImg);
            name=itemView.findViewById(R.id.restName);
            spots=itemView.findViewById(R.id.freeSpots);

        }

    }

}

