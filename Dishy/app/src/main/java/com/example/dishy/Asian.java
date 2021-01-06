package com.example.dishy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dishy.adapter.CategoryAdapter;
import com.example.dishy.adapter.RestaurantsAdapter;
import com.example.dishy.adapter.TopRatedAdapter;

import java.util.ArrayList;
import java.util.List;

public class Asian extends AppCompatActivity {

    RecyclerView rest_recycler;
    RestaurantsAdapter restaurantsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asian);


        List<Restaurant> restaurants=new ArrayList<>();
        restaurants.add(new Restaurant("Name1", R.drawable.restaurant1,"4","3"));
        restaurants.add(new Restaurant("Name 2", R.drawable.restaurant2,"3","6"));
        restaurants.add(new Restaurant("Name 3", R.drawable.restaurant3,"5","4"));
        restaurants.add(new Restaurant("Name1", R.drawable.restaurant1,"4","3"));
        restaurants.add(new Restaurant("Name 2", R.drawable.restaurant2,"3","6"));
        restaurants.add(new Restaurant("Name 3", R.drawable.restaurant3,"5","4"));

        setrestaurantRecycler(restaurants);
    }


    private void setrestaurantRecycler(List<Restaurant> restList){
        rest_recycler=findViewById(R.id.asianRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rest_recycler.setLayoutManager(layoutManager);
        restaurantsAdapter=new RestaurantsAdapter(this,restList);
        rest_recycler.setAdapter(restaurantsAdapter);


    }
}