package com.resiepe.taleeb.logmain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText pname=(EditText) findViewById(R.id.pname);
        final EditText uname=(EditText) findViewById(R.id.uname);
        final EditText ppassword=(EditText) findViewById(R.id.upassword);
        final EditText rpassword=(EditText) findViewById(R.id.rpassword);
        final EditText email=(EditText) findViewById(R.id.uemail);
        final EditText phone=(EditText) findViewById(R.id.uphone);

         signup = (Button) findViewById(R.id.usignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personalname=pname.getText().toString();
                String username=uname.getText().toString();
                String password=ppassword.getText().toString();
                String passwordagain=rpassword.getText().toString();
                String emailaddress=email.getText().toString();
                String phonenumber=phone.getText().toString();

                 //make if all feilds done then move to useractivty
                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent UserActivityIntent=new Intent(Register.this,UserActivity.class);
                        startActivity(UserActivityIntent);
                    }
                });





            }
        });

    }

}
