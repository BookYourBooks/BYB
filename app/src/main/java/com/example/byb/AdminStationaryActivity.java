package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminStationaryActivity extends AppCompatActivity {
    private ImageView pen,notebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_stationary);
        pen=findViewById(R.id.pen);
        notebook=(ImageView)findViewById(R.id.notebook);

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStationaryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "pen");
                startActivity(intent);
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStationaryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "notebook");
                startActivity(intent);
            }
        });

    }


}