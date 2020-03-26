package com.example.sale_bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exampl.sale_bird.Member;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText Name,Email,Password,Confirm,Phone,Address;
    Button Signup;
     FirebaseAuth auth;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Name=findViewById(R.id.name);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        Signup=findViewById(R.id.Signup);
        Confirm=findViewById(R.id.confirm);
        Phone=findViewById(R.id.phone);


      //  database=FirebaseDatabase.getInstance().getReference("Member");

        auth=FirebaseAuth.getInstance();

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  final String name = Name.getText().toString();
                 final String email = Email.getText().toString();
                final String password = Password.getText().toString();
                final String confirm=Confirm.getText().toString();
                final String phone=Phone.getText().toString();
                final  String add="-";
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(Registration.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Registration.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirm)) {
                    Toast.makeText(Registration.this, "Enter confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 5) {
                    Toast.makeText(Registration.this, " Password must be more than 5 word/no.", Toast.LENGTH_SHORT).show();

                }
                if (phone.length() !=10) {
                    Toast.makeText(Registration.this, " Mobile number must be 10 digits", Toast.LENGTH_SHORT).show();

                }
                if(password.equals(confirm)) {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Member member = new Member(name, email, password,phone,add);

                                        FirebaseDatabase.getInstance().getReference("Member")
                                               .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(member).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_LONG).show();
                                                Intent s = new Intent(Registration.this, login.class);
                                                startActivity(s);
                                            }
                                        });

                                    }
                                    else{
                                        Toast.makeText(Registration.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();

                                    }


                                }


                            });
                }
                else {
                    Toast.makeText(Registration.this, "Password and Confirm password should be same", Toast.LENGTH_LONG).show();


                }

            }});
    }}
