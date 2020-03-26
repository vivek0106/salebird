package com.example.sale_bird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int Splash=3000;
   Animation topanim,bottomanim;
    ImageView bird;
    TextView sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bird = (ImageView) findViewById(R.id.imageView);
        sale = (TextView) findViewById(R.id.textView);
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        bird.setAnimation(topanim);
        sale.setAnimation(topanim);
        if(checkConnection()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent login = new Intent(MainActivity.this, login.class);
                    startActivity(login);
                }
            }, Splash);

        }
        else if(!checkConnection()){
            Toast.makeText(this,"Connection failed",Toast.LENGTH_LONG).show();
            Intent i=new Intent(MainActivity.this,Network.class);
            startActivity(i);

        }
    }
    private boolean checkConnection() {
        boolean have_WIFI = false;
        boolean have_DATA = false;
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = manager.getAllNetworkInfo();
        for(NetworkInfo info:networkInfos){
            if(info.getTypeName().equalsIgnoreCase("WIFI")){
                if(info.isConnected()) {
                    have_WIFI = true;
                }
            }
            if(info.getTypeName().equalsIgnoreCase("MOBILE")){
                if(info.isConnected()) {
                    have_DATA = true;
                }
            }
        }
        return have_DATA||have_WIFI;
    }

}
