package com.example.ramp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilePage1Activity extends AppCompatActivity {
    EditText preferredName, gender, age;
    Button modalityButton, nextButton;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> userItems = new ArrayList<>();
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page1);

        modalityButton = (Button) findViewById(R.id.modalityBtn);
        preferredName = findViewById(R.id.preferName);
        gender = findViewById(R.id.etgender);
        age = findViewById(R.id.etage);
        nextButton = findViewById(R.id.NextBtn1);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();


        listItems = getResources().getStringArray(R.array.modality);
        checkedItems = new boolean[listItems.length];

        modalityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfilePage1Activity.this);
                builder.setTitle(R.string.searchModalityTitle);
                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!userItems.contains(position)) {
                                userItems.add(position);
                            } else {
                                userItems.remove(position);
                            }
                        }
                    }
                });

                builder.setCancelable(false);
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });

                builder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setNeutralButton(R.string.clear_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            userItems.clear();
                        }
                    }
                });

                AlertDialog searchModality = builder.create();
                searchModality.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = new UserModel(preferredName.getText().toString().trim(), gender.getText().toString().trim(), age.getText().toString().trim(), "idk");
                mDatabase.child("users").child(uid).setValue(user);
                Toast.makeText(ProfilePage1Activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent openPage = new Intent(ProfilePage1Activity.this, ProfilePage7Activity.class);
                startActivity(openPage);
            }
        });
    }
}