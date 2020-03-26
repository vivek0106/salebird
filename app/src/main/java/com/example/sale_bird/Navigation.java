package com.example.sale_bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.AnimationDrawable;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.exampl.sale_bird.Member;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    ImageButton home,fashion,fresh,phone,todaysdeal,mobiledeal,freshdeal,homeappliances,fashion1;
    TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        View headerview=navigationView.getHeaderView(0);
        name=headerview.findViewById(R.id.name);
        email=headerview.findViewById(R.id.email);
        phone=(ImageButton) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,phone.class));
            }
        });
        home=(ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Navigation.this,"Hello",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Navigation.this,Appliance.class));
            }
        });
        fashion=(ImageButton) findViewById(R.id.fashion);
        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Navigation.this,"Out of Stock!!",Toast.LENGTH_SHORT).show();
            }
        });
        fresh=(ImageButton) findViewById(R.id.fresh1);
        fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Fresh.class));
            }
        });
        todaysdeal=findViewById(R.id.TodaysDeal);
        todaysdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Washing.class));
            }
        });
        mobiledeal=findViewById(R.id.mobiledeals);
        mobiledeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Redmi.class));
            }
        });
        freshdeal=findViewById(R.id.fresh);
        freshdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Rasna.class));
            }
        });
        homeappliances=findViewById(R.id.homeappliances);
        homeappliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Fridge.class));
            }
        });
        fashion1=findViewById(R.id.clothes);
        fashion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Navigation.this,"Out of Stock!!",Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ImageView slideshow=findViewById(R.id.iv_background);
        slideshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,oneplus.class));
            }
        });
        AnimationDrawable animationDrawable=(AnimationDrawable)slideshow.getDrawable();
        animationDrawable.start();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Member").child(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot) {
                Member member=dataSnapshot.getValue(Member.class);

                    name.setText(member.getName());
                    email.setText(member.getEmail());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Navigation.this,databaseError.getCode()+"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:{
               // Toast.makeText(Navigation.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Navigation.this,Navigation.class));
                break;
            }
            case R.id.nav_logout:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Navigation.this,login.class));
            }
            case R.id.nav_profile:{
                startActivity(new Intent(Navigation.this,Profile.class));
                break;
            }
            case R.id.nav_contact:{
                startActivity(new Intent(Navigation.this,Contact_us.class));
            }
        }
        return true;
    }

}
