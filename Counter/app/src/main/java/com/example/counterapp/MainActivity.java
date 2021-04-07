package com.example.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            count=savedInstanceState.getInt("value");
            TextView textView = findViewById(R.id.counter);
            textView.setText(String.valueOf(count));
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",count);
    }

    public void subtract(View view) {
        TextView textView = findViewById(R.id.counter);
        count = Integer.parseInt(textView.getText().toString())-1;
        textView.setText(String.valueOf(count));
    }

    public void add(View view) {
        TextView textView = findViewById(R.id.counter);
        count = Integer.parseInt(textView.getText().toString())+1;
        textView.setText(String.valueOf(count));
    }
    public void moveToActivity2(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

}