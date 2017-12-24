package com.resiepe.taleeb.logmain;/*Created By Faisal 4/9/2016
* This Activity is for Splash Screen on we start the application with animation then it go to Login Activity After 4 seconds*/

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.resiepe.taleeb.logmain.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_up);
        animation.setDuration(900);

        String versionName = BuildConfig.VERSION_NAME;

        ImageView cocaLogo = (ImageView) findViewById(R.id.cocaLogo);
        cocaLogo.setAnimation(animation);

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
