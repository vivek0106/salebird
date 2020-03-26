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

public class Appliance extends AppCompatActivity implements appliances.onClickListener {
    List<Integer> imageList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    List<String> price=new ArrayList<>();
    List<String> off=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);
        recyclerView=findViewById(R.id.recyler);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Appliance.this,Navigation.class));
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        imageList.add(R.mipmap.tv);
        imageList.add(R.mipmap.fridge);
        imageList.add(R.mipmap.washing_machine);
        imageList.add(R.mipmap.fan);
        imageList.add(R.mipmap.speaker);

        titleList.add("Mi LED Smart TV 4A PRO 80cm(32) with Android");
        titleList.add("Samsung 192 L direct Cool Refigerator");
        titleList.add("Whirpool 7 kg Automatic Top Load");
        titleList.add("Crompton Sae Wind 1200mm Ceiling fan");
        titleList.add("boAt Stone Grenade 5 W Bluetooth Speaker");

        price.add("₹ 30000/-");
        price.add("₹ 50000/-");
        price.add("₹ 25000/-");
        price.add("₹ 15000/-");
        price.add("₹ 10000/-");

        off.add("Save ₹ 1000.00");
        off.add("Save ₹ 2000.00");
        off.add("Save ₹ 1500.00");
        off.add("Save ₹ 500.00");
        off.add("Save ₹ 500.00");

        recyclerView.setAdapter(new appliances(imageList,titleList,price,off,this));
    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0 :{
               startActivity(new Intent(Appliance.this,TV.class));
                break;
            }
            case 1:{

                startActivity(new Intent(Appliance.this,Washing.class));
                break;
            }
            case 2:{

                startActivity(new Intent(Appliance.this,Fridge.class));
                break;
            }
            case 3:{
                startActivity(new Intent(Appliance.this,Fan.class));
                break;
            }
            case 4:{
                startActivity(new Intent(Appliance.this,Speaker.class));
                break;
            }

        }
    }
}
