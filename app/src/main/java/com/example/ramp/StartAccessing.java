package com.example.ramp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartAccessing extends AppCompatActivity {
    private DatabaseReference mDatabase;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button startAccess;
    private static final String TAG = "StartAccessing";
    TextView textView;
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

        textView = (TextView) findViewById(R.id.textViewSA);

        final String uid = user.getUid();
        System.out.println("uid: " + uid);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                //do whatever you want with user here!
                textView.setText("Hi " + userModel.getName() + "!");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void startAccess() {
        Intent intent = new Intent(StartAccessing.this, MainActivity.class);
        startActivity(intent);
    }
}