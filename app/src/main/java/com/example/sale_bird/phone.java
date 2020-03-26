package com.example.sale_bird;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class phone extends AppCompatActivity implements Phones.onClickListener {
    List<Integer> imageList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    List<String> price=new ArrayList<>();
    List<String> emi=new ArrayList<>();
    List<String> off=new ArrayList<>();

    RecyclerView recyclerView;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        recyclerView=findViewById(R.id.recyler);
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(phone.this,Navigation.class));
            }
        });
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        imageList.add(R.mipmap.oneplus_6t);
        imageList.add(R.mipmap.realme_3i);
        imageList.add(R.mipmap.samsung_m20);
        imageList.add(R.mipmap.redmi_8_pro);

        titleList.add("OnePlus 6t (Mirror Grey,128GB)");
        titleList.add("Realme 3i (Diamond Red,64GB)");
        titleList.add("Samsung M20 (Ocean Blue,128GB)");
        titleList.add("Redmi Note 8 Pro (Gamma Green,64GB)");

        price.add("₹ 20000/- ₹ 30000/-");
        price.add("₹ 20000/- ₹ 15000/-");
        price.add("₹ 20000/- ₹ 25000/-");
        price.add("₹ 20000/- ₹ 14000/-");

        emi.add("No Cost EMI");
        emi.add("No Cost EMI");
        emi.add("No Cost EMI");
        emi.add("No Cost EMI");


        off.add("₹ 10000 off");
        off.add("₹ 500 off");
        off.add("₹ 5000 off");
        off.add("₹ 1000 off");

        recyclerView.setAdapter(new Phones(imageList,titleList,price,emi,off,this));

    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0 :{
                startActivity(new Intent(phone.this,oneplus.class));
                break;
            }
            case 1:{
                startActivity(new Intent(phone.this,Realme.class));
                break;
            }
            case 2:{
                startActivity(new Intent(phone.this,samsung.class));
                break;
            }
            case 3:{
                startActivity(new Intent(phone.this,Redmi.class));
                break;
            }

        }
    }
}
