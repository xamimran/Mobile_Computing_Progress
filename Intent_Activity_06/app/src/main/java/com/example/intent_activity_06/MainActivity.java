package com.example.intent_activity_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText =  findViewById(R.id.editText);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToWeb(View view)
    {
        Uri uri = Uri.parse("http://www.google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void dialCall(View view)
    {
        Uri uri = Uri.parse("tel:+923217419495");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    public void customWeb(View view) {
        String url=editText.getText().toString();
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}