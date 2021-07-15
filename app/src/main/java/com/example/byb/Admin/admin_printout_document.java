package com.example.byb.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.byb.R;
import com.example.byb.ViewHolder.CartViewHolder;
import com.example.byb.ViewHolder.Documentviewholder;
import com.example.byb.model.Cart;
import com.example.byb.model.printout_document;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class admin_printout_document extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button update;
    private TextView txtTotalPrice,confirmordermsg;

    private int overAllTotalPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_printout_document);


        recyclerView = findViewById(R.id.document_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    protected void onStart()
    {
        super.onStart();


        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("user_printout_document");
        FirebaseRecyclerOptions<printout_document> options =
                new FirebaseRecyclerOptions.Builder<printout_document>()
                        .setQuery(cartListRef, printout_document.class)
                        .build();

        FirebaseRecyclerAdapter<printout_document, Documentviewholder> adapter
                = new FirebaseRecyclerAdapter<printout_document, Documentviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Documentviewholder holder, int i, @NonNull printout_document model)
            {
                holder.usn.setText(model.getUsn());
                holder.copies.setText(" Copies = " +model.getNumberofcopies());
                holder.link.setText(" Link = " +model.getGoogledrivelink());
                holder.description.setText( model.getDescription());



            }

            @NotNull
            @Override
            public Documentviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_document_item_list, parent ,false);
                Documentviewholder  holder= new Documentviewholder (view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

}