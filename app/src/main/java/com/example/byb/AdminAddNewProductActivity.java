package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AdminAddNewProductActivity extends AppCompatActivity {
  private String categoryname;
  private EditText newproductname , newproductdescription,newproductprice;
  private Button addnewproductbtn;
  private ImageView addnewproductimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);
        addnewproductimage=(ImageView) findViewById(R.id.addnewproductimage);
        newproductname=(EditText)findViewById(R.id.newproductname);
        newproductdescription=(EditText)findViewById(R.id.newproductdescription);
        newproductprice=(EditText)findViewById(R.id.newproductprice);
        addnewproductbtn=(Button) findViewById(R.id.addnewproductbtn);



    }
}