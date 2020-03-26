package com.example.sale_bird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Network extends AppCompatActivity {
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        refresh=findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkConnection()){
                    Intent login = new Intent(Network.this, MainActivity.class);
                    startActivity(login);

                }
                else if(!checkConnection()){
                    Toast.makeText(Network.this,"Connection failed",Toast.LENGTH_SHORT);
                    Intent i=new Intent(Network.this,Network.class);
                    startActivity(i);

                }
            }
        });
    }

    private boolean checkConnection() {
        boolean have_WIFI = false;
        boolean have_DATA = false;
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = manager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected()) {
                    have_WIFI = true;
                }
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (info.isConnected()) {
                    have_DATA = true;
                }
            }
        }
        return have_DATA || have_WIFI;
    }
}
