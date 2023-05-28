package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodUserListAdapter extends ArrayAdapter<FoodUser> {
    private Context context;
    private List<FoodUser> FoodUserList;
    public FoodUserListAdapter(Context context, List<FoodUser> foodItems) {
        super(context, 0, foodItems);
        this.context = context;
        this.FoodUserList = foodItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        FoodUser foodItem = FoodUserList.get(position);

        // Kiểm tra nếu view chưa được tái sử dụng, inflate layout
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_food, parent, false);
        }

            // Ánh xạ các phần tử trong list_item_food.xml\
            TextView foodNameTextView = view.findViewById(R.id.nameFood);
            TextView foodCaloriesTextView = view.findViewById(R.id.calories);
            TextView foodNutritionTextView = view.findViewById(R.id.Ingredients);
            // Đặt dữ liệu vào các phần tử
            foodNameTextView.setText(foodItem.getFoodInfo().getName());
            foodCaloriesTextView.setText(foodItem.getFoodInfo().getKcal() + " kcal");
            foodNutritionTextView.setText(foodItem.getFoodInfo().getIngredients());

        return view;
    }
}

