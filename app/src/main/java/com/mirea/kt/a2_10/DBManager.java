package com.mirea.kt.a2_10;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteOpenHelper;
    public DBManager(SQLiteOpenHelper sqLiteOpenHelper){
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }
    public boolean savePersonToDB(Cars cars){
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", cars.getModel());
        contentValues.put("last_name", cars.getNumber());
        contentValues.put("age", cars.getAge());
        long rowId = db.insert("TABLE_PERSONS", null, contentValues);
        contentValues.clear();
        db.close();
        return rowId != 1;
    }
    public ArrayList<Cars> loadAllFromDB(){
        ArrayList<Cars> people = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query("TABLE_PERSONS", null, null, null,null, null, null);
        if (cursor.moveToFirst()){
            do{
                String fName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
                String lName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"));
                int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
                people.add(new Cars(fName, lName, age));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return people;
    }
}
