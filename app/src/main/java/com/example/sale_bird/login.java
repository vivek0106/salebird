package com.example.sale_bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText Email,Password;
    Button login;
    TextView signup,forgotpassword;
    private FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        login=findViewById(R.id.Login);
        signup=findViewById(R.id.signup);
        forgotpassword=findViewById(R.id.forgot);
        firebaseauth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseauth.getCurrentUser();
       if(user!=null) {
           finish();
           startActivity(new Intent(login.this, Navigation.class));
       }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=Email.getText().toString();
                String password=Password.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(login.this,"Enter Email" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(login.this,"Enter Password" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<5){
                    Toast.makeText(login.this," Password must be more than 5 word/no." ,Toast.LENGTH_SHORT).show();

                }
                firebaseauth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public  void onComplete( @NonNull Task<AuthResult> resultTask) {
                                if (resultTask.isSuccessful()) {

                                    Intent i = new Intent(login.this,Navigation.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(login.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(login.this,Registration.class);
                startActivity(s);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s=new Intent(login.this,Password.class);
                startActivity(s);
            }
        });
    }
}

