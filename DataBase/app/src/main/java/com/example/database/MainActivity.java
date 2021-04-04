package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd,buttonView;
    EditText editName ,editAge;
    Switch switchIsActive;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        buttonAdd=findViewById(R.id.buttonAdd);
        buttonView=findViewById(R.id.buttonView);

        editName=findViewById(R.id.editTextName);
        editAge=findViewById(R.id.editTextAge);
        switchIsActive=findViewById(R.id.switch1);

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            Customer customerModel;
            @Override
            public void onClick(View view){
                customerModel=new Customer(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchIsActive.isChecked(),1);
                Toast.makeText(com.example.database.MainActivity.this,customerModel.toString(),Toast.LENGTH_LONG).show();
                DBHelper dbHelper = new DBHelper(com.example.database.MainActivity.this);
                boolean b = dbHelper.addCustomer(customerModel);

            }
        });
        buttonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(com.example.database.MainActivity.this,"view button clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}