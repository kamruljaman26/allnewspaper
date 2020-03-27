package com.example.bdallnewspaper.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bdallnewspaper.R;

public class SplashScreen extends AppCompatActivity {


    public Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

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
            thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void startApp (){
        try {
            thread.sleep(3000);
            Intent intent = new Intent (SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
