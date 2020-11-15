package com.example.ramp;

import android.content.Intent;
import android.os.Build;
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
        private Login activity;
        private Context context = ApplicationProvider.getApplicationContext();

        @Before
        public void setUp() throws Exception {
            FirebaseApp.initializeApp(context);
            activity = Robolectric.buildActivity(Login.class)
                    .create()
                    .resume()
                    .get();
        }
        @Test
        public void pleaseWork () throws Exception{
            TextView textView = (TextView) activity.findViewById(R.id.textView);
            String text = textView.getText().toString();
            assertEquals("access",text);
        }
}