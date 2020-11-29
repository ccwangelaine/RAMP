package com.example.ramp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;


import org.junit.Before;

import androidx.annotation.CheckResult;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.core.app.ActivityScenario;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginTest {
    private String emailToBeTyped;
    private String passwordToBeTyped;
    private String preferredNameToBeTyped;
    private String gender;
    private String age;

    @Rule
    ActivityScenario activityScenario = ActivityScenario.launch(Login.class);

    @Before
    public void initValidString() {
        //Specify the password and email you want to sign up with
        emailToBeTyped = "kittyguz@berkeley.edu";
        passwordToBeTyped = "www.12345";
        preferredNameToBeTyped = "Kitty";
        gender = "Female";
        age = "25";
    }

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

        //On Register Page
        onView(withId(R.id.Lemail))
                .perform(typeText(emailToBeTyped));
        onView(withId(R.id.Lpassword))
                .perform(typeText(passwordToBeTyped));
        onView(withId(R.id.confirmPassword))
                .perform(typeText(passwordToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.SignupBtn))
                .perform(click());

        //On Page 6: Personal Information Modality Information
        onView(withId(R.id.preferName))
                .perform(typeText(preferredNameToBeTyped));
        onView(withId(R.id.etgender))
                .perform(typeText(gender));
        onView(withId(R.id.etage))
                .perform(typeText(age));
        //choose modality
        onView(withId(R.id.modalityBtn))
                .perform(click());

//        ListView listView = alertDialog.getListView();
//        View child = listView.getChildAt(0);
//        child.performClick();

        onView(withId(R.id.NextBtn1))
                .perform(click());
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