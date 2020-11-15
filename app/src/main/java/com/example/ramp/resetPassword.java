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


public class resetPassword extends AppCompatActivity {

    EditText rEmail;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        rEmail = findViewById(R.id.Lemail);
        resetBtn = findViewById(R.id.SignupBtn);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = rEmail.getText().toString().trim();

                if(TextUtils.isEmpty(emailAddress)){
                    rEmail.setError("Email is required");
                    return;
                }
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(resetPassword.this, "Password reset email sent. This may take a few minutes.", Toast.LENGTH_SHORT).show();
                                    Intent openPage2 = new Intent(resetPassword.this, Login.class);
                                    startActivity(openPage2);
                                }
                                else{
                                    Toast.makeText(resetPassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}