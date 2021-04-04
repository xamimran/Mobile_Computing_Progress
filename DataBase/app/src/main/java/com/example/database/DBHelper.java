package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_AGE = "CustomerAge";
    public static final String ACTIVE_CUSTOMER = "ActiveCustomer";
    public static final String CUSTOMER_ID = "CustomerID";
    public static final String CUST_TABLE = "CustTable";

    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUST_TABLE + "(" + CUSTOMER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " Text, " + CUSTOMER_AGE + " Int, " + ACTIVE_CUSTOMER + " BOOL) ";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addCustomer(com.example.database.Customer customerModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CUSTOMER_NAME, customerModel.getName());
        cv.put(CUSTOMER_AGE, customerModel.getAge());
        cv.put(ACTIVE_CUSTOMER, customerModel.isActive());
        long insert = db.insert(CUST_TABLE, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public List<com.example.database.Customer> getAllRecords()
    {
        List<com.example.database.Customer> list = new ArrayList<>();
        String query = "SELECT * FROM " +CUST_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
            do {
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                Boolean isActive = cursor.getInt(3)==1?Boolean.TRUE:Boolean.FALSE;
                list.add(new com.example.database.Customer(name,age,isActive,1));
            }while (cursor.moveToNext());
            cursor.close();
            db.close();
            return list;

    }
}