package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ListView listView;
    static ListViewAdapter adapter;

    static Context context;
    static ArrayList<String> name;
    static ArrayList<String> time;
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // page message, group chat, post, chat
        setContentView(R.layout.message);

//        setContentView(R.layout.group_chat);

//        setContentView(R.layout.post);

//        setContentView(R.layout.chat);


        listView = findViewById(R.id.listview);
        name = new ArrayList<>();
        name.add("Tuan");
        name.add("Thanh");
        name.add("Nghia");

        time = new ArrayList<>();
        time.add("2s ago");
        time.add("1 minute");
        time.add("5 minute");

        adapter = new ListViewAdapter(this, name, time);
        listView.setAdapter(adapter);
    }
}