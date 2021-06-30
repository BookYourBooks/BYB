package com.example.byb;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddActivity extends AppCompatActivity {
    public Button button;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);

        button = (Button) findViewById(R.id.addbtn);
        login = (Button) findViewById(R.id.loginbtnaddact);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAddActivity.this, AdminCategoryActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
