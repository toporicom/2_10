package com.mirea.kt.a2_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etModel, etNumber, etAge;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etModel = findViewById(R.id.etModel);
        etNumber = findViewById(R.id.etNumber);
        etAge = findViewById(R.id.etAge);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSQLite = findViewById(R.id.btnSQLite);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "myDB.db", null, 1));
        btnAdd.setOnClickListener(this);
        btnSQLite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd){
            if (this.dbManager != null){
                String model = etModel.getText().toString();
                String number = etNumber.getText().toString();
                String age = etAge.getText().toString();
                if (!model.isEmpty() && !number.isEmpty() && !age.isEmpty()){
                    boolean res = dbManager.savePersonToDB(new Cars(model, number, Integer.parseInt(age)));
                    if (res){
                        Toast.makeText(this, "Успешно", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, "Ошибка значений", Toast.LENGTH_LONG).show();
                }
            }
        }
        if (v.getId() == R.id.btnSQLite){
            startActivity(new Intent(this, SQLiteAvtivity.class));
        }
    }
}