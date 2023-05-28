package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodListAdapter extends ArrayAdapter<FoodItem> {
    private Context context;
    private List<FoodItem> FoodList;
    public FoodListAdapter(Context context, List<FoodItem> foodItems) {
        super(context, 0, foodItems);
        this.context = context;
        this.FoodList = foodItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        FoodItem foodItem = FoodList.get(position);

        // Kiểm tra nếu view chưa được tái sử dụng, inflate layout
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        // Ánh xạ các phần tử trong list_item_food.xml\
        TextView foodIdTextView = view.findViewById(R.id.text_id);
        TextView foodNameTextView = view.findViewById(R.id.text_name);

        TextView foodNutritionTextView = view.findViewById(R.id.text_nutrition);
        TextView foodKcalTextView = view.findViewById(R.id.text_kcal);

        // Đặt dữ liệu vào các phần tử
        foodIdTextView.setText(foodItem.get_id() + "");

        foodNameTextView.setText(foodItem.getName());

        foodNutritionTextView.setText(foodItem.getNutrition());

        foodKcalTextView.setText(foodItem.getKcal() + " Calories");

        return view;
    }
}
