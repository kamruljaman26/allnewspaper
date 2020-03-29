package com.example.bdallnewspaper.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.admob.AdService;

public class SplashScreenActivity extends AppCompatActivity {


    public Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Ads Services
        AdService.adService = new AdService(SplashScreenActivity.this);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                startApp();
            }
        });

        thread.start();

    }

    public void doWork(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void startApp (){
        try {
            Thread.sleep(3000);
            Intent intent = new Intent (SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
