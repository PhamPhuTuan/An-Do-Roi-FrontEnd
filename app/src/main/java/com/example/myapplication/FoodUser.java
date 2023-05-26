package com.example.myapplication;

public class FoodUser {
    private int foodId;
    private int userId;
    private long useDatetime;
    private String session;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getUseDatetime() {
        return useDatetime;
    }

    public void setUseDatetime(long useDatetime) {
        this.useDatetime = useDatetime;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
