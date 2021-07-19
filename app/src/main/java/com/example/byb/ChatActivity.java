package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {
    String ReceiverImage, ReceiverUID, ReceiverName;
    CircleImageView profileImage;
    TextView receiverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ReceiverName = getIntent().getStringExtra("Name");
        ReceiverImage = getIntent().getStringExtra("Receiver Image");
        ReceiverUID = getIntent().getStringExtra("UID");

        receiverName = findViewById(R.id.receiver_name);
        profileImage = findViewById(R.id.profile_image_chat);

        Picasso.get().load(ReceiverImage).into(profileImage);
        receiverName.setText("" + ReceiverName);



}
}