package com.example.sale_bird;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Fresh extends AppCompatActivity implements freshes.onClickListener {
    List<Integer> imageList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    List<String> price=new ArrayList<>();
    List<String> off=new ArrayList<>();

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh);
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fresh.this,Navigation.class));
            }
        });
        recyclerView=findViewById(R.id.recyler);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        imageList.add(R.mipmap.amul_butter);
        imageList.add(R.mipmap.biscuit);
        imageList.add(R.mipmap.cadbury);
        imageList.add(R.mipmap.milk);
        imageList.add(R.mipmap.lays);
        imageList.add(R.mipmap.rasna);

        titleList.add("Amul Butter (The Taste of India)");
        titleList.add("Parle-G(G for Genius)");
        titleList.add("Silk(Dairy Milk)");
        titleList.add("Milk(Cow milk)");
        titleList.add("Lays(Classic)");
        titleList.add("Rasna(Orange flavor)");

        price.add("₹ 250/-");
        price.add("₹ 10/-");
        price.add("₹ 80/-");
        price.add("₹ 52/-");
        price.add("₹ 15/-");
        price.add("₹ 185/-");

        off.add("₹ 40 off");
        off.add("₹ 2 off");
        off.add("₹ 20 off");
        off.add("₹ 5 off");
        off.add("₹ 3 off");
        off.add("₹ 30 off");

        recyclerView.setAdapter(new freshes(imageList,titleList,price,off,this));
    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0 :{
               startActivity(new Intent(Fresh.this,Butter.class));
                break;
            }
            case 1:{
               startActivity(new Intent(Fresh.this,Biscuit.class));
                break;
            }
            case 2:{
              startActivity(new Intent(Fresh.this,Cadbury.class));
                break;
            }
            case 3:{

                startActivity(new Intent(Fresh.this,Rasna.class));
                break;
            }
            case 4:{
                startActivity(new Intent(Fresh.this,Biscuit.class));
                break;
            }
            case 5:{
              startActivity(new Intent(Fresh.this,Rasna.class));
                break;
            }
        }
    }
}
