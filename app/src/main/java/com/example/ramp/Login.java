package com.example.ramp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button login, register, forgot;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.Lemail);
        password = findViewById(R.id.Lpassword);
        login = findViewById(R.id.LoginBtn);
        register = findViewById(R.id.RegisterBtn);
        forgot = findViewById(R.id.forgotPass);
        fAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterPage();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPass();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString().trim();
                String passwordtxt = password.getText().toString().trim();

                if(TextUtils.isEmpty(emailtxt)) {
                    email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(passwordtxt)){
                    password.setError("Password is required");
                    return;
                }

                fAuth.signInWithEmailAndPassword(emailtxt, passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            boolean emailVerified = user.isEmailVerified();
                            Log.d("Login.this", user.getEmail());
                            Log.d("Login.this", Boolean.toString(emailVerified));
                            if (emailVerified == true) {
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent openPage2 = new Intent(Login.this, MainActivity.class);
                                startActivity(openPage2);
                            }
                            else{
                                Toast.makeText(Login.this, "Email not verified", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    public void openRegisterPage() {
        Intent intent = new Intent(Login.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void resetPass(){
        Intent intent = new Intent(Login.this, resetPassword.class);
        startActivity(intent);
    }
}