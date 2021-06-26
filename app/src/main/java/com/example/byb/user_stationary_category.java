package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class user_stationary_category extends AppCompatActivity {
    private CardView notebooks,accessories,sheets,files,bluebooks,record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_stationary_category);
        notebooks=findViewById(R.id.user_stationery_notebooks);
        accessories=findViewById(R.id.user_stationery_accesories);
        sheets=findViewById(R.id.user_stationery_a4sheets);
        files=findViewById(R.id.user_stationery_files);
        bluebooks=findViewById(R.id.user_stationery_bluebooks);
        record=findViewById(R.id.user_stationery_record);


        notebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(user_stationary_category.this, user_notebooks.class);
                startActivity(intent1);
            }
        });

        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_stationary_category.this, user_accesssories.class);
                startActivity(intent);
            }
        });

        sheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_stationary_category.this, user_sheets.class);
                startActivity(intent);
            }
        });

        files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_stationary_category.this, user_files.class);
                startActivity(intent);
            }
        });

        bluebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_stationary_category.this,user_bluebooks.class);
                startActivity(intent);
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_stationary_category.this, user_record.class);
                startActivity(intent);
            }
        });

    }
}