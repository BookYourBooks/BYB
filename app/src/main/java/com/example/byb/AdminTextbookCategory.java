package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminTextbookCategory extends AppCompatActivity {
    private CardView ccycle, pcycle, sem3, sem4,sem5, sem6, sem7, sem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_textbook_category);
        ccycle=findViewById(R.id.c_cycle);
        pcycle=findViewById(R.id.p_cycle);
        sem3=findViewById(R.id.sem_3);
        sem4=findViewById(R.id.sem_4);
        sem5=findViewById(R.id.sem_5);
        sem6=findViewById(R.id.sem_6);
        sem7=findViewById(R.id.sem_7);
        sem8=findViewById(R.id.sem_8);

        ccycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "CCycle");
                startActivity(intent);
            }
        });

        pcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "PCycle");
                startActivity(intent);
            }
        });

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "3Sem");
                startActivity(intent);
            }
        });

        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "4Sem");
                startActivity(intent);
            }
        });

        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "5Sem");
                startActivity(intent);
            }
        });

        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "6Sem");
                startActivity(intent);
            }
        });

        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "7Sem");
                startActivity(intent);
            }
        });

        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTextbookCategory.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "8Sem");
                startActivity(intent);
            }
        });

    }
}