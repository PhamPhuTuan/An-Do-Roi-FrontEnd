package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewFood extends AppCompatActivity {
    private ListView listView;
    private FoodListAdapter adapter;
    private List<FoodUser> foodUsersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        listView = findViewById(R.id.list_food);
        foodUsersList = new ArrayList<>();
        FoodUser foodUser = new FoodUser();
        foodUser.setFoodId(3);
        foodUser.setUserId(1);
        foodUser.setUseDatetime(1683103370);
        foodUser.setSession("Teo");

        foodUsersList.add(foodUser);
        adapter = new FoodListAdapter(ViewFood.this, foodUsersList);
        listView.setAdapter(adapter);

    }
}
