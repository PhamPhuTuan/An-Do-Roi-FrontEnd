package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends ArrayAdapter<FoodUser> {
    private Context context;
    private List<FoodUser> FoodUserList;
    public FoodListAdapter(Context context, List<FoodUser> foodItems) {
        super(context, 0, foodItems);
        this.context = context;
        this.FoodUserList = foodItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Lấy dữ liệu mục hiện tại
//        FoodUser foodItem = getItem(position);
        Log.d("bug", "getView: ");

        // Kiểm tra nếu view chưa được tái sử dụng, inflate layout
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_food, parent, false);
        }

        // Ánh xạ các phần tử trong list_item_food.xml
        TextView foodNameTextView = convertView.findViewById(R.id.nameFood);
        TextView foodCaloriesTextView = convertView.findViewById(R.id.calories);
//        ImageView foodImageView = convertView.findViewById(R.id.foodImage);

        // Đặt dữ liệu vào các phần tử
//        foodNameTextView.setText(foodItem.getName());
//        foodCaloriesTextView.setText(foodItem.getCalories());
//        foodImageView.setImageResource(foodItem.getImageResId());

        foodNameTextView.setText("chuoi");
        foodCaloriesTextView.setText("512 calories");
//        foodImageView.setImageResource(foodItem.getImageResId());

        return convertView;
    }
}
