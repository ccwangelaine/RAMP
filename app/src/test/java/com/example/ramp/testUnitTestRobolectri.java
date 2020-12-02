package com.example.ramp;

import android.content.Intent;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.google.firebase.FirebaseApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

import static org.robolectric.Robolectric.setupActivity;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(maxSdk = 28)
public class testUnitTestRobolectri {
        private RegisterActivity register;
        private ProfilePage1Activity activity;
        private ProfilePage7Activity activity2;
        private Context context = ApplicationProvider.getApplicationContext();

        @Before
        public void setUp() throws Exception {
            FirebaseApp.initializeApp(context);
            register = new RegisterActivity();
            register.onCreate(null);
            activity = new ProfilePage1Activity();
            activity.onCreate(null);

        }
        @Test
        public void pleaseWork () throws Exception{
            EditText email = (EditText)register.findViewById(R.id.Lemail);
            email.setText("testeremail@email.com");
            EditText password = (EditText)register.findViewById(R.id.Lpassword);
            password.setText("password");
            EditText cpassword = (EditText)register.findViewById(R.id.confirmPassword);
            cpassword.setText("password");
            register.findViewById(R.id.RegisterBtn).performClick();

            assertEquals(password.getText(),cpassword.getText());


        }
}