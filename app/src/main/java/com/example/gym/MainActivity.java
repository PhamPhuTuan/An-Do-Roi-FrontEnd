package com.example.gym;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.Console;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private LinearLayout llNameContainer, llAddressContainer, llParentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);


        redirection();
    }

    public void redirection() {
        Button myButton = (Button) findViewById(R.id.buttonLogin);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn vào button", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.item_user);
            }
        });

        BottomNavigationView btNav = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        System.out.print("btNav");
        System.out.print(btNav);
        if (btNav != null) {
        btNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.users:
                        setContentView(R.layout.item_user);
                        return true;

                    case R.id.courses:
                        setContentView(R.layout.caloriestracking);
                        return true;

                    case R.id.post:
                        setContentView(R.layout.feeds);
                        return true;

                    case R.id.order:
                        setContentView(R.layout.payment);
                        return true;
                    default:
                        return true;
                }
            }
        });}
    }
    private void updateNavigationBarState(int actionId){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();

        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            System.out.print(item);
            item.setChecked(item.getItemId() == actionId);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.users:
                setContentView(R.layout.item_user);
                return true;

            case R.id.courses:
                setContentView(R.layout.caloriestracking);
                return true;

            case R.id.post:
                setContentView(R.layout.feeds);
                return true;

            case R.id.order:
                setContentView(R.layout.payment);
                return true;
            default:
                setContentView(R.layout.item_user);
                return true;

        }
    }
}
