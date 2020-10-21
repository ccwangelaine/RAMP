package com.example.ramp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String inputName, String inputPassword){
//        if( (inputName.equals("12345")) && (inputPassword.equals("12345")) ){
//            Intent openPage2 = new Intent(LoginActivity.this, RegisterActivity.class);
//            startActivity(openPage2);
//        }

        /**
         * Do some checks like make sure all text fields are not empty, and then call retrieve api endpoint from UserRepository
         */
    }
}