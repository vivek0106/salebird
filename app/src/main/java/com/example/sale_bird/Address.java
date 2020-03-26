
package com.example.sale_bird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Address extends AppCompatActivity {
FirebaseDatabase firebaseDatabase;
FirebaseAuth firebaseAuth;
DatabaseReference databaseReference;
Button submit;
EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        submit=findViewById(R.id.submit);
        address=findViewById(R.id.address);
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Address.this,Navigation.class));
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference=firebaseDatabase.getInstance().getReference("Member").child(firebaseAuth.getUid());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add=address.getText().toString();
                databaseReference.child("address").setValue(add);
                startActivity(new Intent(Address.this,Order.class));
            }
        });


    }
}
