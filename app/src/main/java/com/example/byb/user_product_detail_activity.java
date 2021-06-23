package com.example.byb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.byb.model.Stationary_product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.Button;
import com.rey.material.widget.FloatingActionButton;
import com.rey.material.widget.ImageView;
import com.rey.material.widget.SnackBar;
import com.rey.material.widget.TextView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import okhttp3.internal.cache.DiskLruCache;

public class user_product_detail_activity extends AppCompatActivity {

    private FloatingActionButton addToCardBtn;
    private ImageView productImage;
   // private ElegantNumberButton numberButton;
    private TextView productPrice, productDescription, productName;
    private String productID = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_product_detail);

        productID = getIntent().getStringExtra("pid");

       // addToCardBtn = (FloatingActionButton) findViewById(R.id.add_to_cart);
       // numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
         productImage = (ImageView) findViewById(R.id.product_image_details);
        productPrice = (TextView) findViewById(R.id.product_price_details);
        productDescription = (TextView) findViewById(R.id.product_description_details);
        productName = (TextView) findViewById(R.id.product_name_details);

        getProductDetails(productID);


    }

    private void getProductDetails(String productID) {
        DatabaseReference productref = FirebaseDatabase.getInstance().getReference().child("Products");

        productref.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                if (DataSnapshot.exists())
                {
                    Stationary_product products = DataSnapshot.getValue(Stationary_product.class);

                    productName.setText(products.getPname());
                    productPrice.setText(products.getPrice());
                    productDescription.setText(products.getDescription());
                    Picasso.get().load(Stationary_product.getImage()).into(productImage);


                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


    }
}