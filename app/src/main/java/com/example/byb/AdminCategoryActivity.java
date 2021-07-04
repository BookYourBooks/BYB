package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AdminCategoryActivity extends AppCompatActivity {
    private LinearLayout stationary,textbooks,labmanual,forms;
    private Button maintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("AdminCategoryActivity","Successes");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        stationary=findViewById(R.id.admin_stationary);
        textbooks=findViewById(R.id.admin_textbooks);
        labmanual=findViewById(R.id.admin_labmanual);
        forms=findViewById(R.id.admin_forms);

        maintainProductsBtn = (Button) findViewById(R.id.maintain_btn);

        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, user_notebooks.class);
                intent.putExtra("Admin" , "Admin");
                startActivity(intent);
            }
        });


        stationary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminStationaryActivity.class);
                startActivity(intent);
            }
        });
        textbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminTextbookCategory.class);
                startActivity(intent);
            }
        });
    }
}