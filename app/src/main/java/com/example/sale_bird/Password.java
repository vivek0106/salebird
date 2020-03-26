package com.example.sale_bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Password extends AppCompatActivity {
private EditText passwordemail;
private Button reset;
private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        passwordemail=findViewById(R.id.setPasswordemail);
        reset=findViewById(R.id.reset);
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Password.this,login.class));
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail=passwordemail.getText().toString();
                if(useremail.equals("")){
                    Toast.makeText(Password.this,"Please enter your registered email",Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful()){
                               Toast.makeText(Password.this,"Password reset email sent",Toast.LENGTH_SHORT).show();
                               finish();
                               startActivity(new Intent(Password.this,login.class));
                           }
                           else{
                               Toast.makeText(Password.this,"Email not registered",Toast.LENGTH_SHORT).show();
                           }

                        }
                    });
                }

            }
        });
    }
}
