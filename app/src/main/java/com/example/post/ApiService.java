package com.example.post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/post")
    Call<List<Post>> getPostList();

    @POST("v1/post")
    Call<Post> postPost(@Body Post post);

    @GET("v1/postReact")
    Call<List<PostReaction>> getPostReaction(@Query("userId") int userId, @Query("postId") int postId);

    @POST("v1/postReact")
    Call<PostReaction> postPostReaction(@Body PostReaction postReaction);

    @POST("v1/postReact/like")
    Call<Void> likePost(@Body LikeRequest likeRequest);
}
