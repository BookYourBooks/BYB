package com.example.byb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.byb.Prevalent.Prevalent;
import com.example.byb.ViewHolder.CartViewHolder;
import com.example.byb.model.Cart;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class CartActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button NextProcessBtn;
    private TextView txtTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NextProcessBtn = (Button) findViewById(R.id.next_process_btn);
        txtTotalPrice = (TextView) findViewById(R.id.total_price);
    }


    @Override
    protected void onStart()
    {
        super.onStart();

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart_List");
        FirebaseRecyclerOptions<Cart> options =
                new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("User view")
                        .child(Prevalent.currentonlineusers.getUsn()).child("Products"),Cart.class).build();

        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter
        = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder, int i, @NonNull Cart model)
            {
                holder.txtProductQuantity.setText(" Quantity = " +model.getQuantity());
                holder.txtProductPrice.setText(" Price = " +model.getPrice()+"Rs");
                holder.txtProductName.setText(model.getPname());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CharSequence options[]=new CharSequence[]
                                {
                                        "Edit",
                                        "Remove"

                                };
                        AlertDialog.Builder builder=new AlertDialog.Builder(CartActivity.this);
                        builder.setTitle("Cart Options:");

                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                if (i==0)
                                {
                                    Intent intent = new Intent(CartActivity.this,user_product_detail_activity.class);
                                    intent.putExtra("pid",model.getPid());
                                    startActivity(intent);
                                }
                                if (i==1)
                                {
                                    cartListRef.child("User view")
                                            .child(Prevalent.currentonlineusers.getUsn()).child("Products").child(model.getPid()).removeValue()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                               if (task.isSuccessful()){
                                                   Toast.makeText(CartActivity.this,"Item removed successfully ",Toast.LENGTH_SHORT).show();
                                                   Intent intent = new Intent(CartActivity.this,Home.class);
                                                   startActivity(intent);
                                               }
                                                }
                                            });
                                }
                            }
                        });
                        builder.show();

                    }
                });
            }

            @NotNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent ,false);
                CartViewHolder holder= new CartViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}