package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ALC1","onCreate Called");
        if(savedInstanceState!=null)
        {
            count=savedInstanceState.getInt("value");
            TextView countTextView=findViewById(R.id.count);
            countTextView.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",count);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC1","onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC1","onResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC1","onPause Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC1","onDestroy Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC1","onStop Called");
    }

    public void increaseCount(View view) {
        TextView countTextView=findViewById(R.id.count);
        count=Integer.parseInt(countTextView.getText().toString())+1;
        countTextView.setText(String.valueOf(count));
    }

    public void moveToActivity2(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void moveToActivity3(View view) {
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}