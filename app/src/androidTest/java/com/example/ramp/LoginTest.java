package com.example.ramp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;

import static org.junit.Assert.*;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.core.app.ActivityScenario;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginTest {
    @Test
    public void test_isActivityInView() {
        //check if the page, title, and button is displayed.
        ActivityScenario activityScenario = ActivityScenario.launch(Login.class);
        onView(withId(R.id.LoginPage))
                .check(matches(isDisplayed())); //method 1 to see if sth. is displayed
        onView(withId(R.id.LoginBtn))
                .check(matches(withEffectiveVisibility(Visibility.VISIBLE))); //method 2
        onView(withId(R.id.textView))
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_isTitleTextDisplayedCorrectly() {
        ActivityScenario activityScenario = ActivityScenario.launch(Login.class);
        onView(withId(R.id.textView))
                .check(matches(withText("access")));
    }

    @Test
    public void test_navRegisterPage() {
        ActivityScenario activityScenario = ActivityScenario.launch(Login.class);
        onView(withId(R.id.RegisterBtn))
                .perform(click());
        onView(withId(R.id.RegisterPage))
                .check(matches(isDisplayed()));
    }

    @Test
    public void test_navBack_toSigninPage() {
        ActivityScenario activityScenario = ActivityScenario.launch(Login.class);
        onView(withId(R.id.RegisterBtn))
                .perform(click());
        onView(withId(R.id.RegisterPage))
                .check(matches(isDisplayed()));
        onView(withId(R.id.backToSignin))
                .perform(click()); //method 1
        //pressBack(); //method 2
        onView(withId(R.id.LoginPage))
                .check(matches(isDisplayed()));
    }
}