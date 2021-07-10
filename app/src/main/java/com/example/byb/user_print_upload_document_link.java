package com.example.byb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.byb.Prevalent.Prevalent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class user_print_upload_document_link extends AppCompatActivity {
    private EditText description,link,numberofcopies;
    private Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_print_upload_document_link);
        description=(EditText) findViewById((R.id.new_user_document_description));
        link=(EditText) findViewById((R.id.new_user_document_link));
        numberofcopies=(EditText) findViewById((R.id.new_user_number_of_copies_document));
        update=(Button)findViewById(R.id.update_document_btn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateannouncement();
            }
        });


    }

    private void updateannouncement() {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("user_printout_document");
        HashMap<String,Object> userMap=new HashMap<>();
        userMap.put("description",description.getText().toString());
        userMap.put("googledrivelink",link.getText().toString());
        userMap.put("numberofcopies",numberofcopies.getText().toString());
        userMap.put("usn", Prevalent.currentonlineusers.getUsn());
        ref.child(Prevalent.currentonlineusers.getUsn()).updateChildren(userMap);

        Intent intent = new Intent(user_print_upload_document_link.this,home_activity.class);
        Toast.makeText(user_print_upload_document_link.this,"Google Drive link updated Successfully",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
