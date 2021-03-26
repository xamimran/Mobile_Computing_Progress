package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayName extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__name);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("name"));
    }
}