package com.example.myapplication.retrofit;

import com.example.myapplication.model.Conversation;
import com.example.myapplication.model.FoodItem;
import com.example.myapplication.model.FoodUser;
import com.example.myapplication.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/conversation/{id}")
    Call<List<Conversation>> getConversation(@Path("id") int id);

    @POST("v1/conversation")
    Call<Conversation> postConversation(@Body Conversation conversation);

    @GET("v1/message/{id}")
    Call<List<Message>> getNewApi(@Path("id") int conversationId);

    @POST("v1/message")
    Call<Message> postMessage(@Body Message message);

    @GET("v1/conversation/{id}")
    Call<List<Conversation>> searchConversation(@Path("id") int id, @Query("name") String name);

    @GET("v1/foodsUser/{id}")
    Call<List<FoodUser>> getFoodUserBySession(@Path("id") int id, @Query("session") String session);

    @GET("v1/foodsUser/{id}")
    Call<List<FoodUser>> getFoodUser(@Path("id") int id);

    @POST("v1/foodsUser")
    Call<FoodUser> postFoodUser(@Body FoodUser foodUser);

    @GET("v1/food")
    Call<List<FoodItem>> getFoodList();

    @POST("v1/food")
    Call<FoodItem> addNewFood(@Body FoodItem foodItem);

}