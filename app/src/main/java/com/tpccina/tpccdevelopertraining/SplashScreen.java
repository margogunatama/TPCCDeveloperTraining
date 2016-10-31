package com.tpccina.tpccdevelopertraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        ImageView splashImage = (ImageView) findViewById(R.id.splash_image);
        splashImage.animate().scaleY(0.5f).scaleX(0.5f).rotationX(180).rotationY(270).setDuration(2000).start();
        /*Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);*/

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashScreen.this, TrainingDetails.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
