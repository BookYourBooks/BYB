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
import android.widget.CompoundButton;
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
    TextView register,forgotpassword,admin,notanadmin,usersignin;
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
        usersignin=findViewById(R.id.usersignin);
        loginusn =findViewById(R.id.loginusn);
        userpassword=findViewById(R.id.userpassword);
        loadingBar = new ProgressDialog(this);
        register=(TextView)findViewById(R.id.userregister);
        forgotpassword=(TextView)findViewById(R.id.forgotpassword);
        loginbtn=findViewById((R.id.loginbtn));
        admin=(TextView)findViewById(R.id.admin);
        notanadmin=(TextView)findViewById(R.id.notanadmin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterUser.class));
                finish();
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                loginbtn.setText("Login Admin");
                usersignin.setText("Admin Sign in");
                admin.setVisibility(View.INVISIBLE);
                notanadmin.setVisibility(View.VISIBLE);
                ParentDbName="admins";
            }
        });

        notanadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                loginbtn.setText("Login");
                usersignin.setText("User Sign in");
                admin.setVisibility(View.VISIBLE);
                notanadmin.setVisibility(View.INVISIBLE);
                ParentDbName = "users";
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });

    }public void loginuser(){
         String usn= loginusn.getText().toString().trim();
         String password = userpassword.getText().toString().trim();
        if (TextUtils.isEmpty(usn)) {
            loginusn.setError("USN is required");
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
                if (dataSnapshot.child(ParentDbName).child(usn).exists())
                {
                    users usersData = dataSnapshot.child(ParentDbName).child(usn).getValue(users.class);

                    if (usersData.getUsn().equals(usn))
                    {
                        if (usersData.getPassword().equals(password))
                        {
                            if (ParentDbName.equals("admins"))
                            {
                                Toast.makeText(MainActivity.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(MainActivity.this, AdminCategoryActivity.class);
                                startActivity(intent);
                            }
                            else if (ParentDbName.equals("users"))
                            {
                                Toast.makeText(MainActivity.this, "logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Prevalent.currentonlineusers = usersData;
                                Intent intent = new Intent(MainActivity.this, Home.class);
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(MainActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Account with this " + usn + " number do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });


    }




}

