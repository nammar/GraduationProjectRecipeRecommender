package com.resiepe.taleeb.logmain;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_up);
        animation.setDuration(900);

        ImageView firstphoto = (ImageView) findViewById(R.id.photo1);
        firstphoto.setAnimation(animation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();

            }
        }, 3000);
    }
}