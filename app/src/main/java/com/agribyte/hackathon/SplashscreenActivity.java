package com.agribyte.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashscreenActivity extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
public static final int SPLASH_TIMEOUT= 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                if(user!=null)
//                {
//                    Intent i = new Intent(SplashscreenActivity.this,BottombarActivity.class);
//                    startActivity(i);
//                }
//                else
//                {
                Intent i2 = new Intent(SplashscreenActivity.this, LoginActivity.class);
                startActivity(i2);
                finish();

            }
        },SPLASH_TIMEOUT);
    }
}