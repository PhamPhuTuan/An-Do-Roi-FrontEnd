package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewFood extends AppCompatActivity {

    private EditText attachmentEditText;
    private EditText ingredientsEditText;
    private EditText nameEditText;
    private EditText nutritionEditText;
    private EditText recipeEditText;
    private EditText kcalEditText;
    private Button addNewFood;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.add_new_food);

        attachmentEditText = findViewById(R.id.attachmentEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        nameEditText = findViewById(R.id.nameEditText);
        nutritionEditText = findViewById(R.id.nutritionEditText);
        recipeEditText = findViewById(R.id.recipeEditText);
        kcalEditText = findViewById(R.id.kcalEditText);
        addNewFood = findViewById(R.id.addNewFood);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.0.177:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Tạo đối tượng FoodApiService
        ApiService apiService = retrofit.create(ApiService.class);

        addNewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postFood(apiService);
                Intent intent = new Intent(AddNewFood.this, AddNewFoodUserActivity.class);
                startActivity(intent);
            }
        });
    }

    private void postFood(ApiService apiService) {

        // Tạo object Message

        FoodItem foodItem = new FoodItem();
        foodItem.setAttachment(attachmentEditText.getText().toString());
        foodItem.setIngredients(ingredientsEditText.getText().toString());
        foodItem.setName(nameEditText.getText().toString());
        foodItem.setNutrition(nutritionEditText.getText().toString());
        foodItem.setRecipe(recipeEditText.getText().toString());
        foodItem.setKcal(Integer.parseInt(kcalEditText.getText().toString()));

        // Gửi yêu cầu POST
        Call<FoodItem> call = apiService.addNewFood(foodItem);
        Log.d("bug", "voo");
        call.enqueue(new Callback<FoodItem>() {
            @Override
            public void onResponse(Call<FoodItem> call, Response<FoodItem> response) {
                if (response.isSuccessful()) {
                    // Xử lý thành công
                    FoodItem postedFoodUser = response.body();
//                    Log.d("bug", String.valueOf(new Gson().toJson(postedFoodUser)));
                    Toast.makeText(AddNewFood.this, "Post food successfully", Toast.LENGTH_SHORT).show();

//                    }
                } else {
                    // Xử lý lỗi khi gửi yêu cầu POST
                    Toast.makeText(AddNewFood.this, "Failed to post food", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodItem> call, Throwable t) {
                // Xử lý lỗi kết nối hoặc lỗi trong quá trình gửi yêu cầu POST
                Toast.makeText(AddNewFood.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
