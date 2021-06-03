package com.example.byb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Prevalent.Prevalent;
import io.paperdb.Paper;
import model.users;


public class MainActivity extends AppCompatActivity {
    TextView register,forgotpassword,admin,notanadmin;
    Button loginbtn;
    EditText loginusn,userpassword;
    private DatabaseReference RootRef;
    private ProgressDialog loadingBar;
    private CheckBox rememberme;
    private  String ParentDbName="users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginusn =findViewById(R.id.loginusn);
        userpassword=findViewById(R.id.userpassword);
        loadingBar = new ProgressDialog(this);
        register=(TextView)findViewById(R.id.userregister);
        forgotpassword=(TextView)findViewById(R.id.forgotpassword);
        loginbtn=findViewById((R.id.loginbtn));



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterUser.class));
                finish();
            }
        });

    }public void loginuser(){
         String usn= loginusn.getText().toString().trim();
         String password = userpassword.getText().toString().trim();
        if (TextUtils.isEmpty(usn)) {
            loginusn.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            userpassword.setError("Password is required");
            return;
        }
        if (password.length() < 8) {
            userpassword.setError("Min password length should be 8 characters");
            return;
        }
        else {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            Allowaccesstoaccount( usn, password);
        }
    }
    private void Allowaccesstoaccount( String usn, String password){

        RootRef=FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(ParentDbName).child(usn).child("password").exists()){
                    users usersdata=dataSnapshot.child(ParentDbName).child(usn).getValue(users.class);
                    if(usersdata.getUsn().equals(usn)) {
                        if (usersdata.getPassword().equals(password)) {
                            if (ParentDbName.equals("users")) {


                                Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    }


                }
                else{
                    Toast.makeText(MainActivity.this, "This " + usn + " usn do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(MainActivity.this, "Please try again using another usn.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });


    }




}

