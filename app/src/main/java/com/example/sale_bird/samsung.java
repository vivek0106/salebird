package com.example.sale_bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class samsung extends AppCompatActivity {
    ImageView buy;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung);
        ImageView phone_samsung=findViewById(R.id.samsung);
        AnimationDrawable animationDrawable=(AnimationDrawable)phone_samsung.getDrawable();
        animationDrawable.start();
        buy=findViewById(R.id.buy);

        buy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(oneplus.this, "You clicked me", Toast.LENGTH_SHORT).show();
                firebaseAuth= FirebaseAuth.getInstance();

                databaseReference=firebaseDatabase.getInstance().getReference("Member").child(firebaseAuth.getUid());

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Map<String,Object> map = (Map<String,Object>) dataSnapshot.getValue();
                        String Add =(String) map.get("address");
                        if(Add.equals("-")){
                            startActivity(new Intent(samsung.this,Address.class));
                        }
                        else {
                            startActivity(new Intent(samsung.this,Order.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(samsung.this, "Error"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
