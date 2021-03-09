package com.example.layouts05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HorizantalLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizantal_layout);
    }
    public void moveToActivity1(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}