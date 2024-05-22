package com.mirea.kt.a2_10;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SQLiteAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        SQLiteOpenHelper sqLiteOpenHelper = new MyAppSQLiteHelper(this, "myDB.db", null, 1);
        DBManager dbManager = new DBManager(sqLiteOpenHelper);
        RVAdapter adapter = new RVAdapter(dbManager.loadAllFromDB());
        recyclerView.setAdapter(adapter);
    }
}