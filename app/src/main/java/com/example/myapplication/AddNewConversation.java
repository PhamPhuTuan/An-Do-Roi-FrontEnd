package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewConversation extends AppCompatActivity {
    private EditText userIdEditText;
    private EditText partnerIdEditText;
    private CheckBox isGroupConverCheckBox;
    private EditText lastActiveEditText;
    private EditText nicknameEditText;
    private Button addConversationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_conversation);

        // Ánh xạ các thành phần UI
        userIdEditText = findViewById(R.id.userIdEditText);
        partnerIdEditText = findViewById(R.id.partnerIdEditText);
        isGroupConverCheckBox = findViewById(R.id.isGroupConverCheckBox);
        lastActiveEditText = findViewById(R.id.lastActiveEditText);
        nicknameEditText = findViewById(R.id.nicknameEditText);
        addConversationButton = findViewById(R.id.addConversationButton);

        // Xử lý sự kiện khi nhấn nút "Add Conversation"
        addConversationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ các trường EditText và CheckBox
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://172.20.135.219:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                // Tạo đối tượng FoodApiService
                ApiService apiService = retrofit.create(ApiService.class);

                // Thực hiện xử lý thêm cuộc trò chuyện
                addConversation(apiService);

                Intent intent = new Intent(AddNewConversation.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addConversation(ApiService apiService) {
        // Gọi API hoặc thực hiện các thao tác để thêm cuộc trò chuyện vào hệ thống
        // ...
        int userId = Integer.parseInt(userIdEditText.getText().toString());
        int partnerId = Integer.parseInt(partnerIdEditText.getText().toString());
        boolean isGroupConver = isGroupConverCheckBox.isChecked();
        int lastActive = Integer.parseInt(lastActiveEditText.getText().toString());
        String nickname = nicknameEditText.getText().toString();

        Conversation conversation = new Conversation();
        conversation.setUserId(userId);
        conversation.setPartnerId(partnerId);
        conversation.setGroupConver(isGroupConver);
        conversation.setLastActive(lastActive);
        conversation.setNickname(nickname);

        // Gửi yêu cầu POST
        Call<Conversation> call = apiService.postConversation(conversation);
        Log.d("bug", "voo");
        call.enqueue(new Callback<Conversation>() {
            @Override
            public void onResponse(Call<Conversation> call, Response<Conversation> response) {
                if (response.isSuccessful()) {
                    Log.d("bug", "Voo trong response");
                    // Xử lý thành công
                    Conversation postedConversation = response.body();
//                    Log.d("bug", String.valueOf(new Gson().toJson(postedFoodUser)));
                    Toast.makeText(AddNewConversation.this, "Post Conversation successfully", Toast.LENGTH_SHORT).show();
//                    }
                } else {
                    // Xử lý lỗi khi gửi yêu cầu POST
                    Toast.makeText(AddNewConversation.this, "Failed to post food", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Conversation> call, Throwable t) {
                // Xử lý lỗi kết nối hoặc lỗi trong quá trình gửi yêu cầu POST
                Toast.makeText(AddNewConversation.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

