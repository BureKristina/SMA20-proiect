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
import com.example.dishy.Categories;
import com.example.dishy.Mexican;
import com.example.dishy.R;

import java.util.List;


public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Categories> categories;
    private CategoryViewHolder.OnCategoryListener listener;


    public CategoryAdapter(Context context, List<Categories> categories, CategoryViewHolder.OnCategoryListener listener) {
        this.context = context;
        this.categories = categories;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category, parent, false);
        return new CategoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.image.setImageResource(categories.get(position).getImageUrl());
        holder.name.setText(categories.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                //treba da se promeni po categorijama , za sada za sve otvara Mexican food
                //set-up je sve , napravljene akctivities, samo treba da se napravi switch
                Intent i=new Intent(context, Mexican.class);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public static final class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView name;
        OnCategoryListener onCategoryListener;

        public CategoryViewHolder(@NonNull View itemView,OnCategoryListener onCategoryListener) {
            super(itemView);
            image = itemView.findViewById(R.id.catImg);
            name = itemView.findViewById(R.id.catName);
            this.onCategoryListener=onCategoryListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCategoryListener.OnCategoryClick(getAdapterPosition());

        }

        public interface OnCategoryListener{
            void OnCategoryClick(int position);
        }

    }



}
