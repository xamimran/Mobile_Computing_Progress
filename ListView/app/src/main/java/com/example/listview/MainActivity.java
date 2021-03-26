package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    EditText editText;
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.myListView);
        editText=findViewById(R.id.addPerson);
        list=new ArrayList<String>();

        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(com.example.listview.MainActivity.this,
                        Seekbar.class);
                intent.putExtra("name",list.get(position));
                startActivity(intent);
            }
        });
    }

    public void addPerson(View view) {
        arrayAdapter.notifyDataSetChanged();
        list.add(editText.getText().toString());
        Collections.sort(list);
    }

}