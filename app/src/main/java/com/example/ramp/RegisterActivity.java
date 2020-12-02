package com.example.ramp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password, Cpassword;
    Button register;
    FirebaseAuth fAuth;
    ImageView goback;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.Lemail);
        password = findViewById(R.id.Lpassword);
        Cpassword = findViewById(R.id.confirmPassword);
        register = findViewById(R.id.SignupBtn);
        fAuth = FirebaseAuth.getInstance();
        goback = findViewById(R.id.backToSignin);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToSignInPage();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString().trim();
                String passwordtxt = password.getText().toString().trim();
                String Cpasswordtxt = Cpassword.getText().toString().trim();

                goback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goBackToSignInPage();
                    }
                });

                if(TextUtils.isEmpty(emailtxt)) {
                    email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(passwordtxt)){
                    password.setError("Password is required");
                    return;
                }

                if(TextUtils.isEmpty(Cpasswordtxt)){
                    Cpassword.setError("Password is required");
                    return;
                }

                if(passwordtxt.equals(Cpasswordtxt) == false){
                    Cpassword.setError("Passwords must match");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(emailtxt, passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            final String uid = user.getUid();

                            UserModel userModel = new UserModel();
                            mDatabase.child("users").child(uid).setValue(userModel);

                            user.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(RegisterActivity.this, "An email has been sent to your email address to verify your account. Please verify then sign in.", Toast.LENGTH_LONG).show();

                                                Intent openPage = new Intent(RegisterActivity.this, Login.class);
                                                startActivity(openPage);
                                            }
                                            else{
                                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
    public void goBackToSignInPage() {
        Intent intent = new Intent(RegisterActivity.this, Login.class);
        startActivity(intent);
    }
}