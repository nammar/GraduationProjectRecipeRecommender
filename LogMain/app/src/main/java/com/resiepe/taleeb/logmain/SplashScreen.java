package com.resiepe.taleeb.logmain;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_up);
        animation.setDuration(9000);

        ImageView firstphoto = (ImageView) findViewById(R.id.photo1);
        firstphoto.setAnimation(animation);

        final ProgressBar progressBar=(ProgressBar) findViewById(R.id.progressBar);
        SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progressBar.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();

            }
        }, 30000);
    }
}