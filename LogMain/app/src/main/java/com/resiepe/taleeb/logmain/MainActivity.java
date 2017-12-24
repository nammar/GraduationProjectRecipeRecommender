package com.resiepe.taleeb.logmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

Button regis,gust,user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       regis=(Button) findViewById(R.id.Register);
     regis.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent RegisterIntent=new Intent(MainActivity.this,Register.class);
             startActivity(RegisterIntent);
         }
     });

        gust=(Button) findViewById(R.id.guest);
        gust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GuestIntent=new Intent(MainActivity.this,PageGuest.class);
                startActivity(GuestIntent);
            }
        });

        user=(Button) findViewById(R.id.login);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent=new Intent(MainActivity.this,Login.class);
                startActivity(LoginIntent);
            }
        });
    }

}
