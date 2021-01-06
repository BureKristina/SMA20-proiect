package com.example.dishy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dishy.adapter.CategoryAdapter;
import com.example.dishy.adapter.TopRatedAdapter;
import com.example.dishy.ui.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryViewHolder.OnCategoryListener {

    RecyclerView topRecycler, catRecycler;
    TopRatedAdapter topRestaurantAdapter;
    CategoryAdapter categoryAdapter;

   ImageButton helpButton;
    List<Categories> categoryList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helpButton = (ImageButton) findViewById(R.id.helpButton);

        List<TopRated> topRatedList=new ArrayList<>();
        topRatedList.add(new TopRated("Name1", "free spots:4",R.drawable.restaurant1));
        topRatedList.add(new TopRated("Name 2","free spots: 15", R.drawable.restaurant2));
        topRatedList.add(new TopRated("Name 3","free spots: 12", R.drawable.restaurant3));

        setTopRecycler(topRatedList);


        categoryList.add(new Categories("Asian food",R.drawable.restaurant1));
        categoryList.add(new Categories("Indian food",R.drawable.restaurant1));
        categoryList.add(new Categories("Mexican food",R.drawable.restaurant1));


        setCategoryRecycler(categoryList);


    }

     public void displayHelp(View view){
         Snackbar snackbar=Snackbar.make(findViewById(R.id.main),R.string.helpMessage, Snackbar.LENGTH_LONG);
         snackbar.show();
     }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.account:
                Intent log_in_intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(log_in_intent);
                return true;
            case R.id.log_out:
                //
                return true;
            case R.id.settings:
                Intent settings_intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(settings_intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setTopRecycler(List<TopRated> topRatedList){
        topRecycler=findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        topRecycler.setLayoutManager(layoutManager);
        topRestaurantAdapter=new TopRatedAdapter(this,topRatedList);
        topRecycler.setAdapter(topRestaurantAdapter);


    }

    private void setCategoryRecycler(List<Categories> categoriesList){
        catRecycler=findViewById(R.id.categoriesRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        catRecycler.setLayoutManager(layoutManager);
        categoryAdapter=new CategoryAdapter(this,categoriesList, this);
        catRecycler.setAdapter(categoryAdapter);


    }

    @Override
    public void OnCategoryClick(int position) {

        Intent intent=new Intent(this,Mexican.class);
        startActivity(intent);
    }


}