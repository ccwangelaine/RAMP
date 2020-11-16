package com.example.ramp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4ClassRunner.class)
public class RegisterActivityTest {
    @Rule
    public ActivityScenarioRule<RegisterActivity> registerActivityActivityTestRule =
            new ActivityScenarioRule<>(RegisterActivity.class);

    @Test
    public void test_visibility() {
        onView(withId(R.id.RegisterPage)).check(matches(isDisplayed()));
    }
}