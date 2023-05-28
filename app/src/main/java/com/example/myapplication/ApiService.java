package com.example.myapplication;

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

    @GET("v1/foodsUser")
    Call<FoodUser> postFoodUser(@Body FoodUser foodUser);

    @GET("v1/food")
    Call<List<FoodItem>> getFoodList();

}