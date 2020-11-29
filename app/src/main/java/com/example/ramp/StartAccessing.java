package com.example.ramp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class StartAccessing extends AppCompatActivity {
    private DatabaseReference mDatabase;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button startAccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_accessing);

        startAccess = findViewById(R.id.StartAccessBtn);
        startAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAccess();
            }
        });

        TextView textView = (TextView) findViewById(R.id.textViewSA);
        textView.setText("Hi" + user.getDisplayName());
    }

    public void startAccess() {
        Intent intent = new Intent(StartAccessing.this, RegisterActivity.class);
        startActivity(intent);
    }
}