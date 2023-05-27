package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewFood extends AppCompatActivity {
    private ListView listView;
    private FoodListAdapter adapter;
    private List<FoodUser> foodUsersList;
    private ApiService apiService;
    private ImageView btn_breakfast;
    private ImageView btn_lunch;
    private ImageView btn_afternoon;
    private ImageView btn_dinner;
    private TextView sessionTitle;
    private TextView sumKcalDay;
    private TextView sumKcalSession;
    private float sumKcalS = 0;
    private float sumKcalD = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        listView = findViewById(R.id.list_food);
        btn_breakfast = findViewById(R.id.btn_breakfast);
        btn_lunch = findViewById(R.id.btn_lunch);
        btn_afternoon = findViewById(R.id.btn_afternoon);
        btn_dinner = findViewById(R.id.btn_dinner);
        sessionTitle = findViewById(R.id.sessionTitle);
        sumKcalDay = findViewById(R.id.sumkcal);
        sumKcalSession = findViewById(R.id.sumkcalsession);

        // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zinc-historical-epoxy.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo ApiService
        apiService = retrofit.create(ApiService.class);

        // Lấy danh sách conversations từ API
        int foodUserId = 1; // Thay đổi giá trị ID theo ý muốn
        getFoodUser(apiService, foodUserId);
        getFoodUserBySession(apiService, foodUserId, "breakfast");

        btn_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFoodUserBySession(apiService, foodUserId, "breakfast");
                sessionTitle.setText("Breakfast");
            }
        });
        btn_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFoodUserBySession(apiService, foodUserId, "lunch");
                sessionTitle.setText("Lunch");
            }
        });
        btn_afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFoodUserBySession(apiService, foodUserId, "afternoon");
                sessionTitle.setText("Afternoon");
            }

        });
        btn_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFoodUserBySession(apiService, foodUserId, "dinner");
                sessionTitle.setText("dinner");
            }
        });
    }

    private void getFoodUserBySession(ApiService apiService, int id, String Session) {
        Call<List<FoodUser>> call = apiService.getFoodUserBySession(id, Session);
        sumKcalS = 0;
        Log.d("bug", call.request().url().toString());
        call.enqueue(new Callback<List<FoodUser>>() {
            @Override
            public void onResponse(Call<List<FoodUser>> call, Response<List<FoodUser>> response) {
                if (response.isSuccessful()) {
                    foodUsersList = response.body();
                    for(int i=0 ;i < foodUsersList.size() ; i++){
                        Log.d("bug", String.valueOf(new Gson().toJson(foodUsersList.get(i).getFoodInfo().getKcal())));
                        sumKcalS = sumKcalS + foodUsersList.get(i).getFoodInfo().getKcal();
                    }
                    Log.d("bug", String.valueOf(sumKcalS));
                    sumKcalSession.setText( sumKcalS + " KCal");

//                    Log.d("bug", String.valueOf(new Gson().toJson(foodUsersList)));
                    // Tạo adapter và gán cho ListView
                    adapter = new FoodListAdapter(ViewFood.this, foodUsersList);
//                    adapter.setOnConversationClickListener(MainActivity.this); // Đăng ký listener
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(ViewFood.this, "Failed to get foodUser", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FoodUser>> call, Throwable t) {
                Toast.makeText(ViewFood.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("bug", t.getMessage());
            }
        });
    }
    private void getFoodUser(ApiService apiService, int id) {
        Call<List<FoodUser>> call = apiService.getFoodUser(id);
        sumKcalD = 0;
        Log.d("bug", call.request().url().toString());
        call.enqueue(new Callback<List<FoodUser>>() {
            @Override
            public void onResponse(Call<List<FoodUser>> call, Response<List<FoodUser>> response) {
                if (response.isSuccessful()) {
                    foodUsersList = response.body();
                    for(int i=0 ;i < foodUsersList.size() ; i++){
                        Log.d("bug", String.valueOf(new Gson().toJson(foodUsersList.get(i).getFoodInfo().getKcal())));
                        sumKcalD = sumKcalD + foodUsersList.get(i).getFoodInfo().getKcal();
                    }
                    Log.d("bug", String.valueOf(sumKcalD));
                    sumKcalDay.setText( sumKcalD + " Calories");

//                    Log.d("bug", String.valueOf(new Gson().toJson(foodUsersList)));
                    // Tạo adapter và gán cho ListView
                    adapter = new FoodListAdapter(ViewFood.this, foodUsersList);
//                    adapter.setOnConversationClickListener(MainActivity.this); // Đăng ký listener
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(ViewFood.this, "Failed to get foodUser", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FoodUser>> call, Throwable t) {
                Toast.makeText(ViewFood.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("bug", t.getMessage());
            }
        });
    }

}
