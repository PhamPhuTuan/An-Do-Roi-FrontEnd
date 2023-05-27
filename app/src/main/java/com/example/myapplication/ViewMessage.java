package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewMessage extends AppCompatActivity {
    private ListView listViewMessage;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;
    private EditText chatOfUser;
    private Button sendChat;
    private int  conversationId;
    private int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_message);
        //get id from intent
        conversationId = getIntent().getIntExtra("conversation_id", -1);
        userId = getIntent().getIntExtra("user_id", -1);
        listViewMessage = findViewById(R.id.list_message);
        Log.d("bug", String.valueOf(conversationId));
        getMessageOfUser(conversationId);

        chatOfUser = findViewById(R.id.chatOfUser);
        sendChat = findViewById(R.id.sendChat);
        sendChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("bug", String.valueOf(chatOfUser.getText()));
                postMessageOfUser(chatOfUser.getText().toString(), conversationId, userId);
            }
        });
    }
    private void getMessageOfUser(int conversationId) {
        // Sử dụng Retrofit hoặc HttpClient để fetch API mới
        // Ví dụ sử dụng Retrofit:
        Log.d("bug", "message1");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zinc-historical-epoxy.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("bug", "message2");
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Message>> call = apiService.getNewApi(conversationId);
        Log.d("bug", "message3");
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                String responseBody = response.body().toString();
                messageList = response.body();
                // Tạo adapter và gán cho ListView
//                Log.d("bug", String.valueOf(messageList.get(0)));
                messageAdapter = new MessageAdapter(ViewMessage.this, messageList, 1);
                listViewMessage.setAdapter(messageAdapter);
                Log.d("bug", responseBody);
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                // Xử lý lỗi kết nối hoặc lỗi trong quá trình fetch dữ liệu
            }
        });
    }
    private void postMessageOfUser(String messageContent, int conversationId, int userId) {
        // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zinc-historical-epoxy.glitch.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo ApiService
        ApiService apiService = retrofit.create(ApiService.class);

        // Tạo object Message
        Message message = new Message();
        message.setConversationId(conversationId);
        message.setSenderId(userId);
        message.setMessageContent(messageContent);

        // Gửi yêu cầu POST
        Call<Message> call = apiService.postMessage(message);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    // Xử lý thành công
                    chatOfUser.setText("");
                    // Lấy message đã được tạo từ response
                    Message postedMessage = response.body();

                    // Thêm message vào danh sách hiện tại (nếu cần)
                    if (messageList != null) {
                        messageList.add(postedMessage);
                        messageAdapter.notifyDataSetChanged();
                    }
                } else {
                    // Xử lý lỗi khi gửi yêu cầu POST
                    Toast.makeText(ViewMessage.this, "Failed to post message", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                // Xử lý lỗi kết nối hoặc lỗi trong quá trình gửi yêu cầu POST
                Toast.makeText(ViewMessage.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
