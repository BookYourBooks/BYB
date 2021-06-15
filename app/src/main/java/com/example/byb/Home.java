package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private CardView home_stationery,home_textbooks,home_lab_manual,home_forms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        home_stationery=findViewById(R.id.home_stationary);
        home_textbooks=findViewById(R.id.home_textbooks);
        home_lab_manual=findViewById(R.id.home_lab_manual);
        home_forms=findViewById(R.id.home_forms);



        home_stationery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, user_stationary_category.class);
                startActivity(intent);
            }
        });

        home_textbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, user_sem_category.class);
                startActivity(intent);
            }
        });
    }
}